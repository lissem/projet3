package fr.pandami.ibusiness;

import fr.pandami.entity.Negociation;
import fr.pandami.entity.Service;

public interface NegociationIBusiness {

	Negociation handshake(Negociation nego); 
	
	Boolean answer();

	Negociation update(Negociation nego);

	boolean isNegociable(Integer serviceId);

	Negociation getActiveNego(Integer serviceId);
}
