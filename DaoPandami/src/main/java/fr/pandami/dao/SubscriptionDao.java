package fr.pandami.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.pandami.entity.Subscription;
import fr.pandami.idao.SubscriptionIDao;

@Remote(SubscriptionIDao.class)
@Stateless
public class SubscriptionDao implements SubscriptionIDao{
	
	@PersistenceContext(unitName="PUPandami")
	private EntityManager em;

	@Override
	public Subscription createSub(Subscription subscription) {
		try {
			em.persist(subscription);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return subscription;
	}

}
