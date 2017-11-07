package mx.com.clickapuntos.dao.impl;

import java.util.List;

import mx.com.clickapuntos.dao.DetallePromoDAOI;
import mx.com.clickapuntos.persistence.DetallePromo;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class DetallePromoDAO extends HibernateDaoSupport implements
		DetallePromoDAOI {

	@Override
	public void create(DetallePromo dp) {
		try{
			getHibernateTemplate().save(dp);
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
	}

	@Override
	public void update(DetallePromo dp) {
		try{
			getHibernateTemplate().update(dp);
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
	}

	@Override
	public void delete(DetallePromo dp) {
		try{
			getHibernateTemplate().delete(dp);
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DetallePromo> findAll() {
		List<DetallePromo> dps=null;
		try{
			dps=(List<DetallePromo>)getHibernateTemplate().find("from DetallePromo");
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
		return dps;
	}

	@Override
	public DetallePromo findById(Long idPromo) {
		List<DetallePromo> dps=findByProperty("idPromo", idPromo);
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
	public List<DetallePromo> findByProperty(String property, Object value) {
		try {
			String queryString = "from DetallePromo as model where model."
					+ property + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DetallePromo> findByExample(DetallePromo dp) {
		try {
			List<DetallePromo> results = (List<DetallePromo>) getHibernateTemplate()
					.findByExample(dp);
			return results;
		} catch (RuntimeException re) {
			throw re;
		}
	}

}
