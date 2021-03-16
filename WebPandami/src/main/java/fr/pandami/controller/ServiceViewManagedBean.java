package fr.pandami.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import fr.pandami.entity.Service;
import fr.pandami.entity.User;
import fr.pandami.ibusiness.AccountIBusiness;
import fr.pandami.ibusiness.ServiceIBusiness;

@ManagedBean (name = "mbView")
@RequestScoped
public class ServiceViewManagedBean implements Serializable{


	private static final long serialVersionUID = 1L;

	private List<Service> services;
	private User user = new User();
	private String viewId="";

	@ManagedProperty (value = "#{mbConnexion.userId}")
	private int userId;


	@EJB
	private ServiceIBusiness proxyServiceBU;
	@EJB
	private AccountIBusiness proxyAccountBU;
	


	@PostConstruct
	public void init() {
		FacesContext fc = FacesContext.getCurrentInstance();
        viewId = getviewIdParam(fc);
        System.out.println("viewID = "+viewId);
        
		services = proxyServiceBU.listServices((viewId==null)? 0:Integer.parseInt(viewId), userId);
		user = proxyAccountBU.getUser(userId);


	}

	public String getviewIdParam(FacesContext fc){
        
        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
        return params.get("viewId");
        
    }
	
	public static double distance(double lat1, double lat2, double lon1,
			double lon2) {

		final int R = 6371; // Radius of the earth

		double latDistance = Math.toRadians(lat2 - lat1);
		double lonDistance = Math.toRadians(lon2 - lon1);
		double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
				+ Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
				* Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double distance = R * c * 1000; // convert to meters



		distance = Math.pow(distance, 2); 

		return Math.sqrt(distance);
	}

	public List<Service> getServices() {
		return services;
	}


	public void setServices(List<Service> services) {
		this.services = services;
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
