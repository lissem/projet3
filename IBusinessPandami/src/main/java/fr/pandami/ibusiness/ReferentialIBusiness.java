package fr.pandami.ibusiness;

import java.util.List;

import fr.pandami.entity.Address;
import fr.pandami.entity.Equipment;
import fr.pandami.entity.ServiceType;

public interface ReferentialIBusiness {

	List<Address> listAdresses();
	List<ServiceType> listTypes();
	List<Equipment> listEquipments();
}
