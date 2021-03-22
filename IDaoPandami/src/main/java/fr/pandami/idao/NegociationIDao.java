package fr.pandami.idao;

import java.util.List;

import fr.pandami.entity.Negociation;
import fr.pandami.entity.Service;
import fr.pandami.entity.User;

public interface NegociationIDao {

	Negociation handshake(Negociation nego); 
	Negociation update(Negociation nego);
	List<Negociation> getActiveNegociation(Integer serviceId);
}
