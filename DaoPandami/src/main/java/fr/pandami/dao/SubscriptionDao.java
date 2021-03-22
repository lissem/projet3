package fr.pandami.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.pandami.entity.Service;
import fr.pandami.entity.Subscription;
import fr.pandami.entity.User;
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



	@Override
	public Subscription cancelSub(Subscription subscription) {
		subscription=em.merge(subscription);
		
		return subscription;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Subscription>getSub(Service service) {
		Query query=em.createQuery("SELECT s.subscriptionList FROM Service s WHERE s.id=:paramService");
		query.setParameter("paramService", service.getId());
		return query.getResultList();

	}	

		

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getActiveVolunteer(Service service) {
		Query query = em.createQuery("SELECT s.volunteer FROM Subscription s WHERE s.service = :paramservice AND unsubscribeDate = NULL");
		query.setParameter("paramservice", service);
		return query.getResultList();

	}



	@Override
	public void removeSub(Subscription subscription) {
		subscription=em.merge(subscription);
		em.remove(subscription);
		
	}

}
