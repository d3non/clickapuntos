package mx.com.clickapuntos.dao.impl;

import java.util.List;

import mx.com.clickapuntos.persistence.Clientesdirecciones;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Clientesdirecciones entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see mx.com.clickapuntos.persistence.Clientesdirecciones
 * @author MyEclipse Persistence Tools
 */

public class ClientesdireccionesDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(ClientesdireccionesDAO.class);
	// property constants
	public static final String CDCALLE = "cdcalle";
	public static final String CDNUMERO = "cdnumero";
	public static final String CDCOLONIA = "cdcolonia";
	public static final String CDDELMPIO = "cddelmpio";
	public static final String CDCIUDAD = "cdciudad";
	public static final String CDCODIGOPOSTAL = "cdcodigopostal";
	public static final String CDNUMEROCONTACTO = "cdnumerocontacto";
	public static final String CDNUMEROCEL = "cdnumerocel";

	protected void initDao() {
		// do nothing
	}

	public void save(Clientesdirecciones transientInstance) {
		log.debug("saving Clientesdirecciones instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Clientesdirecciones persistentInstance) {
		log.debug("deleting Clientesdirecciones instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Clientesdirecciones findById(java.lang.Integer id) {
		log.debug("getting Clientesdirecciones instance with id: " + id);
		try {
			Clientesdirecciones instance = (Clientesdirecciones) getHibernateTemplate()
					.get("mx.com.clickapuntos.persistence.Clientesdirecciones",
							id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Clientesdirecciones> findByExample(Clientesdirecciones instance) {
		log.debug("finding Clientesdirecciones instance by example");
		try {
			List<Clientesdirecciones> results = (List<Clientesdirecciones>) getHibernateTemplate()
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
		log.debug("finding Clientesdirecciones instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Clientesdirecciones as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Clientesdirecciones> findByCdcalle(Object cdcalle) {
		return findByProperty(CDCALLE, cdcalle);
	}

	public List<Clientesdirecciones> findByCdnumero(Object cdnumero) {
		return findByProperty(CDNUMERO, cdnumero);
	}

	public List<Clientesdirecciones> findByCdcolonia(Object cdcolonia) {
		return findByProperty(CDCOLONIA, cdcolonia);
	}

	public List<Clientesdirecciones> findByCddelmpio(Object cddelmpio) {
		return findByProperty(CDDELMPIO, cddelmpio);
	}

	public List<Clientesdirecciones> findByCdciudad(Object cdciudad) {
		return findByProperty(CDCIUDAD, cdciudad);
	}

	public List<Clientesdirecciones> findByCdcodigopostal(Object cdcodigopostal) {
		return findByProperty(CDCODIGOPOSTAL, cdcodigopostal);
	}

	public List<Clientesdirecciones> findByCdnumerocontacto(
			Object cdnumerocontacto) {
		return findByProperty(CDNUMEROCONTACTO, cdnumerocontacto);
	}

	public List<Clientesdirecciones> findByCdnumerocel(Object cdnumerocel) {
		return findByProperty(CDNUMEROCEL, cdnumerocel);
	}

	public List findAll() {
		log.debug("finding all Clientesdirecciones instances");
		try {
			String queryString = "from Clientesdirecciones";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Clientesdirecciones merge(Clientesdirecciones detachedInstance) {
		log.debug("merging Clientesdirecciones instance");
		try {
			Clientesdirecciones result = (Clientesdirecciones) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Clientesdirecciones instance) {
		log.debug("attaching dirty Clientesdirecciones instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Clientesdirecciones instance) {
		log.debug("attaching clean Clientesdirecciones instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ClientesdireccionesDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ClientesdireccionesDAO) ctx.getBean("ClientesdireccionesDAO");
	}
}