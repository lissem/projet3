package fr.pandami.business;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.pandami.entity.Utilisateur;
import fr.pandami.ibusiness.CompteIBusiness;
import fr.pandami.idao.UtilisateurIDao;

@Remote(CompteIBusiness.class)
@Stateless
public class CompteBusiness implements CompteIBusiness {

	@EJB
	private UtilisateurIDao proxyUtilisateurDao;
	
	@Override
	public Utilisateur connexion(String login, String password) {
		
		return proxyUtilisateurDao.authenticate(login, password);
	}

}
