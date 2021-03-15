package fr.pandami.ibusiness;

import fr.pandami.entity.Availability;
import fr.pandami.entity.User;

public interface AccountIBusiness {
	User connexion(String login, String password);
	User creation(User newUser);
	Boolean exist(String email);

    Availability createAvailability(Availability dispo);

	User display(User user);
	User getUser(Integer id);
	User update(User user);

}
