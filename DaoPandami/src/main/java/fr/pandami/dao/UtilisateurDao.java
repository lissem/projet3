package fr.pandami.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

// il faut déclarer chaque entity dans persistence.xml
import fr.pandami.entity.Utilisateur;
import fr.pandami.idao.UtilisateurIDao;

@Remote(UtilisateurIDao.class)
@Stateless
public class UtilisateurDao implements UtilisateurIDao{

	@PersistenceContext(unitName = "PUPandami")
	private EntityManager em;
	
	@Override
	public Utilisateur authenticate(String login, String password) {
		Query query = em.createQuery("SELECT u FROM Utilisateur u WHERE u.login = :paramlogin AND u.password = :parampassword");
		query.setParameter("paramlogin", login);
		query.setParameter("parampassword", password);
		List<Utilisateur> users = query.getResultList();
		Utilisateur user = null;
		if (users.size()>0){
			user = users.get(0);
		}
		return user;
	}

}
