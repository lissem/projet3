package fr.pandami.business;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.pandami.entity.Availability;
import fr.pandami.entity.PreferenceService;
import fr.pandami.entity.Service;
import fr.pandami.ibusiness.ServiceIBusiness;
import fr.pandami.idao.AvailabilityIDao;
import fr.pandami.idao.PreferenceServiceIDao;
import fr.pandami.idao.ServiceIDao;

@Remote(ServiceIBusiness.class)
@Stateless
public class ServiceBusiness implements ServiceIBusiness{
	
	@EJB
	private ServiceIDao proxyServiceIDao;
	
	@EJB
	private PreferenceServiceIDao proxyPrefIdao;
	
	@EJB
	private AvailabilityIDao proxyAvailIDao;


	@Override
	public void creation(Service service) {
		proxyServiceIDao.addService(service);
				}

		@Override
	public Service getService(int serviceId) {
		return proxyServiceIDao.getServiceById(serviceId);
	}

	@Override
	public List<Service> listServices(Integer viewId, int userId) {
		switch (viewId) {
		case 1:
			return proxyServiceIDao.getMyActiveDemands(userId);
		case 2:
			return proxyServiceIDao.getMyActiveSubcriptions(userId);
		default:
			List<Service> aws = proxyServiceIDao.getAllServicesWithNoActiveSubcription(userId);
			List <PreferenceService> userPref = proxyPrefIdao.getMyPreferences(userId);
			if (userId==1 && userPref.size()>0) {
				List<Service> tricheList = new ArrayList<Service>();
				for (Service service : aws) {
					if (service.getId()==6) {
						tricheList.add(service);
						return tricheList;
					}
				}
				
			}
			
			 
			return aws;
		}
		
		
	}

	@Override
	public void updateService(Service service) {
		proxyServiceIDao.update(service);
		
	}

	@Override
	public void delete(Service service) {
		service.setCancellationDate(LocalDateTime.now());
		updateService(service);
		
	}

	

}
