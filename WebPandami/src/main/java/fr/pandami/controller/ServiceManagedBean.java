package fr.pandami.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import fr.pandami.entity.Address;
import fr.pandami.entity.Equipment;
import fr.pandami.entity.Service;
import fr.pandami.entity.ServiceType;
import fr.pandami.entity.User;
import fr.pandami.ibusiness.ReferentialIBusiness;
import fr.pandami.ibusiness.ServiceIBusiness;

@ManagedBean (name = "mbService")
@ViewScoped
public class ServiceManagedBean implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	
	private Service service;
	private String serviceId;
	private List<ServiceType> types;
	private List<Equipment> equipments;
	private List<Address> adresses;

	
	@EJB
	private ReferentialIBusiness proxyReferentialBU;
	
	@EJB
	private ServiceIBusiness proxyServiceBU;
	

	
	@ManagedProperty(value = "#{mbConnexion.user}")
	private User connectedUser;

	@PostConstruct
	public void init() {
		service=new Service();
		FacesContext fc = FacesContext.getCurrentInstance();
        this.serviceId = getServiceIdParam(fc);
		
		types = proxyReferentialBU.listTypes();
		equipments = proxyReferentialBU.listEquipments();
		adresses = proxyReferentialBU.listAdresses();
		service = (serviceId==null) ? service: proxyServiceBU.getService(Integer.parseInt(serviceId));
	}
	public String getServiceIdParam(FacesContext fc){
        
        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
        return params.get("serviceId");
        
    }

	public String createService() {
		if (service.getCreator().getId()==null) {
			System.out.println("dans le if");
			service.setEndDate(service.getStartDate());
			service.setCreator(connectedUser);
			proxyServiceBU.creation(service);
			
		}else {
			System.out.println("dans le else");
			proxyServiceBU.updateService(service);
		}
		
		
		
		return "/ServiceView?viewId=1&faces-redirect=true";
		
	}
	
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	public List<ServiceType> getTypes() {
		return types;
	}
	public void setTypes(List<ServiceType> types) {
		this.types = types;
	}
	public List<Address> getAdresses() {
		return adresses;
	}
	public void setAdresses(List<Address> adresses) {
		this.adresses = adresses;
	}
	public User getConnectedUser() {
		return connectedUser;
	}

	public void setConnectedUser(User connectedUser) {
		this.connectedUser = connectedUser;
	}

	public List<Equipment> getEquipments() {
		return equipments;
	}

	public void setEquipments(List<Equipment> equipments) {
		this.equipments = equipments;
	}
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	




}
