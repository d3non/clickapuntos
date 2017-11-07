package mx.com.clickapuntos.dao.impl;

import java.util.List;

import mx.com.clickapuntos.persistence.Promotipomecanica;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Promotipomecanica entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see mx.com.clickapuntos.persistence.Promotipomecanica
 * @author MyEclipse Persistence Tools
 */

public class PromotipomecanicaDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(PromotipomecanicaDAO.class);
	// property constants
	public static final String PROMOTIPOMECANICADESCRIPCION = "promotipomecanicadescripcion";

	protected void initDao() {
		// do nothing
	}

	public void save(Promotipomecanica transientInstance) {
		log.debug("saving Promotipomecanica instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Promotipomecanica persistentInstance) {
		log.debug("deleting Promotipomecanica instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Promotipomecanica findById(java.lang.Integer id) {
		log.debug("getting Promotipomecanica instance with id: " + id);
		try {
			Promotipomecanica instance = (Promotipomecanica) getHibernateTemplate()
					.get("mx.com.clickapuntos.persistence.Promotipomecanica",
							id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Promotipomecanica> findByExample(Promotipomecanica instance) {
		log.debug("finding Promotipomecanica instance by example");
		try {
			List<Promotipomecanica> results = (List<Promotipomecanica>) getHibernateTemplate()
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
		log.debug("finding Promotipomecanica instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Promotipomecanica as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Promotipomecanica> findByPromotipomecanicadescripcion(
			Object promotipomecanicadescripcion) {
		return findByProperty(PROMOTIPOMECANICADESCRIPCION,
				promotipomecanicadescripcion);
	}

	public List findAll() {
		log.debug("finding all Promotipomecanica instances");
		try {
			String queryString = "from Promotipomecanica";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Promotipomecanica merge(Promotipomecanica detachedInstance) {
		log.debug("merging Promotipomecanica instance");
		try {
			Promotipomecanica result = (Promotipomecanica) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Promotipomecanica instance) {
		log.debug("attaching dirty Promotipomecanica instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Promotipomecanica instance) {
		log.debug("attaching clean Promotipomecanica instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PromotipomecanicaDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (PromotipomecanicaDAO) ctx.getBean("PromotipomecanicaDAO");
	}
}