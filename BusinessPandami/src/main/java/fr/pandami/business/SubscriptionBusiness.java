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

	public User getVolunteer(Integer serviceId) {
		List<User> users = proxySubscriptionDao.getActiveVolunteer(serviceId);
		if (users.size() > 0) {
			return users.get(0);
		} else return null;

	}

	@Override
	public String getStatusBU(Integer serviceId) {
		List<Subscription> listActiveSubscription = proxySubscriptionDao.getActiveSub(serviceId);
		if (listActiveSubscription.size()>0) {
			return "Accepté";
		}
		return "En Attente";
	}

	@Override
	public void cancelSub(Service service) {
		proxySubscriptionDao.cancelSub(service);
	}

	@Override
	public User getSubscriber(Integer id) {
		List<Subscription> listSub = proxySubscriptionDao.getActiveSub(id);
		if (listSub.size() > 0 ) {
			return listSub.get(0).getVolunteer();
		} else {
			return null;
		}
			
		
	}


}
