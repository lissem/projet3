package fr.pandami.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.pandami.entity.Availability;
import fr.pandami.entity.User;
import fr.pandami.idao.AvailabilityIDao;
@Remote(AvailabilityIDao.class)
@Stateless
public class AvailabilityDao implements AvailabilityIDao {
	
	@PersistenceContext(unitName = "PUPandami")
	private EntityManager em;
	
	
	
	@Override
	public Availability addAvailability(Availability dispo) {
		try {
			em.persist(dispo);	
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return dispo;
	}



	@Override
	public List<Availability> getAvailabilities(User user) {
		Query query= em.createQuery("SELECT a FROM Availability a where a.user = :paramuser AND a.validityEndDate >= current_date" );
		query.setParameter("paramuser", user);
		return query.getResultList();
	}



	@Override
	public Availability updateAv(Availability availability) {
		 availability= em.merge(availability);
		 return availability;
	}



	@Override
	public void deleteAv(Availability availability) {
		availability=em.merge(availability);
		em.remove(availability);	
	}

}
