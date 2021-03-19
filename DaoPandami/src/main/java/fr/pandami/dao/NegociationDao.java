package fr.pandami.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.pandami.entity.Negociation;
import fr.pandami.idao.NegociationIDao;

@Remote(NegociationIDao.class)
@Stateless
public class NegociationDao implements NegociationIDao{
	
	@PersistenceContext(unitName = "PUPandami")
	private EntityManager em;
	
	@Override
	public Negociation handshake(Negociation nego) {
		try {
			em.persist(nego);	
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return nego;
	}

	@Override
	public Boolean answer() {
		if (1 == 1) {
			Query query= em.createQuery("" );
		} else {
			Query query2= em.createQuery("");
		}
		return null;
	}
	
	@Override
	public Negociation update(Negociation nego) {
		return em.merge(nego);
	}

}
