package fr.pandami.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.pandami.entity.User;
import fr.pandami.ibusiness.AccountIBusiness;

@ManagedBean (name = "mbUser")
@RequestScoped
public class UserManagedBean implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private User user = new User();
	
	@ManagedProperty (value = "#{mbConnexion.userId}")
	private int userId;

	@EJB
	private AccountIBusiness proxyAccountBU;
	
	@PostConstruct
	public void init() {
		user = proxyAccountBU.getUser(userId);
	}
	
	public String update() {
		user.setId(userId);
		user = proxyAccountBU.update(user);
		 return "/espace-user.xhtml?faces-redirect=true";
	}

	public String disconnect() {
	 user = null;
     ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true)).invalidate();
     return "/accueil.xhtml?faces-redirect=true";
	}

	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}
	

}
