package fr.pandami.idao;

import java.util.List;

import fr.pandami.entity.Service;
import fr.pandami.entity.Subscription;
import fr.pandami.entity.User;

public interface SubscriptionIDao {


Subscription createSub(Subscription subscription);
Subscription cancelSub(Subscription subscription);
List<Subscription> getSub(Service service);
void removeSub(Subscription subscription);


	List<User> getActiveVolunteer(Service service);

}
