package fr.pandami.controller;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import fr.pandami.entity.Negociation;
import fr.pandami.entity.Service;
import fr.pandami.entity.User;
import fr.pandami.ibusiness.NegociationIBusiness;
import fr.pandami.ibusiness.ReferentialIBusiness;
import fr.pandami.ibusiness.ServiceIBusiness;
import fr.pandami.ibusiness.SubscriptionIBusiness;

@ManagedBean(name = "mbDetails")
@ViewScoped
public class ServiceDetailsManagedBean implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private Service service;
	private String serviceId;

	private Map<String, LocalDateTime> NegoTupple = new HashMap<>(); 
	private List<String[]> negoList = new ArrayList<String[]>();
	
	private LatLng coord1;
	private MapModel simpleModel;
	private User volunteer;
	private Negociation negociation;

	@ManagedProperty (value = "#{mbConnexion.userId}")
	private int userId;

	@EJB
	private ServiceIBusiness proxyServiceBU;

	@EJB
	private ReferentialIBusiness proxyReferentialBU;

	@EJB 
	private NegociationIBusiness proxyNego; 
	
	@EJB
	private SubscriptionIBusiness proxySub;

	@PostConstruct
	public void init() {
		FacesContext fc = FacesContext.getCurrentInstance();
		serviceId = getServiceIdParam(fc);
		service = (serviceId==null) ? service: proxyServiceBU.getService(Integer.parseInt(serviceId));

		coord1 = new LatLng(service.getAddress().getLatitude(), service.getAddress().getLongitude());
		simpleModel = new DefaultMapModel();
		simpleModel.addOverlay(new Marker(coord1, service.getAddress().toDisplay()));
		updateVolunteer();
		getNegoFromDB();
		}
	
	public User getSubscriber() {
		return proxySub.getSubscriber(service.getId()); 
	}
	
	private void updateVolunteer() {
	this.volunteer= proxySub.getVolunteer(service.getId());
	}
	
	public String getServiceIdParam(FacesContext fc){
		Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
		return params.get("serviceId");
	}

	public void getNegoFromDB() {
		negociation = proxyNego.getActiveNego(service.getId());

	}

	public String delete() {

		proxyServiceBU.delete(service);
		return "/ServiceView?viewId=1&faces-redirect=true";
	}
	
	public String acceptNego() {
		negociation.setAccepted(true);
		proxyNego.update(negociation);
		if (negociation.getProposedStartTime()!=service.getStartTime()) {
			service.setStartTime(negociation.getProposedStartTime());
		}
		if (negociation.getProposedEndTime()!=service.getEndTime()) {
			service.setEndTime(negociation.getProposedEndTime());
		}
		if (negociation.getProposedStartDate()!=service.getStartDate()) {
			service.setStartDate(negociation.getProposedStartDate());
			service.setEndDate(negociation.getProposedStartDate());
		}
		proxyServiceBU.updateService(service);
		
		return "serviceDetails.xhtml?faces-redirect=true&serviceId="+service.getId().toString();
		
	}
	
	public String refuseNego() {
		negociation.setAccepted(false);
		proxyNego.update(negociation);
		
		return "serviceDetails.xhtml?faces-redirect=true&serviceId="+service.getId().toString();
	}

	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public LatLng getCoord1() {
		return coord1;
	}

	public void setCoord1(LatLng coord1) {
		this.coord1 = coord1;
	}

	public MapModel getSimpleModel() {
		return simpleModel;
	}

	public void setSimpleModel(MapModel simpleModel) {
		this.simpleModel = simpleModel;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public Map<String, LocalDateTime> getNegoTupple() {
		return NegoTupple;
	}

	public void setNegoTupple(Map<String, LocalDateTime> negoTupple) {
		NegoTupple = negoTupple;
	}

	public List<String[]> getNegoList() {
		return negoList;
	}

	public void setNegoList(List<String[]> negoList) {
		this.negoList = negoList;
	}

	public User getVolunteer() {
		return volunteer;
	}

	public void setVolunteer(User volunteer) {
		this.volunteer = volunteer;
	}

	public Negociation getNegociation() {
		return negociation;
	}

	public void setNegociation(Negociation negociation) {
		this.negociation = negociation;
	}
}

