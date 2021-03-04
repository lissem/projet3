package fr.pandami.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

// il faut déclarer chaque entity dans persistence.xml
import fr.pandami.entity.User;
import fr.pandami.idao.UserIDao;

@Remote(UserIDao.class)
@Stateless
public class UserDao implements UserIDao{

	@PersistenceContext(unitName = "PUPandami")
	private EntityManager em;
	
	@Override
	public User authenticate(String email, String password) {
		Query query = em.createQuery("SELECT u FROM Utilisateur u WHERE u.email = :paramemail AND u.password = :parampassword");
		query.setParameter("paramemail", email);
		query.setParameter("parampassword", password);
		List<User> users = query.getResultList();
		User user = null;
		if (users.size()>0){
			user = users.get(0);
		}
		return user;
	}

}
