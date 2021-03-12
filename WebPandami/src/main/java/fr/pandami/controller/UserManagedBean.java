package fr.pandami.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import fr.pandami.entity.User;
import fr.pandami.ibusiness.AccountIBusiness;

@ManagedBean (name = "mbUser")
@RequestScoped
public class UserManagedBean {

	
	private User user;
	@ManagedProperty (value = "#{mbConnexion.user}")
    private User userConnected;


	@EJB
	private AccountIBusiness proxyAccountBU;
	
	

	public String display(User user) {
		 user = proxyAccountBU.display(user);
		 return user.toString();
	}



	public User getUserConnected() {
		return userConnected;
	}



	public void setUserConnected(User userConnected) {
		this.userConnected = userConnected;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}
	

}
