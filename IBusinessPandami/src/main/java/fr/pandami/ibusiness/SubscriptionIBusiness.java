package fr.pandami.ibusiness;



import java.util.List;

import fr.pandami.entity.Service;
import fr.pandami.entity.Subscription;

public interface SubscriptionIBusiness {
	
	Subscription createSub(Subscription subscription);
	Subscription cancelSub(Subscription subscription );
	Subscription getSub(Service service);

}
