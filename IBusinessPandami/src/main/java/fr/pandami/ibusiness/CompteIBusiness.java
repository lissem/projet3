package fr.pandami.ibusiness;

import fr.pandami.entity.Utilisateur;

public interface CompteIBusiness {
	Utilisateur connexion(String login, String password);
}
