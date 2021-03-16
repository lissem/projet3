package fr.pandami.ibusiness;

import java.util.List;

import fr.pandami.entity.Service;

public interface ServiceIBusiness {

	void creation(Service service);

	List<Service> listServices(Integer viewId, int userId);

	Service getService(int serviceId);

}
