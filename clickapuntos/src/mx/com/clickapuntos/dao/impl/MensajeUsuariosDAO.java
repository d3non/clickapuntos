package mx.com.clickapuntos.dao.impl;

import java.util.List;

import mx.com.clickapuntos.dao.MensajeUsuariosDAOI;
import mx.com.clickapuntos.persistence.MensajeUsuarios;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class MensajeUsuariosDAO extends HibernateDaoSupport implements
		MensajeUsuariosDAOI {

	@Override
	public void create(MensajeUsuarios MensajeUsuarios) {
		try{
			getHibernateTemplate().save(MensajeUsuarios);
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
	}

	@Override
	public void update(MensajeUsuarios MensajeUsuarios) {
		try{
			getHibernateTemplate().update(MensajeUsuarios);
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
	}

	@Override
	public void delete(MensajeUsuarios MensajeUsuarios) {
		try{
			getHibernateTemplate().delete(MensajeUsuarios);
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MensajeUsuarios> findAll() {
		List<MensajeUsuarios> MensajeUsuarios=null;
		try{
			MensajeUsuarios=(List<MensajeUsuarios>)getHibernateTemplate().find("from MensajeUsuarios");
		}catch(RuntimeException re){
			System.out.println("Error " + re);
		}
		return MensajeUsuarios;
	}
	
	@Override
	public MensajeUsuarios findById(Long idMensajeUsuarios) {
		List<MensajeUsuarios> mensajeUsuarios=findByProperty("id.idMensaje", idMensajeUsuarios);
		if(mensajeUsuarios!=null){
			if(mensajeUsuarios.size()>0)
				return mensajeUsuarios.get(0);
			else
				return null;
		}
		else return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MensajeUsuarios> findByProperty(String property, Object value) {
		try {
			String queryString = "from MensajeUsuarios as model where model."
					+ property + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MensajeUsuarios> findByExample(MensajeUsuarios MensajeUsuarios) {
		try {
			List<MensajeUsuarios> results = (List<MensajeUsuarios>) getHibernateTemplate()
					.findByExample(MensajeUsuarios);
			return results;
		} catch (RuntimeException re) {
			throw re;
		}
	}

}
