package fr.pandami.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.pandami.entity.PreferenceService;
import fr.pandami.entity.ServiceType;
import fr.pandami.entity.User;
import fr.pandami.ibusiness.PreferenceServiceIBusiness;
import fr.pandami.idao.PreferenceServiceIDao;

@Remote(PreferenceServiceIBusiness.class)
@Stateless
public class PreferenceServiceBusiness implements PreferenceServiceIBusiness {


	@EJB
	private PreferenceServiceIDao proxyPrefServiceIDao;


	@Override
	public void addPrefService(ServiceType[] selectedTypes, User user) {
		proxyPrefServiceIDao.deletePref(user);
		List<PreferenceService> prefServiceList = new ArrayList<PreferenceService>();
		for (ServiceType serviceType : selectedTypes) {
			PreferenceService prefService = new PreferenceService();
			prefService.setServiceType(serviceType);
			prefService.setUser(user);
			prefServiceList.add(prefService);
		}
		proxyPrefServiceIDao.addPrefService(prefServiceList);

	}


	@Override
	public ServiceType[] getSelectedTypes(User user) {
		List<PreferenceService> ListPref = proxyPrefServiceIDao.getMyPreferences(user);
		ServiceType[] PrefTab = new ServiceType[ListPref.size()]; 
		for (int i = 0; i < PrefTab.length; i++) {
			PrefTab[i] = ListPref.get(i).getServiceType();
		}
		return PrefTab;
	}
}

