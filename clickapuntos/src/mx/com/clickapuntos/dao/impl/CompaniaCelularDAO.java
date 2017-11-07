package mx.com.clickapuntos.dao.impl;

import java.util.List;

import mx.com.clickapuntos.dao.CompaniaCelularDAOI;
import mx.com.clickapuntos.persistence.CompaniaCelular;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class CompaniaCelularDAO extends HibernateDaoSupport implements
		CompaniaCelularDAOI {

	@SuppressWarnings("unchecked")
	@Override
	public List<CompaniaCelular> findByProperty(String property, Object value) {
		try {
			String queryString = "from CompaniaCelular as model where model."
					+ property + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CompaniaCelular> findAll() {
		List<CompaniaCelular> dps=null;
		try{
			dps=(List<CompaniaCelular>)getHibernateTemplate().find("from CompaniaCelular");
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
		return dps;
	}

}
