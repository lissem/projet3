package fr.pandami.ibusiness;

import fr.pandami.entity.Service;
import fr.pandami.entity.Subscription;
import fr.pandami.entity.User;

public interface SubscriptionIBusiness {
	
	Subscription createSub(Subscription subscription);

	Subscription cancelSub(Subscription subscription );
	Subscription getSub(Service service);
	void deleteSub(Subscription subscription);


	User getVolunteer(Service service);

}
