package fr.pandami.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.pandami.entity.PreferenceService;
import fr.pandami.entity.Service;
import fr.pandami.idao.PreferenceServiceIDao;
import fr.pandami.idao.ServiceIDao;

@Remote(PreferenceServiceIDao.class)
@Stateless
public class PreferenceServiceDao implements PreferenceServiceIDao{
	
	@PersistenceContext(unitName = "PUPandami")
	private EntityManager em;

	@Override
	public void addPrefService(PreferenceService prefService) {
		em.persist(prefService);
		}



}
