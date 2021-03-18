package fr.pandami.idao;

import java.util.List;

import fr.pandami.entity.Service;

public interface ServiceIDao {

	 void addService(Service service);

	List<Service> getAllServices();

	Service getServiceById(int serviceId);

	List<Service> getMyActiveDemands(int userId);

	List<Service> getMyActiveSubcriptions(int userId);

	List<Service> getAllServicesWithNoActiveSubcription(int userId);

	void update(Service service);
	

}
