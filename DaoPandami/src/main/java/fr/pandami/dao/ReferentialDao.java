package fr.pandami.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.pandami.entity.Address;
import fr.pandami.entity.CancellationCause;
import fr.pandami.entity.Equipment;
import fr.pandami.entity.ServiceType;
import fr.pandami.idao.ReferentialIDao;

@Remote(ReferentialIDao.class)
@Stateless
public class ReferentialDao implements ReferentialIDao{
	
	@PersistenceContext(unitName = "PUPandami")
	private EntityManager em;
	
	@Override
	public List<Address> getAllAdresses() {
		Query query = em.createQuery("SELECT a From Address a");
		return query.getResultList();
	}

	@Override
	public List<ServiceType> getAllTypes() {
		Query query = em.createQuery("SELECT a From ServiceType a");
		return query.getResultList();
	}

	@Override
	public List<Equipment> getAllEquipments() {
		Query query = em.createQuery("SELECT a From Equipment a");
		return query.getResultList();
	}

	@Override
	public List<CancellationCause> getAllCauses() {
		Query query = em.createQuery("SELECT a From CancellationCause a");
		return query.getResultList();
	}


}
