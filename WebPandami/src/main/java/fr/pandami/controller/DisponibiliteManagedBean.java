package fr.pandami.controller;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import fr.pandami.entity.Availability;

import fr.pandami.ibusiness.AccountIBusiness;

@ManagedBean (name="mbDispo")
public class DisponibiliteManagedBean implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private Integer dayOfTheWeek;
	
	
	private Availability availability;
	//private DayOfWeek[] jours=DayOfWeek.values();
	List <String> jours=new ArrayList<String>();
	
	
      
	
	@EJB
	private AccountIBusiness proxyAccountIBusiness;
	
	
@PostConstruct
     public void init() {
	jours.add("samedi");
    jours.add("lundi");
	jours.add("mardi");
	jours.add("mercredi");
	jours.add("jeudi");
	jours.add("vendredi");
}

	
	public String createAvailability() {
		availability=proxyAccountIBusiness.createAvailability(availability);
	
		
		Availability availability=new Availability();
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




	



	
	
	
	
	
	

}
