package fr.pandami.controller;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.convert.Converter;
import javax.faces.event.PreRemoveFromViewEvent;

import fr.pandami.entity.Availability;
import fr.pandami.entity.User;
import fr.pandami.ibusiness.AccountIBusiness;

@ManagedBean (name="mbDispo")
@ViewScoped
public class DisponibiliteManagedBean implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private Integer dayOfTheWeek;
	private User user;
	private List<Availability> availabilities;
	private Availability availabilitySelected=new Availability();
	private Map<String, Integer> mapJours=new HashMap<String, Integer>();

	private Availability availability= new Availability();
	//private DayOfWeek[] jours=DayOfWeek.values();
	List <String> jours=new ArrayList<String>();
	      
	@ManagedProperty(value = "#{mbConnexion.userId}")
	private int user_Id;
	
	@EJB
	private AccountIBusiness proxyAccountIBusiness;
	
	
@PostConstruct
     public void init() {
	user=proxyAccountIBusiness.getUser(user_Id);

    jours.add("lundi");
	jours.add("mardi");
	jours.add("mercredi");
	jours.add("jeudi");
	jours.add("vendredi");
	jours.add("samedi");
	jours.add("dimanche");
	 for (int i = 0; i < jours.size(); i++) {
		mapJours.put(jours.get(i), i+1);
	}
		
		availabilities=proxyAccountIBusiness.displayAvailabilities(user);
  
}


	public String createAvailability() {

		
		availability.setUser(user);
		
		availability.setDay(jours.get(availability.getDayOfTheWeek()-1));
		availability=proxyAccountIBusiness.createAvailability(availability);
	 
		
		return"disponibilites.xhtml?faces-redirect=true";
	}
   
	public String updateAvailability() {
		availabilitySelected=proxyAccountIBusiness.updateAvailability(availabilitySelected);
		
		return"disponibilites.xhtml?faces-redirect=true";
	}
	
	public String deleteAvailability() {
		proxyAccountIBusiness.deleteAvailability(availabilitySelected);
		
		return"disponibilites.xhtml?faces-redirect=true";
		
	}
	
	


	public Availability getAvailability() {
		return availability;
	}

	public void setAvailability(Availability availability) {
		this.availability = availability;
	}




	public Integer getDayOfTheWeek() {
		return dayOfTheWeek;
	}




	public void setDayOfTheWeek(Integer dayOfTheWeek) {
		this.dayOfTheWeek = dayOfTheWeek;
	}


	public List<String> getJours() {
		return jours;
	}


	public void setJours(List<String> jours) {
		this.jours = jours;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public int getUser_Id() {
		return user_Id;
	}


	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}


	public List<Availability> getAvailabilities() {
		return availabilities;
	}


	public void setAvailabilities(List<Availability> availabilities) {
		this.availabilities = availabilities;
	}


	public Availability getAvailabilitySelected() {
		return availabilitySelected;
	}


	public void setAvailabilitySelected(Availability availabilitySelected) {
		this.availabilitySelected = availabilitySelected;
	}




	public Map<String, Integer> getMapJours() {
		return mapJours;
	}




	public void setMapJours(Map<String, Integer> mapJours) {
		this.mapJours = mapJours;
	}




	



	
	
	
	
	
	

}
