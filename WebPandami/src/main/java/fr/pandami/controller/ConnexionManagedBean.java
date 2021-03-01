package fr.pandami.controller;

import java.io.Serializable;


import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import fr.pandami.entity.Utilisateur;
import fr.pandami.ibusiness.CompteIBusiness;


@ManagedBean (name = "mbConnexion")
@SessionScoped
public class ConnexionManagedBean implements Serializable{

	private static final long serialVersionUID = 1L;
		
	private String email = "";
	private String password = "";
	private Utilisateur utilisateur;
	private String message = ""; 

	@EJB
	private CompteIBusiness proxyCompteBu;
	
	public String connexion(String email, String password) {
		utilisateur = proxyCompteBu.connexion(email, password);
		String retour = null;
		
		if (utilisateur != null) {
			retour = "/espace-utilisateur.xhtml?faces-redirect=true";
		} else {
			utilisateur = new Utilisateur(); 
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

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
}