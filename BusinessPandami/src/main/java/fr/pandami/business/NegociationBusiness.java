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
	public boolean isNegociable(Service service) {
		List<User> fromSub = proxySub.getActiveVolunteer(service); 
		List<User> fromNego = new ArrayList<User>(); 
		List<Negociation> NegoList = proxyNegociation.getActiveNegociation(service); 
		for (Negociation negociation : NegoList) {
			fromNego.add(negociation.getAsker());
			fromNego.add(negociation.getAnswerer());
		}
		return (proxySub.getActiveVolunteer(service).size() > 0 && proxyNegociation.getActiveNegociation(service).size() == 0);
	}

	@Override
	public Negociation getActiveNego(Service service) {
		List<Negociation> NegoList = proxyNegociation.getActiveNegociation(service); 
		return (NegoList.size() > 0) ? NegoList.get(0) : null;
	}

}
