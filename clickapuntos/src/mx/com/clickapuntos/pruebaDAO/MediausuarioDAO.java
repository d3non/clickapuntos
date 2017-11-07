package mx.com.clickapuntos.pruebaDAO;

import java.util.List;

import mx.com.clickapuntos.persistence.Mediausuario;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Mediausuario entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see mx.com.clickapuntos.persistence.Mediausuario
 * @author MyEclipse Persistence Tools
 */

public class MediausuarioDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(MediausuarioDAO.class);
	// property constants
	public static final String MEDIAUSUARIONUMREPRODUCCION = "mediausuarionumreproduccion";
	public static final String MEDIAUSUARIOCLICK = "mediausuarioclick";
	public static final String MEDIAUSUARIOLIKE = "mediausuariolike";
	public static final String MEDIAUSUARIOFAVORITOS = "mediausuariofavoritos";

	protected void initDao() {
		// do nothing
	}

	public void save(Mediausuario transientInstance) {
		log.debug("saving Mediausuario instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Mediausuario persistentInstance) {
		log.debug("deleting Mediausuario instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Mediausuario findById(
			mx.com.clickapuntos.persistence.MediausuarioId id) {
		log.debug("getting Mediausuario instance with id: " + id);
		try {
			Mediausuario instance = (Mediausuario) getHibernateTemplate().get(
					"mx.com.clickapuntos.persistence.Mediausuario", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Mediausuario> findByExample(Mediausuario instance) {
		log.debug("finding Mediausuario instance by example");
		try {
			List<Mediausuario> results = (List<Mediausuario>) getHibernateTemplate()
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
		log.debug("finding Mediausuario instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Mediausuario as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Mediausuario> findByMediausuarionumreproduccion(
			Object mediausuarionumreproduccion) {
		return findByProperty(MEDIAUSUARIONUMREPRODUCCION,
				mediausuarionumreproduccion);
	}

	public List<Mediausuario> findByMediausuarioclick(Object mediausuarioclick) {
		return findByProperty(MEDIAUSUARIOCLICK, mediausuarioclick);
	}

	public List<Mediausuario> findByMediausuariolike(Object mediausuariolike) {
		return findByProperty(MEDIAUSUARIOLIKE, mediausuariolike);
	}

	public List<Mediausuario> findByMediausuariofavoritos(
			Object mediausuariofavoritos) {
		return findByProperty(MEDIAUSUARIOFAVORITOS, mediausuariofavoritos);
	}

	public List findAll() {
		log.debug("finding all Mediausuario instances");
		try {
			String queryString = "from Mediausuario";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Mediausuario merge(Mediausuario detachedInstance) {
		log.debug("merging Mediausuario instance");
		try {
			Mediausuario result = (Mediausuario) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Mediausuario instance) {
		log.debug("attaching dirty Mediausuario instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Mediausuario instance) {
		log.debug("attaching clean Mediausuario instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static MediausuarioDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (MediausuarioDAO) ctx.getBean("MediausuarioDAO");
	}
}