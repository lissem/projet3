package fr.pandami.ibusiness;

import fr.pandami.entity.Service;
import fr.pandami.entity.Subscription;
import fr.pandami.entity.User;

public interface SubscriptionIBusiness {
	
	Subscription createSub(Subscription subscription);
	User getVolunteer(Service service);
}
