package fr.pandami.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.pandami.entity.Negociation;
import fr.pandami.entity.Service;
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
	public Negociation update(Negociation nego) {
		return em.merge(nego);
	}


	@Override
	public List<Negociation> getActiveNegociation(Service service) {
		Query query = em.createQuery("SELECT n FROM Negociation n WHERE n.service = :paramservice AND closingLocalDateTime = NULL");
		query.setParameter("paramservice", service);
		return query.getResultList();
	}

}
