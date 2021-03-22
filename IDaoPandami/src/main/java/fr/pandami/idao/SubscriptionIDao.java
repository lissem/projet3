package fr.pandami.idao;

import java.util.List;

import fr.pandami.entity.Service;
import fr.pandami.entity.Subscription;
import fr.pandami.entity.User;

public interface SubscriptionIDao {


	Subscription createSub(Subscription subscription);
	List<User> getActiveVolunteer(Integer serviceId);
	List<Subscription> getActiveSub(Integer serviceId);
	void cancelSub(Service service);

}
