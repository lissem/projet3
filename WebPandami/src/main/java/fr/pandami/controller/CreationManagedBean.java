package fr.pandami.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import fr.pandami.entity.Address;
import fr.pandami.entity.User;
import fr.pandami.ibusiness.AccountIBusiness;
import fr.pandami.ibusiness.ReferentialIBusiness;

// PLUS UTILISE
@ManagedBean(name="mbCreation")
public class CreationManagedBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String message = "";
	public User user = new User();
	private Map<String, Integer> adressesMap = new HashMap<String, Integer>();
	private List<Address> adresses = new ArrayList<>();

	@EJB
	private AccountIBusiness proxyAccountBU;
	
	@EJB
	private ReferentialIBusiness proxyReferentialBU;
	

	@PostConstruct
	public void init() {
		adressesMap = new HashMap<>();
		adresses = proxyReferentialBU.listAdresses();
		for (Address address : adresses) {
			adressesMap.put(address.toString(), address.getId());
		}
	}
	
	public Map<String, Integer> getAdressesMap() {
		return adressesMap;
	}

	public void setAdressesMap(Map<String, Integer> adressesMap) {
		this.adressesMap = adressesMap;
	}

	public String create() {
		user = proxyAccountBU.creation(user);
		if(user == null) {
			message = "Un compte existe déjà avec cette adresse email";
		}else {
			message = "Merci " + user.getEmail() + ". Votre compte a été créé avec succès";
		}
		user = new User();
		return "/espace-user.xhtml?faces-redirect=true";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
