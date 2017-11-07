package mx.com.clickapuntos.dao.impl;

import java.util.List;

import mx.com.clickapuntos.dao.TipoCambioPuntosPesosDAOI;
import mx.com.clickapuntos.persistence.TipoCambioPuntosPesos;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class TipoCambioPuntosPesosDAO extends HibernateDaoSupport implements
		TipoCambioPuntosPesosDAOI {

	@Override
	public void create(TipoCambioPuntosPesos tcpp) {
		try{
			getHibernateTemplate().save(tcpp);
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
	}

	@Override
	public void update(TipoCambioPuntosPesos tcpp) {
		try{
			getHibernateTemplate().update(tcpp);
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
	}

	@Override
	public void delete(TipoCambioPuntosPesos tcpp) {
		try{
			getHibernateTemplate().delete(tcpp);
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TipoCambioPuntosPesos> findAll() {
		List<TipoCambioPuntosPesos> tcpps=null;
		try{
			tcpps=(List<TipoCambioPuntosPesos>)getHibernateTemplate().find("from TipoCambioPuntosPesos");
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
		return tcpps;
	}

	@Override
	public TipoCambioPuntosPesos findById(Long id) {
		List<TipoCambioPuntosPesos> tcpps=findByProperty("id", id);
		if(tcpps!=null) {
			if(tcpps.size()>0)
				return tcpps.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoCambioPuntosPesos> findByProperty(String property,
			Object value) {
		try {
			String queryString = "from TipoCambioPuntosPesos as model where model."
					+ property + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoCambioPuntosPesos> findByExample(TipoCambioPuntosPesos tcpp) {
		try {
			List<TipoCambioPuntosPesos> results = (List<TipoCambioPuntosPesos>) getHibernateTemplate()
					.findByExample(tcpp);
			return results;
		} catch (RuntimeException re) {
			throw re;
		}
	}

}
