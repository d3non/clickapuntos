package mx.com.clickapuntos.dao.impl;

import java.util.List;

import mx.com.clickapuntos.persistence.Comentarios;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Comentarios entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see mx.com.clickapuntos.persistence.Comentarios
 * @author MyEclipse Persistence Tools
 */

public class ComentariosDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(ComentariosDAO.class);
	// property constants
	public static final String COMENTARIOSTEXTO = "comentariostexto";
	public static final String COMENTARIOSTATUS = "comentariostatus";
	public static final String COMENTARIOREPORTE = "comentarioreporte";
	public static final String COMENTARIOTONO = "comentariotono";
	
	public void save(Comentarios transientInstance) {
		System.out.println("Entro al guardado de ComentariosDAO");
		getHibernateTemplate().save(transientInstance);
	}

	public void delete(Comentarios persistentInstance) {
		log.debug("deleting Comentarios instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Comentarios findById(java.lang.Integer id) {
		log.debug("getting Comentarios instance with id: " + id);
		try {
			Comentarios instance = (Comentarios) getHibernateTemplate().get(
					"mx.com.clickapuntos.persistence.Comentarios", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Comentarios> findByExample(Comentarios instance) {
		log.debug("finding Comentarios instance by example");
		try {
			List<Comentarios> results = (List<Comentarios>) getHibernateTemplate()
					.findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Comentarios instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Comentarios as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Comentarios> findByComentariostexto(Object comentariostexto) {
		return findByProperty(COMENTARIOSTEXTO, comentariostexto);
	}
	public List<Comentarios> findByIdPromo(Integer idPromo) {
		return findByProperty("id.promosIdpromo", idPromo);
	}

	public List<Comentarios> findByComentariostatus(Object comentariostatus) {
		return findByProperty(COMENTARIOSTATUS, comentariostatus);
	}

	public List<Comentarios> findByComentarioreporte(Object comentarioreporte) {
		return findByProperty(COMENTARIOREPORTE, comentarioreporte);
	}

	public List<Comentarios> findByComentariotono(Object comentariotono) {
		return findByProperty(COMENTARIOTONO, comentariotono);
	}

	public List findAll() {
		log.debug("finding all Comentarios instances");
		try {
			String queryString = "from Comentarios";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Comentarios merge(Comentarios detachedInstance) {
		log.debug("merging Comentarios instance");
		try {
			Comentarios result = (Comentarios) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Comentarios instance) {
		log.debug("attaching dirty Comentarios instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Comentarios instance) {
		log.debug("attaching clean Comentarios instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ComentariosDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ComentariosDAO) ctx.getBean("ComentariosDAO");
	}
}