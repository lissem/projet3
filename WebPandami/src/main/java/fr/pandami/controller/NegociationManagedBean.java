package fr.pandami.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import fr.pandami.entity.Negociation;
import fr.pandami.entity.Service;
import fr.pandami.entity.User;
import fr.pandami.ibusiness.NegociationIBusiness;
import fr.pandami.ibusiness.ServiceIBusiness;

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
	
	public String update() {
		nego.setVolunteer(user);
		nego.setBeneficiary(service.getCreator());
		nego.setService(getService());
		if (nego.getCreationLocalDateTime() == null) {
			nego.setCreationLocalDateTime(service.getStartDate());
		}
		if (nego.getClosingLocalDateTime() == null) {
			nego.setClosingLocalDateTime(service.getEndDate());
		}
		if (nego.getProposedStartLocalDateTime() == null) {
			nego.setProposedStartLocalDateTime(service.getStartTime());
		}
		if (nego.getProposedEndLocalDateTime() == null) {
			nego.setProposedEndLocalDateTime(service.getEndTime());
		}
		nego = proxyNego.update(nego);
		negoId = nego.getId();
		message = "Modification enregistrée";
		 return "/negociation.xhtml?face-redirect=true";
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
