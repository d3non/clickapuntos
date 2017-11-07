package mx.com.clickapuntos.dao.impl;

import java.util.List;

import mx.com.clickapuntos.dao.DetallePuntosDAOI;
import mx.com.clickapuntos.persistence.DetallePuntos;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class DetallePuntosDAO extends HibernateDaoSupport implements
		DetallePuntosDAOI {

	@Override
	public void create(DetallePuntos dp) {
		try{
			getHibernateTemplate().save(dp);
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
	}

	@Override
	public void update(DetallePuntos dp) {
		try{
			getHibernateTemplate().update(dp);
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
	}

	@Override
	public void delete(DetallePuntos dp) {
		try{
			getHibernateTemplate().delete(dp);
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DetallePuntos> findAll() {
		List<DetallePuntos> dps=null;
		try{
			dps=(List<DetallePuntos>)getHibernateTemplate().find("from DetallePuntos");
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
		return dps;
	}

	@Override
	public DetallePuntos findById(Long idPuntos) {
		List<DetallePuntos> dps=findByProperty("idPuntos", idPuntos);
		if(dps!=null){
			if(dps.size()>0)
				return dps.get(0);
			else
				return null;
		}
		else return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DetallePuntos> findByProperty(String property, Object value) {
		try {
			String queryString = "from DetallePuntos as model where model."
					+ property + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DetallePuntos> findByExample(DetallePuntos dp) {
		try {
			List<DetallePuntos> results = (List<DetallePuntos>) getHibernateTemplate()
					.findByExample(dp);
			return results;
		} catch (RuntimeException re) {
			throw re;
		}
	}

}
