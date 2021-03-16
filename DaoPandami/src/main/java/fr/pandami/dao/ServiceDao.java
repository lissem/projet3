package fr.pandami.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.pandami.entity.Service;
import fr.pandami.idao.ServiceIDao;

@Remote(ServiceIDao.class)
@Stateless
public class ServiceDao implements ServiceIDao{
	
	@PersistenceContext(unitName = "PUPandami")
	private EntityManager em;

	@Override
	public void addService(Service service) {
		try {
			em.persist(service);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Service> getAllServices() {
		Query query = em.createQuery("SELECT a From Service a");
		return query.getResultList();
	}

	@Override
	public Service getServiceById(int serviceId) {
		
		return em.find(Service.class, serviceId);
	}

	@Override
	public List<Service> getMyActiveDemands(int userId) {
		Query query = em.createQuery("SELECT s FROM Service s WHERE s.creator.id = :paramidcreator AND s.startDate >= current_date");
		query.setParameter("paramidcreator", userId);
		return query.getResultList();
	}

	@Override
	public List<Service> getMyActiveSubcriptions(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Service> getAllServicesWithNoActiveSubcription(int userId) {
		Query query = em.createQuery("SELECT s FROM Service s WHERE s.creator.id != :paramidcreator");
		query.setParameter("paramidcreator", userId);
		return query.getResultList();
	}

}
