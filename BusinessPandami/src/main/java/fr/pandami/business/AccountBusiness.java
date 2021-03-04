package fr.pandami.business;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.pandami.entity.User;
import fr.pandami.ibusiness.AccountIBusiness;
import fr.pandami.idao.UserIDao;

@Remote(AccountIBusiness.class)
@Stateless
public class AccountBusiness implements AccountIBusiness {

	@EJB
	private UserIDao proxyUtilisateurDao;
	
	@Override
	public User connexion(String login, String password) {
		
		return proxyUtilisateurDao.authenticate(login, password);
	}

}
