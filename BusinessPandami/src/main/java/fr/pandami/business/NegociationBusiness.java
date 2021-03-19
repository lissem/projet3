package fr.pandami.business;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.pandami.entity.Negociation;
import fr.pandami.ibusiness.NegociationIBusiness;
import fr.pandami.idao.NegociationIDao;

@Remote(NegociationIBusiness.class)
@Stateless
public class NegociationBusiness implements NegociationIBusiness{

	@EJB
	private NegociationIDao proxyNegociation;

	@Override
	public Negociation handshake(Negociation nego) {
		proxyNegociation.handshake(nego);
		return null;
	}

	@Override
	public Boolean answer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Negociation update(Negociation nego) {
		return proxyNegociation.update(nego); 
	}

}
