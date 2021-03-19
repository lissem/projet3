package fr.pandami.ibusiness;

import fr.pandami.entity.Negociation;

public interface NegociationIBusiness {

	Negociation handshake(Negociation nego); 
	
	Boolean answer();

	Negociation update(Negociation nego);
}
