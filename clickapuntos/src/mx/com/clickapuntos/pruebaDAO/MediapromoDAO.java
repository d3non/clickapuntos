package mx.com.clickapuntos.pruebaDAO;

import java.util.List;

import mx.com.clickapuntos.persistence.Mediapromo;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Mediapromo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see mx.com.clickapuntos.persistence.Mediapromo
 * @author MyEclipse Persistence Tools
 */

public class MediapromoDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(MediapromoDAO.class);

	// property constants

	protected void initDao() {
		// do nothing
	}

	public void save(Mediapromo transientInstance) {
		log.debug("saving Mediapromo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Mediapromo persistentInstance) {
		log.debug("deleting Mediapromo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Mediapromo findById(mx.com.clickapuntos.persistence.MediapromoId id) {
		log.debug("getting Mediapromo instance with id: " + id);
		try {
			Mediapromo instance = (Mediapromo) getHibernateTemplate().get(
					"mx.com.clickapuntos.persistence.Mediapromo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Mediapromo> findByExample(Mediapromo instance) {
		log.debug("finding Mediapromo instance by example");
		try {
			List<Mediapromo> results = (List<Mediapromo>) getHibernateTemplate()
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
		log.debug("finding Mediapromo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Mediapromo as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Mediapromo instances");
		try {
			String queryString = "from Mediapromo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Mediapromo merge(Mediapromo detachedInstance) {
		log.debug("merging Mediapromo instance");
		try {
			Mediapromo result = (Mediapromo) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Mediapromo instance) {
		log.debug("attaching dirty Mediapromo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Mediapromo instance) {
		log.debug("attaching clean Mediapromo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static MediapromoDAO getFromApplicationContext(ApplicationContext ctx) {
		return (MediapromoDAO) ctx.getBean("MediapromoDAO");
	}
}