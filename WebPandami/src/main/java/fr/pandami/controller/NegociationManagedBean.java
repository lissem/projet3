package fr.pandami.controller;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import fr.pandami.entity.Negociation;
import fr.pandami.entity.Service;
import fr.pandami.entity.User;
import fr.pandami.ibusiness.NegociationIBusiness;
import fr.pandami.ibusiness.ServiceIBusiness;
import fr.pandami.ibusiness.SubscriptionIBusiness;

@ManagedBean (name = "mbNego", eager=true)
@RequestScoped
public class NegociationManagedBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private Negociation nego = new Negociation(); 

	@ManagedProperty (value = "#{mbService.service}")
	private Service service; 

	private int negoId; 

	private String serviceId = "";
	private String message = ""; 

	@ManagedProperty (value = "#{mbConnexion.user}")
	private User user;

	@EJB
	private NegociationIBusiness proxyNego;

	@EJB ServiceIBusiness proxyService;

	@EJB SubscriptionIBusiness proxySub; 

	public String update() {
		nego.setAsker(user);
		if (user == service.getCreator()) {
			nego.setAnswerer(proxySub.getVolunteer(service.getId()));
		} else {
			nego.setAnswerer(service.getCreator());
		}
		nego.setService(getService());
		if (nego.getProposedStartDate() == null) {
			nego.setProposedStartDate(service.getStartDate());
		}
		if (nego.getProposedEndDate() == null) {
			nego.setProposedEndDate(service.getEndDate());
		}
		if (nego.getProposedStartTime() == null) {
			nego.setProposedStartTime(service.getStartTime());
		}
		if (nego.getProposedEndTime() == null) {
			nego.setProposedEndTime(service.getEndTime());
		}
		nego = proxyNego.update(nego);
		negoId = nego.getId();
		message = "Négociation enregistrée";
		
	
		return "serviceDetails.xhtml?faces-redirect=true&serviceId="+service.getId().toString();
	}
	
	

	public Negociation getNego() {
		return nego;
	}

	public void setNego(Negociation nego) {
		this.nego = nego;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getNegoId() {
		return negoId;
	}

	public void setNegoId(int negoId) {
		this.negoId = negoId;
	}

}
