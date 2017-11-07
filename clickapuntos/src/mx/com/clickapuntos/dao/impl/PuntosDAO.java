package mx.com.clickapuntos.dao.impl;

import java.util.List;
import mx.com.clickapuntos.dao.PuntosDAOI;
import mx.com.clickapuntos.persistence.Puntos;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class PuntosDAO extends HibernateDaoSupport implements PuntosDAOI {

	@Override
	public void create(Puntos pu) {
		try{
			getHibernateTemplate().save(pu);
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
	}

	@Override
	public void update(Puntos pu) {
		try{
			getHibernateTemplate().update(pu);
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
	}

	@Override
	public void delete(Puntos pu) {
		try{
			getHibernateTemplate().delete(pu);
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Puntos> findAll() {
		List<Puntos> puntos=null;
		try{
			puntos=(List<Puntos>)getHibernateTemplate().find("from Puntos");
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
		return puntos;
	}

	@Override
	public Puntos findById(Long idPuntos) {
		List<Puntos> puntos=findByProperty("id.idPuntos", idPuntos);
		if(puntos!=null){
			if(puntos.size()>0)
				return puntos.get(0);
			else
				return null;
		}
		else return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Puntos> findByProperty(String property, Object value) {
		try {
			String queryString = "from Puntos as model where model."
					+ property + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Puntos> findByExample(Puntos pu) {
		try {
			List<Puntos> results = (List<Puntos>) getHibernateTemplate()
					.findByExample(pu);
			return results;
		} catch (RuntimeException re) {
			throw re;
		}
	}

}
