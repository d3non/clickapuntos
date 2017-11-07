package mx.com.clickapuntos.dao.impl;

import java.util.List;

import mx.com.clickapuntos.dao.PuntosUsrDAOI;
import mx.com.clickapuntos.persistence.PuntosUsr;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class PuntosUsrDAO extends HibernateDaoSupport implements PuntosUsrDAOI{

	@Override
	public void create(PuntosUsr pu) {
		try{
			getHibernateTemplate().save(pu);
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
	}

	@Override
	public void update(PuntosUsr pu) {
		try{
			getHibernateTemplate().update(pu);
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
	}

	@Override
	public void delete(PuntosUsr pu) {
		try{
			getHibernateTemplate().delete(pu);
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PuntosUsr> findAll() {
		List<PuntosUsr> puntosUsrs=null;
		try{
			puntosUsrs=(List<PuntosUsr>)getHibernateTemplate().find("from PuntosUsr");
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
		return puntosUsrs;
	}

	@Override
	public PuntosUsr findById(Long idPuntos) {
		List<PuntosUsr> puntosUsrs=findByProperty("id.idPuntos", idPuntos);
		if(puntosUsrs!=null){
			if(puntosUsrs.size()>0)
				return puntosUsrs.get(0);
			else
				return null;
		}
		else return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PuntosUsr> findByProperty(String property, Object value) {
		try {
			String queryString = "from PuntosUsr as model where model."
					+ property + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PuntosUsr> findByExample(PuntosUsr pu) {
		try {
			List<PuntosUsr> results = (List<PuntosUsr>) getHibernateTemplate()
					.findByExample(pu);
			return results;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PuntosUsr> findByUsrPromoId(Object value1, Object value2) {
		try {
			String queryString = "from PuntosUsr as model where model.id.idUsuarios= ? and model.id.idPromo=?";
			return getHibernateTemplate().find(queryString, value1,value2);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
}
