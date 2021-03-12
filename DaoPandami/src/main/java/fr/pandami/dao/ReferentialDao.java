package fr.pandami.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.pandami.entity.Address;
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

}
