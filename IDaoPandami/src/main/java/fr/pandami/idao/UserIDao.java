package fr.pandami.idao;

import fr.pandami.entity.User;

public interface UserIDao {

	User authenticate(String login, String password);

}
