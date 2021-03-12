package fr.pandami.controller;

import java.io.Serializable;


import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import fr.pandami.entity.User;
import fr.pandami.ibusiness.AccountIBusiness;


@ManagedBean (name = "mbConnexion")
@SessionScoped
public class ConnexionManagedBean implements Serializable{

	private static final long serialVersionUID = 1L;
		
	private User user = new User();

	
	private String message= ""; 


	@EJB
	private AccountIBusiness proxyCompteBu;
	
	public String connexion() {
		user = proxyCompteBu.connexion(user.getEmail(), user.getPassword());

		
	
		String retour = "index.xhtml?faces-redirect=true";

		
		if (user != null) {
			retour = "/espace-user.xhtml?faces-redirect=true";
		} else {
			user = new User(); 
			message = "email ou mot de passe incorrect";
			retour = "/";
		}
		return retour;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}