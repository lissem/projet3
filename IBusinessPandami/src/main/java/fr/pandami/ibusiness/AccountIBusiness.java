package fr.pandami.ibusiness;

import fr.pandami.entity.User;

public interface AccountIBusiness {
	User connexion(String login, String password);
}
