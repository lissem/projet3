package fr.pandami.business;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.print.attribute.standard.DateTimeAtCreation;

import fr.pandami.entity.Availability;
import fr.pandami.entity.User;
import fr.pandami.ibusiness.AccountIBusiness;
import fr.pandami.idao.AvailabilityIDao;
import fr.pandami.idao.UserIDao;

@Remote(AccountIBusiness.class)
@Stateless
public class AccountBusiness implements AccountIBusiness {

	@EJB
	private UserIDao proxyUtilisateurDao;
	
	@EJB
	private AvailabilityIDao proxyAvailabilityDao;
	
	@Override
	public User connexion(String login, String password) {
		
		return proxyUtilisateurDao.authenticate(login, password);
	}

	@Override
	public Boolean exist(String email) {
		return proxyUtilisateurDao.exist(email);
	}
	
	@Override
	public User creation(User newUser) {
		User returnedUser = null;
		if (!proxyUtilisateurDao.exist(newUser.getEmail())) {
			returnedUser = proxyUtilisateurDao.create(newUser);
		}
		return returnedUser;
	}

	@Override

	public Availability createAvailability(Availability dispo) {

		
		return proxyAvailabilityDao.addAvailability(dispo); 
	}

	

	public User display(User user) {
		User returnedUser = null;
		returnedUser = proxyUtilisateurDao.display(user);
		
		return returnedUser ;
	}

	@Override
	public User getUser(Integer id) {
		
		return proxyUtilisateurDao.getUser(id);
	}

	@Override
	public User update(User user) {
		return proxyUtilisateurDao.update(user);
	}



	

}
