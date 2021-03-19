package fr.pandami.idao;

import fr.pandami.entity.Negociation;

public interface NegociationIDao {

	Negociation handshake(Negociation nego); 
	Boolean answer();
	Negociation update(Negociation nego);
}
