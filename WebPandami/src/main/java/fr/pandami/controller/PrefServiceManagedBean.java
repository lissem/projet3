package fr.pandami.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import fr.pandami.entity.PreferenceService;
import fr.pandami.ibusiness.PreferenceServiceIBusiness;


@ManagedBean (name = "mbPrefService")
@RequestScoped
public class PrefServiceManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private PreferenceService prefService;
	
	@ManagedProperty (value = "#{mbConnexion.userId}")
	private int userId;
	
	@EJB
	private PreferenceServiceIBusiness proxyPrefService;
	
	public String addPrefService() {
		proxyPrefService.addPrefService(prefService);
		
		return "/prefService.xhtml?faces-redirect=true";
		
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
	

}
