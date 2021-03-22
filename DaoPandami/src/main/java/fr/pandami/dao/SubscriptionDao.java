package fr.pandami.dao;

import java.time.LocalDateTime;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Subscription>getActiveSub(Integer serviceId) {
		Query query=em.createQuery("SELECT s FROM Subscription s WHERE s.service.id = :paramServiceId AND s.unsubscribeDate = NULL");
		query.setParameter("paramServiceId", serviceId);
		return query.getResultList();

	}	

		

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getActiveVolunteer(Integer serviceId) {
		Query query = em.createQuery("SELECT s.volunteer FROM Subscription s WHERE s.service.id = :paramservice AND unsubscribeDate = NULL");
		query.setParameter("paramservice", serviceId);
		return query.getResultList();

	}


	@Override
	public void cancelSub(Service service) {
		Query query = em.createQuery("SELECT s FROM Subscription s WHERE s.service.id = :paramservice AND s.unsubscribeDate = NULL");
		query.setParameter("paramservice", service.getId());
		List<Subscription> ListSub = query.getResultList();
		for (Subscription subscription : ListSub) {
			subscription.setUnsubscribeDate(LocalDateTime.now());
			em.merge(subscription);
		}
	}

}
