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
		
	private String email = "";
	private String password = "";
	private User user = new User();
	private String message ;

	@EJB
	private AccountIBusiness proxyCompteBu;
	
	public String connexion() {
		user = proxyCompteBu.connexion(user.getEmail(), user.getPassword());
		String retour = null;
		//String message = null; 
		
		if (user != null) {
			retour = "/espace-user.xhtml?faces-redirect=true";
		} else {
			user = new User(); 
			message = "email ou mot de passe incorrect";
			retour = "index.xhtml?faces-redirect=true";
		}
		return retour;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}