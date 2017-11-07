package mx.com.clickapuntos.pruebaDAO;

import java.util.List;

import mx.com.clickapuntos.persistence.Mediatipo;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Mediatipo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see mx.com.clickapuntos.persistence.Mediatipo
 * @author MyEclipse Persistence Tools
 */

public class MediatipoDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(MediatipoDAO.class);
	// property constants
	public static final String MEDIATIPODESCRIPCION = "mediatipodescripcion";

	protected void initDao() {
		// do nothing
	}

	public void save(Mediatipo transientInstance) {
		log.debug("saving Mediatipo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Mediatipo persistentInstance) {
		log.debug("deleting Mediatipo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Mediatipo findById(java.lang.Integer id) {
		log.debug("getting Mediatipo instance with id: " + id);
		try {
			Mediatipo instance = (Mediatipo) getHibernateTemplate().get(
					"mx.com.clickapuntos.persistence.Mediatipo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Mediatipo> findByExample(Mediatipo instance) {
		log.debug("finding Mediatipo instance by example");
		try {
			List<Mediatipo> results = (List<Mediatipo>) getHibernateTemplate()
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
		log.debug("finding Mediatipo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Mediatipo as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Mediatipo> findByMediatipodescripcion(
			Object mediatipodescripcion) {
		return findByProperty(MEDIATIPODESCRIPCION, mediatipodescripcion);
	}

	public List findAll() {
		log.debug("finding all Mediatipo instances");
		try {
			String queryString = "from Mediatipo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Mediatipo merge(Mediatipo detachedInstance) {
		log.debug("merging Mediatipo instance");
		try {
			Mediatipo result = (Mediatipo) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Mediatipo instance) {
		log.debug("attaching dirty Mediatipo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Mediatipo instance) {
		log.debug("attaching clean Mediatipo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static MediatipoDAO getFromApplicationContext(ApplicationContext ctx) {
		return (MediatipoDAO) ctx.getBean("MediatipoDAO");
	}
}