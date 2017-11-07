package mx.com.clickapuntos.dao.impl;

import java.util.List;

import mx.com.clickapuntos.persistence.Usuariosdatos;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Usuariosdatos entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see mx.com.clickapuntos.persistence.Usuariosdatos
 * @author MyEclipse Persistence Tools
 */

public class UsuariosdatosDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(UsuariosdatosDAO.class);
	// property constants
	public static final String USRNOMBRES = "usrnombres";
	public static final String USRAPATERNO = "usrapaterno";
	public static final String USRAMATERNO = "usramaterno";

	protected void initDao() {
		// do nothing
	}

	public void save(Usuariosdatos transientInstance) {
		log.debug("saving Usuariosdatos instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	public void delete(Usuariosdatos persistentInstance) {
		log.debug("deleting Usuariosdatos instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Usuariosdatos findById(java.lang.Integer id) {
		log.debug("getting Usuariosdatos instance with id: " + id);
		try {
			Usuariosdatos instance = (Usuariosdatos) getHibernateTemplate()
					.get("mx.com.clickapuntos.persistence.Usuariosdatos", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Usuariosdatos> findByExample(Usuariosdatos instance) {
		log.debug("finding Usuariosdatos instance by example");
		try {
			List<Usuariosdatos> results = (List<Usuariosdatos>) getHibernateTemplate()
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
		log.debug("finding Usuariosdatos instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Usuariosdatos as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Usuariosdatos> findByUsrnombres(Object usrnombres) {
		return findByProperty(USRNOMBRES, usrnombres);
	}

	public List<Usuariosdatos> findByUsrapaterno(Object usrapaterno) {
		return findByProperty(USRAPATERNO, usrapaterno);
	}

	public List<Usuariosdatos> findByUsramaterno(Object usramaterno) {
		return findByProperty(USRAMATERNO, usramaterno);
	}

	public List findAll() {
		log.debug("finding all Usuariosdatos instances");
		try {
			String queryString = "from Usuariosdatos";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Usuariosdatos merge(Usuariosdatos detachedInstance) {
		log.debug("merging Usuariosdatos instance");
		try {
			Usuariosdatos result = (Usuariosdatos) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Usuariosdatos instance) {
		log.debug("attaching dirty Usuariosdatos instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Usuariosdatos instance) {
		log.debug("attaching clean Usuariosdatos instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static UsuariosdatosDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (UsuariosdatosDAO) ctx.getBean("UsuariosdatosDAO");
	}
}