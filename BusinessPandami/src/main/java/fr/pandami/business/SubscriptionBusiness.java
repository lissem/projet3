package fr.pandami.business;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.pandami.entity.Subscription;
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

}
