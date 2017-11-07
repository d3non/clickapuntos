package mx.com.clickapuntos.dao.impl;

import java.util.List;

import mx.com.clickapuntos.dao.RutaImagenesDAOI;
import mx.com.clickapuntos.persistence.RutasImagenes;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class RutaImagenesDAO extends HibernateDaoSupport implements
		RutaImagenesDAOI {

	@Override
	public void create(RutasImagenes tcpp) {
		try{
			getHibernateTemplate().save(tcpp);
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
	}

	@Override
	public void update(RutasImagenes tcpp) {
		try{
			getHibernateTemplate().update(tcpp);
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
	}

	@Override
	public void delete(RutasImagenes tcpp) {
		try{
			getHibernateTemplate().delete(tcpp);
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RutasImagenes> findAll() {
		List<RutasImagenes> tcpps=null;
		try{
			tcpps=(List<RutasImagenes>)getHibernateTemplate().find("from RutasImagenes");
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
		return tcpps;
	}

	@Override
	public RutasImagenes findById(Long id) {
		List<RutasImagenes> tcpps=findByProperty("id", id);
		if(tcpps!=null) {
			if(tcpps.size()>0)
				return tcpps.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RutasImagenes> findByProperty(String property,
			Object value) {
		try {
			String queryString = "from RutasImagenes as model where model."
					+ property + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RutasImagenes> findByExample(RutasImagenes tcpp) {
		try {
			List<RutasImagenes> results = (List<RutasImagenes>) getHibernateTemplate()
					.findByExample(tcpp);
			return results;
		} catch (RuntimeException re) {
			throw re;
		}
	}

}
