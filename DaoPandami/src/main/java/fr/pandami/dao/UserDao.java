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

//	@Override
//	public Boolean create(Integer id, String email, String password, String firstName, String lastName, LocalDateTime birthDate,
//			String phone, LocalDateTime registrationDate, LocalDateTime resignDate, Gender gender, UserType userType,
//			Address address) {
//		boolean result = false;	
//			Query query = em.createQuery("INSERT INTO User (id, birthdate, email, firstName, lastName, password, phone, registrationDate, "
//					+ "adress_id, gender_id, userType_id) VALUES (:parambirthdate, :paramemail, :paramfirstname, :paramlastname,"
//					+ ":parampassword, :paramphone, :paramregistrationdate ,:paramaddress, :paramgender, :paramusertype)"); 
//			query.setParameter("parambirthdate", birthDate);
//			query.setParameter("paramemail", email);
//			query.setParameter("paramfirstname", firstName);
//			query.setParameter("paramlastname", lastName);
//			query.setParameter("parampassword", password);
//			query.setParameter("paramphone", phone);
//			query.setParameter("paramregistrationdate", registrationDate);
//			query.setParameter("paramaddress", address);
//			query.setParameter("paramgender", gender);
//			query.setParameter("paramusertype", userType);
//			result = true;
//		return result;
//	}

	public User create(User user) {
		try {
			em.persist(user);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return user;
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

	@Override
	public Availability addAvailability(Availability dispo) {
		try {
			em.persist(dispo);	
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return dispo;
	}
	
	}
