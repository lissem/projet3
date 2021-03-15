package fr.pandami.controller;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import fr.pandami.entity.Service;
import fr.pandami.ibusiness.ServiceIBusiness;

@ManagedBean(name = "mbDetails")
@RequestScoped
public class ServiceDetailsManagedBean {
	
	Service service;
	private int serviceId;
	
	@EJB
	private ServiceIBusiness proxyServiceBU;

	@PostConstruct
	public void init() {
		FacesContext fc = FacesContext.getCurrentInstance();
        this.serviceId = getServiceIdParam(fc);
		service = proxyServiceBU.getService(serviceId);

	}

	 public int getServiceIdParam(FacesContext fc){
	        
	        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
	        return params.get("serviceId");
	        
	    }
	
	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}
	
	
}
