package fr.pandami.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.pandami.entity.PreferenceService;
import fr.pandami.entity.Service;
import fr.pandami.entity.User;
import fr.pandami.idao.PreferenceServiceIDao;
import fr.pandami.idao.ServiceIDao;

@Remote(PreferenceServiceIDao.class)
@Stateless
public class PreferenceServiceDao implements PreferenceServiceIDao{

	@PersistenceContext(unitName = "PUPandami")
	private EntityManager em;

	@Override
	public void addPrefService(List<PreferenceService> prefService) {
		for (PreferenceService preferenceService : prefService) {
			em.persist(preferenceService);
		}
		
	}

	@Override
	public List<PreferenceService> getMyPreferences(Integer userId) {
		Query query = em.createQuery("SELECT p FROM PreferenceService p WHERE p.user.id = :paramuser");
		query.setParameter("paramuser", userId);
		return query.getResultList();
	}

	@Override
	public void deletePref(User user) {
		Query query2 = em.createQuery("DELETE FROM PreferenceService p WHERE p.user = :paramuser");
		query2.setParameter("paramuser", user);
		query2.executeUpdate();
	}

}
