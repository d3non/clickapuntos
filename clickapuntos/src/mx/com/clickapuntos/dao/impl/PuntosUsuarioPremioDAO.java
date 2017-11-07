package mx.com.clickapuntos.dao.impl;

import java.util.List;
import mx.com.clickapuntos.dao.PuntosUsuarioPremioDAOI;
import mx.com.clickapuntos.persistence.Clientes;
import mx.com.clickapuntos.persistence.PremiosUsuarioId;
import mx.com.clickapuntos.persistence.PuntosUsuarioPremio;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


public class PuntosUsuarioPremioDAO extends HibernateDaoSupport implements
	PuntosUsuarioPremioDAOI{
	@Override
	public void create(PuntosUsuarioPremio pu) {
		try{
			getHibernateTemplate().save(pu);
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
	}

	@Override
	public void update(PuntosUsuarioPremio pu) {
		try{
			getHibernateTemplate().update(pu);
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
	}

	@Override
	public void delete(PuntosUsuarioPremio pu) {
		try{
			getHibernateTemplate().delete(pu);
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PuntosUsuarioPremio> findAll() {
		List<PuntosUsuarioPremio> PuntosUsuarioPremios=null;
		try{
			PuntosUsuarioPremios=(List<PuntosUsuarioPremio>)getHibernateTemplate().find("from PuntosUsuarioPremio");
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
		return PuntosUsuarioPremios;
	}

	@Override
	public PuntosUsuarioPremio findById(Long idPuntos) {
		List<PuntosUsuarioPremio> PuntosUsuarioPremios = findByProperty("id.idPuntos", idPuntos);
		if(PuntosUsuarioPremios != null) {
			if(PuntosUsuarioPremios.size() > 0)
				return PuntosUsuarioPremios.get(0);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PuntosUsuarioPremio> findByProperty(String property, Object value) {
		try {
			String queryString = "from PuntosUsuarioPremio as model where model."
					+ property + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PuntosUsuarioPremio> findByExample(PuntosUsuarioPremio pu) {
		try {
			List<PuntosUsuarioPremio> results = (List<PuntosUsuarioPremio>) getHibernateTemplate()
					.findByExample(pu);
			return results;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PuntosUsuarioPremio> findByUsrPremioId(Object value1) {
		try {
			String queryString = "from PuntosUsuarioPremio as model where model.id.idUsuario= ? and model.statusCanje='1'";
			return getHibernateTemplate().find(queryString, value1);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public PuntosUsuarioPremio findById(PremiosUsuarioId id) {
		try {
			PuntosUsuarioPremio instance = (PuntosUsuarioPremio) getHibernateTemplate().get(
					"mx.com.clickapuntos.persistence.PuntosUsuarioPremio", id);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
