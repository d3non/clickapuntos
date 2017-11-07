package mx.com.clickapuntos.pruebaDAO;

import java.util.List;

import mx.com.clickapuntos.persistence.Mediapropiedades;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Mediapropiedades entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see mx.com.clickapuntos.persistence.Mediapropiedades
 * @author MyEclipse Persistence Tools
 */

public class MediapropiedadesDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(MediapropiedadesDAO.class);
	// property constants
	public static final String MPFUENTEID = "mpfuenteid";
	public static final String MPFUENTE = "mpfuente";
	public static final String MPDESCRIPCION = "mpdescripcion";

	protected void initDao() {
		// do nothing
	}

	public void save(Mediapropiedades transientInstance) {
		log.debug("saving Mediapropiedades instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Mediapropiedades persistentInstance) {
		log.debug("deleting Mediapropiedades instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Mediapropiedades findById(java.lang.Integer id) {
		log.debug("getting Mediapropiedades instance with id: " + id);
		try {
			Mediapropiedades instance = (Mediapropiedades) getHibernateTemplate()
					.get("mx.com.clickapuntos.persistence.Mediapropiedades", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Mediapropiedades> findByExample(Mediapropiedades instance) {
		log.debug("finding Mediapropiedades instance by example");
		try {
			List<Mediapropiedades> results = (List<Mediapropiedades>) getHibernateTemplate()
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
		log.debug("finding Mediapropiedades instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Mediapropiedades as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Mediapropiedades> findByMpfuenteid(Object mpfuenteid) {
		return findByProperty(MPFUENTEID, mpfuenteid);
	}

	public List<Mediapropiedades> findByMpfuente(Object mpfuente) {
		return findByProperty(MPFUENTE, mpfuente);
	}

	public List<Mediapropiedades> findByMpdescripcion(Object mpdescripcion) {
		return findByProperty(MPDESCRIPCION, mpdescripcion);
	}

	public List findAll() {
		log.debug("finding all Mediapropiedades instances");
		try {
			String queryString = "from Mediapropiedades";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Mediapropiedades merge(Mediapropiedades detachedInstance) {
		log.debug("merging Mediapropiedades instance");
		try {
			Mediapropiedades result = (Mediapropiedades) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Mediapropiedades instance) {
		log.debug("attaching dirty Mediapropiedades instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Mediapropiedades instance) {
		log.debug("attaching clean Mediapropiedades instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static MediapropiedadesDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (MediapropiedadesDAO) ctx.getBean("MediapropiedadesDAO");
	}
}