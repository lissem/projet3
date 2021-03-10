package fr.pandami.controller;

import static fr.pandami.util.Utils.addDetailMessage;

import java.io.IOException;
import java.io.Serializable;


import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import org.omnifaces.util.Faces;

import com.github.adminfaces.template.config.AdminConfig;

import fr.pandami.entity.User;
import fr.pandami.ibusiness.AccountIBusiness;




@ManagedBean (name = "mbConnexion")
@SessionScoped
public class ConnexionManagedBean implements Serializable{

	private static final long serialVersionUID = 1L;
		
	private String email = "";
	private String password = "";
	private User user = new User();
	
	@Inject
    private AdminConfig adminConfig;
	private String currentUser;
	@EJB
	private AccountIBusiness proxyCompteBu;

	
	
	public String connexion() throws IOException {
		user = proxyCompteBu.connexion(email, password);
		String retour = null;
		String message = null; 
		
		if (user != null) {
			 currentUser = email;
		        addDetailMessage("Logged in successfully as <b>" + email + "</b>");
		        Faces.getExternalContext().getFlash().setKeepMessages(true);
		        Faces.redirect(adminConfig.getIndexPage());
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