package mx.com.clickapuntos.dao.impl;

import java.util.List;

import mx.com.clickapuntos.dao.TarjetasPremiosDAOI;
import mx.com.clickapuntos.persistence.TarjetasPremios;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class TarjetasPremiosDAO extends HibernateDaoSupport implements
		TarjetasPremiosDAOI {

	@Override
	public void create(TarjetasPremios tp) {
		try{
			getHibernateTemplate().save(tp);
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
	}

	@Override
	public void update(TarjetasPremios tp) {
		try{
			getHibernateTemplate().update(tp);
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
	}

	@Override
	public void delete(TarjetasPremios tp) {
		try{
			getHibernateTemplate().delete(tp);
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TarjetasPremios> findAll() {
		List<TarjetasPremios> tps=null;
		try{
			tps=(List<TarjetasPremios>)getHibernateTemplate().find("from TarjetasPremios");
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
		return tps;
	}

	@Override
	public TarjetasPremios findById(Long id) {
		List<TarjetasPremios> tp = findByProperty("idTarjeta", id);
		if(tp!=null){
			if(tp.size()>0)
				return tp.get(0);
			else
				return null;
		}
		else return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TarjetasPremios> findByProperty(String property, Object value) {
		try {
			String queryString = "from TarjetasPremios as model where model."
					+ property + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TarjetasPremios> findByExample(TarjetasPremios tp) {
		try {
			List<TarjetasPremios> results = (List<TarjetasPremios>) getHibernateTemplate()
					.findByExample(tp);
			return results;
		} catch (RuntimeException re) {
			throw re;
		}
	}

}
