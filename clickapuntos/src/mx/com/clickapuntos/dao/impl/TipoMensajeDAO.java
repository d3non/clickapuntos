package mx.com.clickapuntos.dao.impl;

import java.util.List;

import mx.com.clickapuntos.dao.TipoMensajeDAOI;
import mx.com.clickapuntos.persistence.TipoMensaje;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class TipoMensajeDAO extends HibernateDaoSupport implements
		TipoMensajeDAOI {

	@Override
	public void create(TipoMensaje tp) {
		try{
			getHibernateTemplate().save(tp);
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
	}

	@Override
	public void update(TipoMensaje tp) {
		try{
			getHibernateTemplate().update(tp);
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
	}

	@Override
	public void delete(TipoMensaje tp) {
		try{
			getHibernateTemplate().delete(tp);
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoMensaje> findAll() {
		List<TipoMensaje> tps=null;
		try{
			tps=(List<TipoMensaje>)getHibernateTemplate().find("from TipoMensaje");
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
		return tps;
	}

	@Override
	public TipoMensaje findById(Long id) {
		List<TipoMensaje> tps=findByProperty("id", id);
		if(tps!=null){
			if(tps.size()>0)
				return tps.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoMensaje> findByProperty(String property, Object value) {
		try {
			String queryString = "from TipoMensaje as model where model."
					+ property + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoMensaje> findByExample(TipoMensaje tp) {
		try {
			List<TipoMensaje> results = (List<TipoMensaje>) getHibernateTemplate()
					.findByExample(tp);
			return results;
		} catch (RuntimeException re) {
			throw re;
		}
	}

}
