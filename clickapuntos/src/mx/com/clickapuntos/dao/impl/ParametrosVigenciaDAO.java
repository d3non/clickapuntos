package mx.com.clickapuntos.dao.impl;

import java.util.List;

import mx.com.clickapuntos.dao.ParametrosVigenciasDAOI;
import mx.com.clickapuntos.persistence.ParametrosVigencias;
import mx.com.clickapuntos.persistence.ParametrosVigencias;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class ParametrosVigenciaDAO extends HibernateDaoSupport implements
		ParametrosVigenciasDAOI {

	@Override
	public void create(ParametrosVigencias ParametrosVigencias) {
		try{
			getHibernateTemplate().save(ParametrosVigencias);
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
	}

	@Override
	public void update(ParametrosVigencias ParametrosVigencias) {
		try{
			getHibernateTemplate().update(ParametrosVigencias);
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
	}

	@Override
	public void delete(ParametrosVigencias ParametrosVigencias) {
		try{
			getHibernateTemplate().delete(ParametrosVigencias);
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ParametrosVigencias> findAll() {
		List<ParametrosVigencias> ParametrosVigencias=null;
		try{
			ParametrosVigencias=(List<ParametrosVigencias>)getHibernateTemplate().find("from ParametrosVigencias");
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
		return ParametrosVigencias;
	}
	
	@Override
	public ParametrosVigencias findById(Long idParametrosVigencias) {
		List<ParametrosVigencias> parametrosVigencias=findByProperty("idParametro", idParametrosVigencias);
		if(parametrosVigencias!=null) {
			if(parametrosVigencias.size()>0){
				return parametrosVigencias.get(0);
			}
			else
				return null;
		}
		else return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ParametrosVigencias> findByProperty(String property, Object value) {
		try {
			String queryString = "from ParametrosVigencias as model where model."
					+ property + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ParametrosVigencias> findByExample(ParametrosVigencias ParametrosVigencias) {
		try {
			List<ParametrosVigencias> results = (List<ParametrosVigencias>) getHibernateTemplate()
					.findByExample(ParametrosVigencias);
			return results;
		} catch (RuntimeException re) {
			throw re;
		}
	}

}
