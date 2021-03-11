package fr.pandami.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.pandami.entity.Address;
import fr.pandami.ibusiness.ReferentialIBusiness;
import fr.pandami.idao.ReferentialIDao;

@Remote(ReferentialIBusiness.class)
@Stateless
public class ReferantialBusiness implements ReferentialIBusiness{

	@EJB
	private ReferentialIDao proxyReferentialDao;
	
	
	@Override
	public List<Address> listAdresses() {
		// TODO Auto-generated method stub
		return proxyReferentialDao.getAllAdresses();
	}

	
}
