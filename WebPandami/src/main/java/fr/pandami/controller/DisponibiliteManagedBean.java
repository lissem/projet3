package fr.pandami.controller;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import fr.pandami.entity.Availability;
import fr.pandami.entity.Jour;
import fr.pandami.ibusiness.AccountIBusiness;

@ManagedBean (name="mbDispo")
public class DisponibiliteManagedBean implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	//private Integer dayOfTheWeek;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private Jour [] jours= Jour.values();
	private Availability availability;
	
	@EJB
	private AccountIBusiness proxyAccountIBusiness;
	
	public String createAvailability() {
		availability=proxyAccountIBusiness.createAvailability(availability);
		Availability availability=new Availability();
		return"disponibilites.xhtml?faces-redirect=true";
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public Jour[] getJours() {
		return jours;
	}

	public void setJours(Jour[] jours) {
		this.jours = jours;
	}

	public Availability getAvailability() {
		return availability;
	}

	public void setAvailability(Availability availability) {
		this.availability = availability;
	}
	
	
	
	
	
	

}
