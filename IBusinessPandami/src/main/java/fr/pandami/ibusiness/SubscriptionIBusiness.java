package fr.pandami.ibusiness;




import java.util.List;


import fr.pandami.entity.Service;
import fr.pandami.entity.Subscription;
import fr.pandami.entity.User;

public interface SubscriptionIBusiness {
	
	Subscription createSub(Subscription subscription);

	Subscription cancelSub(Subscription subscription );
	Subscription getSub(Service service);


	User getVolunteer(Service service);

}
