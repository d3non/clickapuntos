package mx.com.clickapuntos.pruebaDAO;

import java.util.List;

import mx.com.clickapuntos.persistence.Clientes;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Clientes entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see mx.com.clickapuntos.persistence.Clientes
 * @author MyEclipse Persistence Tools
 */

public class ClientesDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(ClientesDAO.class);
	// property constants
	public static final String CLIENTENOMBRE = "clientenombre";
	public static final String CLIENTESTATUS = "clientestatus";
	public static final String CLIENTERAZONSOCIAL = "clienterazonsocial";
	public static final String CLIENTERFC = "clienterfc";

	protected void initDao() {
		// do nothing
	}

	public void save(Clientes transientInstance) {
		log.debug("saving Clientes instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Clientes persistentInstance) {
		log.debug("deleting Clientes instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Clientes findById(java.lang.Integer id) {
		log.debug("getting Clientes instance with id: " + id);
		try {
			Clientes instance = (Clientes) getHibernateTemplate().get(
					"mx.com.clickapuntos.persistence.Clientes", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Clientes> findByExample(Clientes instance) {
		log.debug("finding Clientes instance by example");
		try {
			List<Clientes> results = (List<Clientes>) getHibernateTemplate()
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
		log.debug("finding Clientes instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Clientes as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Clientes> findByClientenombre(Object clientenombre) {
		return findByProperty(CLIENTENOMBRE, clientenombre);
	}

	public List<Clientes> findByClientestatus(Object clientestatus) {
		return findByProperty(CLIENTESTATUS, clientestatus);
	}

	public List<Clientes> findByClienterazonsocial(Object clienterazonsocial) {
		return findByProperty(CLIENTERAZONSOCIAL, clienterazonsocial);
	}

	public List<Clientes> findByClienterfc(Object clienterfc) {
		return findByProperty(CLIENTERFC, clienterfc);
	}

	public List findAll() {
		log.debug("finding all Clientes instances");
		try {
			String queryString = "from Clientes";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Clientes merge(Clientes detachedInstance) {
		log.debug("merging Clientes instance");
		try {
			Clientes result = (Clientes) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Clientes instance) {
		log.debug("attaching dirty Clientes instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Clientes instance) {
		log.debug("attaching clean Clientes instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ClientesDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ClientesDAO) ctx.getBean("ClientesDAO");
	}
}