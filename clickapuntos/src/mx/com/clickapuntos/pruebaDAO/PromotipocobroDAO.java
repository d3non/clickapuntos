package mx.com.clickapuntos.pruebaDAO;

import java.util.List;

import mx.com.clickapuntos.persistence.Promotipocobro;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Promotipocobro entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see mx.com.clickapuntos.persistence.Promotipocobro
 * @author MyEclipse Persistence Tools
 */

public class PromotipocobroDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(PromotipocobroDAO.class);
	// property constants
	public static final String PROMOTIPOCOBRODESCRIPCION = "promotipocobrodescripcion";
	public static final String PROMOTIPOCOBROVALOR = "promotipocobrovalor";

	protected void initDao() {
		// do nothing
	}

	public void save(Promotipocobro transientInstance) {
		log.debug("saving Promotipocobro instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Promotipocobro persistentInstance) {
		log.debug("deleting Promotipocobro instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Promotipocobro findById(java.lang.Integer id) {
		log.debug("getting Promotipocobro instance with id: " + id);
		try {
			Promotipocobro instance = (Promotipocobro) getHibernateTemplate()
					.get("mx.com.clickapuntos.persistence.Promotipocobro", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Promotipocobro> findByExample(Promotipocobro instance) {
		log.debug("finding Promotipocobro instance by example");
		try {
			List<Promotipocobro> results = (List<Promotipocobro>) getHibernateTemplate()
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
		log.debug("finding Promotipocobro instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Promotipocobro as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Promotipocobro> findByPromotipocobrodescripcion(
			Object promotipocobrodescripcion) {
		return findByProperty(PROMOTIPOCOBRODESCRIPCION,
				promotipocobrodescripcion);
	}

	public List<Promotipocobro> findByPromotipocobrovalor(
			Object promotipocobrovalor) {
		return findByProperty(PROMOTIPOCOBROVALOR, promotipocobrovalor);
	}

	public List findAll() {
		log.debug("finding all Promotipocobro instances");
		try {
			String queryString = "from Promotipocobro";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Promotipocobro merge(Promotipocobro detachedInstance) {
		log.debug("merging Promotipocobro instance");
		try {
			Promotipocobro result = (Promotipocobro) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Promotipocobro instance) {
		log.debug("attaching dirty Promotipocobro instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Promotipocobro instance) {
		log.debug("attaching clean Promotipocobro instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PromotipocobroDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (PromotipocobroDAO) ctx.getBean("PromotipocobroDAO");
	}
}