package mx.com.clickapuntos.pruebaDAO;

import java.util.List;

import mx.com.clickapuntos.persistence.Promos;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Promos entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see mx.com.clickapuntos.persistence.Promos
 * @author MyEclipse Persistence Tools
 */

public class PromosDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(PromosDAO.class);
	// property constants
	public static final String PROMODESCRIPCION = "promodescripcion";
	public static final String PROMOMECANICA = "promomecanica";
	public static final String PROMOMECANICAIMAGEN = "promomecanicaimagen";
	public static final String PROMONUMEROPUNTOS = "promonumeropuntos";
	public static final String PROMOSTATUS = "promostatus";

	protected void initDao() {
		// do nothing
	}

	public void save(Promos transientInstance) {
		log.debug("saving Promos instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Promos persistentInstance) {
		log.debug("deleting Promos instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Promos findById(java.lang.Integer id) {
		log.debug("getting Promos instance with id: " + id);
		try {
			Promos instance = (Promos) getHibernateTemplate().get(
					"mx.com.clickapuntos.persistence.Promos", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Promos> findByExample(Promos instance) {
		log.debug("finding Promos instance by example");
		try {
			List<Promos> results = (List<Promos>) getHibernateTemplate()
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
		log.debug("finding Promos instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Promos as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Promos> findByPromodescripcion(Object promodescripcion) {
		return findByProperty(PROMODESCRIPCION, promodescripcion);
	}

	public List<Promos> findByPromomecanica(Object promomecanica) {
		return findByProperty(PROMOMECANICA, promomecanica);
	}

	public List<Promos> findByPromomecanicaimagen(Object promomecanicaimagen) {
		return findByProperty(PROMOMECANICAIMAGEN, promomecanicaimagen);
	}

	public List<Promos> findByPromonumeropuntos(Object promonumeropuntos) {
		return findByProperty(PROMONUMEROPUNTOS, promonumeropuntos);
	}

	public List<Promos> findByPromostatus(Object promostatus) {
		return findByProperty(PROMOSTATUS, promostatus);
	}

	public List findAll() {
		log.debug("finding all Promos instances");
		try {
			String queryString = "from Promos";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Promos merge(Promos detachedInstance) {
		log.debug("merging Promos instance");
		try {
			Promos result = (Promos) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Promos instance) {
		log.debug("attaching dirty Promos instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Promos instance) {
		log.debug("attaching clean Promos instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PromosDAO getFromApplicationContext(ApplicationContext ctx) {
		return (PromosDAO) ctx.getBean("PromosDAO");
	}
}