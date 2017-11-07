package mx.com.clickapuntos.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import mx.com.clickapuntos.dao.EmailConfirmacionDAOI;
import mx.com.clickapuntos.persistence.DetallePuntos;
import mx.com.clickapuntos.persistence.EmailConfirmacion;

public class EmailConfirmacionDAO extends HibernateDaoSupport implements EmailConfirmacionDAOI{ 

	@SuppressWarnings("unchecked")
	@Override
	public List<EmailConfirmacion> findAll() {
		List<EmailConfirmacion> dps=null;
		try{
			dps=(List<EmailConfirmacion>)getHibernateTemplate().find("from EmailConfirmacion");
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
		return dps;
	}

}
