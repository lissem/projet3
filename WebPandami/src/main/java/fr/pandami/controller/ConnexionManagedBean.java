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
	
	private String login;
	private String password;
	private Utilisateur utilisateur;

	@EJB
	private CompteIBusiness proxyCompteBu;
	
		
		

}

