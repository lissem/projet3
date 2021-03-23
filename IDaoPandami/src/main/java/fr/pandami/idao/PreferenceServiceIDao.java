package fr.pandami.idao;

import java.util.List;

import fr.pandami.entity.PreferenceService;
import fr.pandami.entity.User;

public interface PreferenceServiceIDao {

	void addPrefService (List<PreferenceService> prefServiceList);
	List<PreferenceService> getMyPreferences(Integer userId);

	void deletePref(User user);
	 
}
