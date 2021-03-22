package fr.pandami.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.pandami.entity.Negociation;
import fr.pandami.entity.Service;
import fr.pandami.entity.User;
import fr.pandami.ibusiness.NegociationIBusiness;
import fr.pandami.idao.NegociationIDao;
import fr.pandami.idao.SubscriptionIDao;

@Remote(NegociationIBusiness.class)
@Stateless
public class NegociationBusiness implements NegociationIBusiness{

	@EJB
	private NegociationIDao proxyNegociation;
	
	@EJB
	private SubscriptionIDao proxySub; 
	
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

	@Override
	public boolean isNegociable(Integer serviceId) {
		List<User> fromSub = proxySub.getActiveVolunteer(serviceId); 
		if (fromSub.size()==0) {
			return false;
		}
		List<User> fromNego = new ArrayList<User>(); 
		List<Negociation> NegoList = proxyNegociation.getActiveNegociation(serviceId); 
		for (Negociation negociation : NegoList) {
			fromNego.add(negociation.getAsker());
			fromNego.add(negociation.getAnswerer());
		}
		return (fromNego.size()>0) ? false : true;
	}

	@Override
	public Negociation getActiveNego(Integer serviceId) {
		List<Negociation> NegoList = proxyNegociation.getActiveNegociation(serviceId); 
		return (NegoList.size() > 0) ? NegoList.get(0) : null;
	}

}
