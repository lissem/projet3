package fr.pandami.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.pandami.entity.Service;
import fr.pandami.entity.Subscription;
import fr.pandami.entity.User;
import fr.pandami.ibusiness.SubscriptionIBusiness;
import fr.pandami.idao.SubscriptionIDao;

@Remote(SubscriptionIBusiness.class)
@Stateless
public class SubscriptionBusiness implements SubscriptionIBusiness{

	@EJB
	private SubscriptionIDao proxySubscriptionDao;

	@Override
	public Subscription createSub(Subscription subscription) {
		return proxySubscriptionDao.createSub(subscription);
	}

	@Override
	public User getVolunteer(Service service) {
		List<User> users = proxySubscriptionDao.getActiveVolunteer(service);
		if (users.size() > 0) {
			return users.get(0);
		} else return null;

	}

}
