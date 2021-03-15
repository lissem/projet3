package fr.pandami.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import fr.pandami.entity.Address;
import fr.pandami.entity.Equipment;
import fr.pandami.entity.Service;
import fr.pandami.entity.ServiceType;
import fr.pandami.entity.User;
import fr.pandami.ibusiness.ReferentialIBusiness;
import fr.pandami.ibusiness.ServiceIBusiness;

@ManagedBean (name = "mbService")
@RequestScoped
public class ServiceManagedBean implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	
	private Service service = new Service();
	private List<ServiceType> types;
	private List<Equipment> equipments;
	private List<Address> adresses;

	
	@EJB
	private ReferentialIBusiness proxyReferentialBU;
	
	@EJB
	private ServiceIBusiness proxyServiceBU;
	

	
	@ManagedProperty(value = "#{mbConnexion.user}")
	private User connectedUser;

	@PostConstruct
	public void init() {
		types = proxyReferentialBU.listTypes();
		equipments = proxyReferentialBU.listEquipments();
		adresses = proxyReferentialBU.listAdresses();
	}

	public String createService() {
		System.out.println("dans le create");
		service.setEndDate(service.getStartDate());
		service.setCreator(connectedUser);
		proxyServiceBU.creation(service);
		
		return "/espace-user.xhtml?faces-redirect=true";
		
	}
	
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	public List<ServiceType> getTypes() {
		return types;
	}
	public void setTypes(List<ServiceType> types) {
		this.types = types;
	}
	public List<Address> getAdresses() {
		return adresses;
	}
	public void setAdresses(List<Address> adresses) {
		this.adresses = adresses;
	}
	public User getConnectedUser() {
		return connectedUser;
	}

	public void setConnectedUser(User connectedUser) {
		this.connectedUser = connectedUser;
	}

	public List<Equipment> getEquipments() {
		return equipments;
	}

	public void setEquipments(List<Equipment> equipments) {
		this.equipments = equipments;
	}




}
