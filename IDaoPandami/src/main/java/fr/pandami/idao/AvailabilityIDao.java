package fr.pandami.idao;

import java.util.List;

import fr.pandami.entity.Availability;


public interface AvailabilityIDao {
	Availability  addAvailability(Availability dispo);
	List<Availability> getAvailabilities();
	Availability update(Availability availability);
}
