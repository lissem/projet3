package fr.pandami.idao;

import fr.pandami.entity.User;

public interface UserIDao {

	User authenticate(String login, String password);
	User create(User user);
	Boolean exist(String email);
}
