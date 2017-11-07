package mx.com.clickapuntos.dao.impl;

import java.util.List;

import mx.com.clickapuntos.dao.TipoPagoDAOI;
import mx.com.clickapuntos.persistence.TipoCambioPuntosPesos;
import mx.com.clickapuntos.persistence.TipoPago;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class TipoPagoDAO extends HibernateDaoSupport implements TipoPagoDAOI {

	@Override
	public void create(TipoPago tp) {
		try{
			getHibernateTemplate().save(tp);
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
	}

	@Override
	public void update(TipoPago tp) {
		try{
			getHibernateTemplate().update(tp);
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
	}

	@Override
	public void delete(TipoPago tp) {
		try{
			getHibernateTemplate().delete(tp);
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoPago> findAll() {
		List<TipoPago> tps=null;
		try{
			tps=(List<TipoPago>)getHibernateTemplate().find("from TipoPago");
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
		return tps;
	}

	@Override
	public TipoPago findById(Long id) {
		List<TipoPago> tps=findByProperty("id", id);
		if(tps!=null) return tps.get(0);
		else return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoPago> findByProperty(String property, Object value) {
		try {
			String queryString = "from TipoPago as model where model."
					+ property + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoPago> findByExample(TipoPago tp) {
		try {
			List<TipoPago> results = (List<TipoPago>) getHibernateTemplate()
					.findByExample(tp);
			return results;
		} catch (RuntimeException re) {
			throw re;
		}
	}

}
