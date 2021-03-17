package fr.pandami.controller;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import fr.pandami.entity.Service;
import fr.pandami.entity.User;
import fr.pandami.ibusiness.ServiceIBusiness;

@ManagedBean(name = "mbSub")
@ViewScoped
public class SubscribeManagedBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String serviceId;
	private Service service;
	
	@ManagedProperty(value = "#{mbConnexion.User}" )
	private User user;
	
	@EJB
	private ServiceIBusiness proxyServiceBU;
	
	//@EJB
	//private SubscriptionIBusiness proxySubscriptionBU;
	
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
}
