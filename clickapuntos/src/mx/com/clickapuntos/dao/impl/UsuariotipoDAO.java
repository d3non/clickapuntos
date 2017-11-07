package mx.com.clickapuntos.dao.impl;

import java.util.List;

import mx.com.clickapuntos.persistence.Usuariotipo;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Usuariotipo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see mx.com.clickapuntos.persistence.Usuariotipo
 * @author MyEclipse Persistence Tools
 */

public class UsuariotipoDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(UsuariotipoDAO.class);
	// property constants
	public static final String UTDESCRIPCION = "utdescripcion";

	protected void initDao() {
		// do nothing
	}

	public void save(Usuariotipo transientInstance) {
		log.debug("saving Usuariotipo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Usuariotipo persistentInstance) {
		log.debug("deleting Usuariotipo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Usuariotipo findById(java.lang.Integer id) {
		log.debug("getting Usuariotipo instance with id: " + id);
		try {
			Usuariotipo instance = (Usuariotipo) getHibernateTemplate().get(
					"mx.com.clickaputnos.persistence.Usuariotipo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Usuariotipo> findByExample(Usuariotipo instance) {
		log.debug("finding Usuariotipo instance by example");
		try {
			List<Usuariotipo> results = (List<Usuariotipo>) getHibernateTemplate()
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
		log.debug("finding Usuariotipo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Usuariotipo as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Usuariotipo> findByUtdescripcion(Object utdescripcion) {
		return findByProperty(UTDESCRIPCION, utdescripcion);
	}

	public List findAll() {
		log.debug("finding all Usuariotipo instances");
		try {
			String queryString = "from Usuariotipo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Usuariotipo merge(Usuariotipo detachedInstance) {
		log.debug("merging Usuariotipo instance");
		try {
			Usuariotipo result = (Usuariotipo) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Usuariotipo instance) {
		log.debug("attaching dirty Usuariotipo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Usuariotipo instance) {
		log.debug("attaching clean Usuariotipo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static UsuariotipoDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (UsuariotipoDAO) ctx.getBean("UsuariotipoDAO");
	}
}