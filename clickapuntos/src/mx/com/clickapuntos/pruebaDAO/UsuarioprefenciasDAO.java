package mx.com.clickapuntos.pruebaDAO;

import java.util.List;

import mx.com.clickapuntos.persistence.Usuarioprefencias;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Usuarioprefencias entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see mx.com.clickapuntos.persistence.Usuarioprefencias
 * @author MyEclipse Persistence Tools
 */

public class UsuarioprefenciasDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(UsuarioprefenciasDAO.class);

	// property constants

	protected void initDao() {
		// do nothing
	}

	public void save(Usuarioprefencias transientInstance) {
		log.debug("saving Usuarioprefencias instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Usuarioprefencias persistentInstance) {
		log.debug("deleting Usuarioprefencias instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Usuarioprefencias findById(
			mx.com.clickapuntos.persistence.UsuarioprefenciasId id) {
		log.debug("getting Usuarioprefencias instance with id: " + id);
		try {
			Usuarioprefencias instance = (Usuarioprefencias) getHibernateTemplate()
					.get("mx.com.clickapuntos.persistence.Usuarioprefencias",
							id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Usuarioprefencias> findByExample(Usuarioprefencias instance) {
		log.debug("finding Usuarioprefencias instance by example");
		try {
			List<Usuarioprefencias> results = (List<Usuarioprefencias>) getHibernateTemplate()
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
		log.debug("finding Usuarioprefencias instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Usuarioprefencias as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Usuarioprefencias instances");
		try {
			String queryString = "from Usuarioprefencias";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Usuarioprefencias merge(Usuarioprefencias detachedInstance) {
		log.debug("merging Usuarioprefencias instance");
		try {
			Usuarioprefencias result = (Usuarioprefencias) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Usuarioprefencias instance) {
		log.debug("attaching dirty Usuarioprefencias instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Usuarioprefencias instance) {
		log.debug("attaching clean Usuarioprefencias instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static UsuarioprefenciasDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (UsuarioprefenciasDAO) ctx.getBean("UsuarioprefenciasDAO");
	}
}