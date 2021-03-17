package fr.pandami.business;

import java.time.LocalDateTime;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import fr.pandami.entity.Service;
import fr.pandami.ibusiness.ServiceIBusiness;
import fr.pandami.idao.ServiceIDao;

@Remote(ServiceIBusiness.class)
@Stateless
public class ServiceBusiness implements ServiceIBusiness{
	
	@EJB
	private ServiceIDao proxyServiceIDao;

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
			return proxyServiceIDao.getAllServicesWithNoActiveSubcription(userId);
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
