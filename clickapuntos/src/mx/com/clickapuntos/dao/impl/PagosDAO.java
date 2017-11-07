package mx.com.clickapuntos.dao.impl;

import java.util.List;

import mx.com.clickapuntos.dao.PagosDAOI;
import mx.com.clickapuntos.persistence.Pagos;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class PagosDAO extends HibernateDaoSupport implements PagosDAOI {

	@Override
	public void create(Pagos pagos) {
		try{
			getHibernateTemplate().save(pagos);
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
	}

	@Override
	public void update(Pagos pagos) {
		try{
			getHibernateTemplate().update(pagos);
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
	}

	@Override
	public void delete(Pagos pagos) {
		try{
			getHibernateTemplate().delete(pagos);
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Pagos> findAll() {
		List<Pagos> pagos=null;
		try{
			pagos=(List<Pagos>)getHibernateTemplate().find("from Pagos");
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
		return pagos;
	}
	
	@Override
	public Pagos findById(Long idPagos) {
		List<Pagos> pagos=findByProperty("id.idPagos", idPagos);
		if(pagos!=null) {
			if(pagos.size()>0)
				return pagos.get(0);
			else
				return null;
		}
		else return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pagos> findByProperty(String property, Object value) {
		try {
			String queryString = "from Pagos as model where model."
					+ property + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pagos> findByExample(Pagos pagos) {
		try {
			List<Pagos> results = (List<Pagos>) getHibernateTemplate()
					.findByExample(pagos);
			return results;
		} catch (RuntimeException re) {
			throw re;
		}
	}

}
