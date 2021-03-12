package fr.pandami.controller;

import java.io.Serializable;


import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;

import fr.pandami.entity.User;
import fr.pandami.ibusiness.AccountIBusiness;


@ManagedBean (name = "mbConnexion", eager=true)
@SessionScoped
public class ConnexionManagedBean implements Serializable{

	private static final long serialVersionUID = 1L;
		
	private User user;
	private String password;
	private String email;
	
	private String message= ""; 

	@EJB
	private AccountIBusiness proxyCompteBu;
	
	public String connexion() {
	
		user = proxyCompteBu.connexion(email, password);
		String retour = "";
		
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}