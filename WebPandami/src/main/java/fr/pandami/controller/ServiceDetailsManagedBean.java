package fr.pandami.controller;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import fr.pandami.entity.Service;
import fr.pandami.ibusiness.ServiceIBusiness;

@ManagedBean(name = "mbDetails")
@RequestScoped
public class ServiceDetailsManagedBean {
	
	Service service;
	private int serviceId;
	 LatLng coord1;
	 private MapModel simpleModel;
	 
	 @ManagedProperty (value = "#{mbConnexion.userId}")
		private int userId;
	 
	@EJB
	private ServiceIBusiness proxyServiceBU;

	@PostConstruct
	public void init() {
		FacesContext fc = FacesContext.getCurrentInstance();
        this.serviceId = Integer.parseInt(getServiceIdParam(fc));
		service = proxyServiceBU.getService(serviceId);
		 coord1 = new LatLng(service.getAddress().getLatitude(), service.getAddress().getLongitude());
		 simpleModel = new DefaultMapModel();
		 simpleModel.addOverlay(new Marker(coord1, service.getAddress().toDisplay()));

	
	}

	 public String getServiceIdParam(FacesContext fc){
	        
	        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
	        return params.get("serviceId");
	        
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
	
	
}
