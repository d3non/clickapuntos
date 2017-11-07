package mx.com.clickapuntos.pruebaDAO;

import java.util.List;

import mx.com.clickapuntos.persistence.Usuarioproperties;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Usuarioproperties entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see mx.com.clickapuntos.persistence.Usuarioproperties
 * @author MyEclipse Persistence Tools
 */

public class UsuariopropertiesDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(UsuariopropertiesDAO.class);
	// property constants
	public static final String UPCAMPO = "upcampo";
	public static final String UPVALOR = "upvalor";
	public static final String UPFUENTE = "upfuente";

	protected void initDao() {
		// do nothing
	}

	public void save(Usuarioproperties transientInstance) {
		log.debug("saving Usuarioproperties instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Usuarioproperties persistentInstance) {
		log.debug("deleting Usuarioproperties instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Usuarioproperties findById(java.lang.Integer id) {
		log.debug("getting Usuarioproperties instance with id: " + id);
		try {
			Usuarioproperties instance = (Usuarioproperties) getHibernateTemplate()
					.get("mx.com.clickapuntos.persistence.Usuarioproperties",
							id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Usuarioproperties> findByExample(Usuarioproperties instance) {
		log.debug("finding Usuarioproperties instance by example");
		try {
			List<Usuarioproperties> results = (List<Usuarioproperties>) getHibernateTemplate()
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
		log.debug("finding Usuarioproperties instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Usuarioproperties as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Usuarioproperties> findByUpcampo(Object upcampo) {
		return findByProperty(UPCAMPO, upcampo);
	}

	public List<Usuarioproperties> findByUpvalor(Object upvalor) {
		return findByProperty(UPVALOR, upvalor);
	}

	public List<Usuarioproperties> findByUpfuente(Object upfuente) {
		return findByProperty(UPFUENTE, upfuente);
	}

	public List findAll() {
		log.debug("finding all Usuarioproperties instances");
		try {
			String queryString = "from Usuarioproperties";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Usuarioproperties merge(Usuarioproperties detachedInstance) {
		log.debug("merging Usuarioproperties instance");
		try {
			Usuarioproperties result = (Usuarioproperties) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Usuarioproperties instance) {
		log.debug("attaching dirty Usuarioproperties instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Usuarioproperties instance) {
		log.debug("attaching clean Usuarioproperties instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static UsuariopropertiesDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (UsuariopropertiesDAO) ctx.getBean("UsuariopropertiesDAO");
	}
}