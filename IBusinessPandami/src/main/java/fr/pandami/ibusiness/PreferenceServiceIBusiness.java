package fr.pandami.ibusiness;

import fr.pandami.entity.ServiceType;
import fr.pandami.entity.User;

public interface PreferenceServiceIBusiness {

	void addPrefService (ServiceType[] selectedTypes, User user);

	ServiceType[] getSelectedTypes(User user);
}
