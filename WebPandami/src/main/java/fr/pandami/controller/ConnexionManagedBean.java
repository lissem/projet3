package fr.pandami.controller;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.faces.bean.ManagedBean;

import fr.pandami.entity.Address;
import fr.pandami.entity.User;
import fr.pandami.ibusiness.AccountIBusiness;
import fr.pandami.ibusiness.ReferentialIBusiness;


@ManagedBean (name = "mbConnexion", eager=true)
@SessionScoped
public class ConnexionManagedBean implements Serializable{

	private static final long serialVersionUID = 1L;


	private User user = new User();
	private String password;
	private String email;
	private Map<String, Integer> adressesMap = new HashMap<String, Integer>();
	private List<Address> adresses = new ArrayList<>();
	private int userId;
	private String message= ""; 


	@EJB
	private AccountIBusiness proxyCompteBu;

	@EJB
	private ReferentialIBusiness proxyReferentialBU;

	@PostConstruct
	public void init() {
		adressesMap = new HashMap<>();
		adresses = proxyReferentialBU.listAdresses();
		for (Address address : adresses) {
			adressesMap.put(address.toDisplay(), address.getId());
		}
		user.setBirthDate(LocalDate.now());
	}

	public String connexion() {


		user = proxyCompteBu.connexion(email, password);
		String retour = "";


		if (user != null) {
			retour = "/ServiceView.xhtml?faces-redirect=true";
			userId = user.getId();
		} else {
			user = new User(); 
			message = "email ou mot de passe incorrect";
			retour = "/";
		}
		return retour;
	}
	
	public String disconnect() {
		 setUser(null);
		 setUserId(userId);
	     ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true)).invalidate();
	     FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	     return "/accueil.xhtml?faces-redirect=true";
		}

	public Map<String, Integer> getAdressesMap() {
		return adressesMap;
	}

	public void setAdressesMap(Map<String, Integer> adressesMap) {
		this.adressesMap = adressesMap;
	}

	public String create() {
		System.out.println("test create");
		user = proxyCompteBu.creation(user);
		if(user == null) {
			message = "Un compte existe déjà avec cette adresse email";
		}else {
			message = "Merci " + user.getEmail() + ". Votre compte a été créé avec succès";
			userId = user.getId();
		}
		return "/espace-user.xhtml?faces-redirect=true";
	}
	
	public String roger() {
		email="roger@thewall.com";
		password="azerty2+";
		return connexion();
			}
	public String david() {
		email="david@divisionbell.com";
		password="azerty2+";
		return connexion();
			}
	public String nick() {
		email="nick@momentarylapse.com";
		password="azerty2+";
		return connexion();
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

	public List<Address> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Address> adresses) {
		this.adresses = adresses;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}