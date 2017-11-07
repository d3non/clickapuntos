package mx.com.clickapuntos.dao.impl;

import java.util.List;

import mx.com.clickapuntos.dao.PuntosUsuarioDAOI;
import mx.com.clickapuntos.persistence.PuntosUsuarios;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class PuntosUsuariosDAO extends HibernateDaoSupport implements
		PuntosUsuarioDAOI {

	@Override
	public void create(PuntosUsuarios tp) {
		try{
			getHibernateTemplate().save(tp);
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
	}

	@Override
	public void update(PuntosUsuarios tp) {
		try{
			getHibernateTemplate().update(tp);
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
	}

	@Override
	public void delete(PuntosUsuarios tp) {
		try{
			getHibernateTemplate().delete(tp);
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PuntosUsuarios> findAll() {
		List<PuntosUsuarios> tps=null;
		try{
			tps=(List<PuntosUsuarios>)getHibernateTemplate().find("from PuntosUsuarios");
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
		return tps;
	}

	@Override
	public PuntosUsuarios findById(Long id) {
		List<PuntosUsuarios> tps=findByProperty("idUsuarios", id);
		if(tps!=null){
			if(tps.size()>0)
				return tps.get(0);
			else
				return null;
		}
		else return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PuntosUsuarios> findByProperty(String property, Object value) {
		try {
			String queryString = "from PuntosUsuarios as model where model."
					+ property + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PuntosUsuarios> findByExample(PuntosUsuarios tp) {
		try {
			List<PuntosUsuarios> results = (List<PuntosUsuarios>) getHibernateTemplate()
					.findByExample(tp);
			return results;
		} catch (RuntimeException re) {
			throw re;
		}
	}

}
