package fr.pandami.idao;

import fr.pandami.entity.Utilisateur;

public interface UtilisateurIDao {

	Utilisateur authenticate(String login, String password);

}
