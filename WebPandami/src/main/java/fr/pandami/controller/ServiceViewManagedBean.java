package fr.pandami.controller;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.FilterMeta;

import fr.pandami.entity.Service;
import fr.pandami.ibusiness.ServiceIBusiness;

@ManagedBean (name = "mbView")
@RequestScoped
public class ServiceViewManagedBean implements Serializable{

	
	private static final long serialVersionUID = 1L;

	private List<Service> services;
	private List<FilterMeta> filterBy;
	
	@EJB
	private ServiceIBusiness proxyServiceBU;
	
	
	@PostConstruct
	public void init() {
		services = proxyServiceBU.listServices();
		
		 filterBy = new ArrayList<>();

	      

	       

	}


	public List<Service> getServices() {
		return services;
	}


	public void setServices(List<Service> services) {
		this.services = services;
	}
	
	
}
