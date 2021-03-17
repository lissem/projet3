package fr.pandami.idao;

import java.util.List;

import fr.pandami.entity.Address;
import fr.pandami.entity.Equipment;
import fr.pandami.entity.ServiceType;

public interface ReferentialIDao {
	
	List<Address> getAllAdresses();
	List<ServiceType> getAllTypes();
	List<Equipment> getAllEquipments();
}
