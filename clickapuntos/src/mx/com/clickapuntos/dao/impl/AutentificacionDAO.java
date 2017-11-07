package mx.com.clickapuntos.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import mx.com.clickapuntos.dao.AutentificacionDAOI;
import mx.com.clickapuntos.persistence.Autentificacion;

public class AutentificacionDAO extends HibernateDaoSupport implements AutentificacionDAOI{

	@SuppressWarnings("unchecked")
	@Override
	public List<Autentificacion> findByProperty(String property, Object value) {
		try {
			String queryString = "from Autentificacion as model where model."
					+ property + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Autentificacion> findAll() {
		List<Autentificacion> dps=null;
		try{
			dps=(List<Autentificacion>)getHibernateTemplate().find("from Autentificacion");
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
		return dps;
	}

}
