package fr.pandami.business;

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
	public List<Service> listServices() {
				return proxyServiceIDao.getAllServices();
	}

	@Override
	public Service getService(int serviceId) {
		return proxyServiceIDao.getServiceById(serviceId);
	}

}
