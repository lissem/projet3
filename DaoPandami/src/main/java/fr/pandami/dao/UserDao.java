package fr.pandami.dao;

import java.time.LocalDateTime;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.pandami.entity.Address;
import fr.pandami.entity.Availability;
import fr.pandami.entity.Gender;
// il faut déclarer chaque entity dans persistence.xml
import fr.pandami.entity.User;
import fr.pandami.entity.UserType;
import fr.pandami.idao.UserIDao;

@Remote(UserIDao.class)
@Stateless
public class UserDao implements UserIDao{

	@PersistenceContext(unitName = "PUPandami")
	private EntityManager em;

	@Override
	public User authenticate(String email, String password) {
		Query query = em.createQuery("SELECT u FROM User u WHERE u.email = :paramemail AND u.password = :parampassword");
		query.setParameter("paramemail", email);
		query.setParameter("parampassword", password);
		List<User> users = query.getResultList();
		User user = null;
		if (users.size()>0){
			user = users.get(0);
		}
		return user;
	}


	public User create(User user) {
		try {
			em.persist(user);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return authenticate(user.getEmail(), user.getPassword());
	}


	@Override
	public Boolean exist(String email) {
		boolean retour = false;
		Query query2 = em.createQuery("SELECT u From User u WHERE u.email = :paramemail");
		query2.setParameter("paramemail", email);
		List<User> users  = query2.getResultList();
		if (users.size() > 0 ) {
			retour = true;
		}
		return retour;
	}

	
	public User display(User user) {
		Query query3 = em.createQuery("SELECT u FROM User u WHERE u.id = :paramid");
		query3.setParameter("paramid", user.getId());
		List<User> users = query3.getResultList();
		if (users.size()>0){
			user = users.get(0);
		}
		return user;
	}


	@Override
	public User getUser(Integer id) {
		User user = new User();

		Query query = em.createQuery("SELECT u FROM User u WHERE u.id = :paramid");
		query.setParameter("paramid", id);
		List<User> users = query.getResultList();
		if (users.size()>0){
			user = users.get(0);
		
		}
		return user;


	}
}
