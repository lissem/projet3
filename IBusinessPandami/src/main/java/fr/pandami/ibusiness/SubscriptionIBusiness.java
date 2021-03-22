package fr.pandami.ibusiness;

import fr.pandami.entity.Service;
import fr.pandami.entity.Subscription;
import fr.pandami.entity.User;

public interface SubscriptionIBusiness {
	
	Subscription createSub(Subscription subscription);

	void cancelSub(Service service);

	User getVolunteer(Integer serviceId);

	String getStatusBU(Integer serviceId);

}
