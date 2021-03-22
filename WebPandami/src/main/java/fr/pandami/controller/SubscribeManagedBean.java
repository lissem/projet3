package fr.pandami.controller;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import fr.pandami.entity.Service;
import fr.pandami.entity.Subscription;
import fr.pandami.entity.User;
import fr.pandami.ibusiness.AccountIBusiness;
import fr.pandami.ibusiness.ServiceIBusiness;
import fr.pandami.ibusiness.SubscriptionIBusiness;

@ManagedBean(name = "mbSub")
@ViewScoped
public class SubscribeManagedBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private String serviceId;
	private Service service;
	private Subscription sub = new Subscription();

	@ManagedProperty(value = "#{mbConnexion.user}" )
	private User user;

	@EJB
	private ServiceIBusiness proxyServiceBU;
	@EJB
	private SubscriptionIBusiness proxySubscriptionBU;
	@EJB
	private AccountIBusiness proxyAccountIBusiness;
	
	


	@PostConstruct
	public void init() {
		
		FacesContext fc = FacesContext.getCurrentInstance();
		serviceId = getServiceIdParam(fc);
		service = (serviceId==null) ? service: proxyServiceBU.getService(Integer.parseInt(serviceId));
	}

	public String getServiceIdParam(FacesContext fc){

		Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
		return params.get("serviceId");
	}
	
	
	
	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}
	
	
	
}
