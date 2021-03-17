package fr.pandami.controller;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;


import fr.pandami.entity.PreferenceService;
import fr.pandami.entity.ServiceType;
import fr.pandami.entity.User;
import fr.pandami.ibusiness.PreferenceServiceIBusiness;
import fr.pandami.ibusiness.ReferentialIBusiness;


@ManagedBean (name = "mbPrefService")
@RequestScoped
public class PrefServiceManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private PreferenceService prefService;
	private LocalDate endDate; 
	private List<ServiceType> serviceTypes = new ArrayList<>();
    private ServiceType[] selectedTypes;
    private String message = "";
    
	@ManagedProperty (value = "#{mbConnexion.userId}")
	private int userId;
	
	@ManagedProperty (value = "#{mbConnexion.user}")
	private User user;
	
	@EJB
	private PreferenceServiceIBusiness proxyPrefService;
	
	@EJB
	private ReferentialIBusiness proxyReferentialBU;
	
	public String addPrefService() {
		proxyPrefService.addPrefService(selectedTypes, user);
		message = "ça marche gros!";
		return "/prefService.xhtml?faces-redirect=true";
	}
	
	@PostConstruct
	public void init() {
		selectedTypes = proxyPrefService.getSelectedTypes(user);
		serviceTypes = proxyReferentialBU.listTypes();
	}
	
	public PreferenceService getPrefService() {
		return prefService;
	}

	public void setPrefService(PreferenceService prefService) {
		this.prefService = prefService;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public List<ServiceType> getServiceTypes() {
		return serviceTypes;
	}

	public void setServiceTypes(List<ServiceType> serviceTypes) {
		this.serviceTypes = serviceTypes;
	}

	public ServiceType[] getSelectedTypes() {
		return selectedTypes;
	}

	public void setSelectedTypes(ServiceType[] selectedTypes) {
		this.selectedTypes = selectedTypes;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

}
