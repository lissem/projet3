package fr.pandami.idao;

import java.util.List;

import fr.pandami.entity.Availability;
import fr.pandami.entity.User;

public interface UserIDao {

	User authenticate(String login, String password);
	User create(User user);
	Boolean exist(String email);
	User display(User user);
	User getUser(Integer id);
	

}
