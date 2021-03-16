package fr.pandami.business;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.pandami.entity.PreferenceService;
import fr.pandami.ibusiness.PreferenceServiceIBusiness;
import fr.pandami.idao.PreferenceServiceIDao;
import fr.pandami.idao.ServiceIDao;

@Remote(PreferenceServiceIBusiness.class)
@Stateless
public class PreferenceServiceBusiness implements PreferenceServiceIBusiness {

	
	@EJB
	private PreferenceServiceIDao proxyPrefServiceIDao;
	
	@Override
	public void addPrefService(PreferenceService prefService) {
		proxyPrefServiceIDao.addPrefService(prefService);
		
	}

}
