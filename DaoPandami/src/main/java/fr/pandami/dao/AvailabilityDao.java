package fr.pandami.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.pandami.entity.Availability;
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

}
