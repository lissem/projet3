package fr.pandami.dao;

import java.time.LocalDateTime;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.print.attribute.standard.DateTimeAtCreation;

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
			//dispo.setStartTime(LocalDateTime.now());
			em.persist(dispo);	
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return dispo;
	}



	@Override
	public List<Availability> getAvailabilities() {
		Query query= em.createQuery("SELECT a FROM Availability a");
		List<Availability> listeDispos=query.getResultList();
		return listeDispos;
	}



	@Override
	public Availability update(Availability availability) {
		
		return em.merge(availability);
	}

}
