package mx.com.clickapuntos.pruebaDAO;

import java.util.List;

import mx.com.clickapuntos.persistence.Usuariosdirecciones;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Usuariosdirecciones entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see mx.com.clickapuntos.persistence.Usuariosdirecciones
 * @author MyEclipse Persistence Tools
 */

public class UsuariosdireccionesDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(UsuariosdireccionesDAO.class);
	// property constants
	public static final String UDCALLE = "udcalle";
	public static final String UDNUMERO = "udnumero";
	public static final String UDCOLONIA = "udcolonia";
	public static final String UDDELMPIO = "uddelmpio";
	public static final String UDCIUDAD = "udciudad";
	public static final String UDCODIGOPOSTAL = "udcodigopostal";
	public static final String UDNUMEROCONTACTO = "udnumerocontacto";
	public static final String UDNUMEROCEL = "udnumerocel";

	protected void initDao() {
		// do nothing
	}

	public void save(Usuariosdirecciones transientInstance) {
		log.debug("saving Usuariosdirecciones instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Usuariosdirecciones persistentInstance) {
		log.debug("deleting Usuariosdirecciones instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Usuariosdirecciones findById(java.lang.Integer id) {
		log.debug("getting Usuariosdirecciones instance with id: " + id);
		try {
			Usuariosdirecciones instance = (Usuariosdirecciones) getHibernateTemplate()
					.get("mx.com.clickapuntos.persistence.Usuariosdirecciones",
							id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Usuariosdirecciones> findByExample(Usuariosdirecciones instance) {
		log.debug("finding Usuariosdirecciones instance by example");
		try {
			List<Usuariosdirecciones> results = (List<Usuariosdirecciones>) getHibernateTemplate()
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
		log.debug("finding Usuariosdirecciones instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Usuariosdirecciones as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Usuariosdirecciones> findByUdcalle(Object udcalle) {
		return findByProperty(UDCALLE, udcalle);
	}

	public List<Usuariosdirecciones> findByUdnumero(Object udnumero) {
		return findByProperty(UDNUMERO, udnumero);
	}

	public List<Usuariosdirecciones> findByUdcolonia(Object udcolonia) {
		return findByProperty(UDCOLONIA, udcolonia);
	}

	public List<Usuariosdirecciones> findByUddelmpio(Object uddelmpio) {
		return findByProperty(UDDELMPIO, uddelmpio);
	}

	public List<Usuariosdirecciones> findByUdciudad(Object udciudad) {
		return findByProperty(UDCIUDAD, udciudad);
	}

	public List<Usuariosdirecciones> findByUdcodigopostal(Object udcodigopostal) {
		return findByProperty(UDCODIGOPOSTAL, udcodigopostal);
	}

	public List<Usuariosdirecciones> findByUdnumerocontacto(
			Object udnumerocontacto) {
		return findByProperty(UDNUMEROCONTACTO, udnumerocontacto);
	}

	public List<Usuariosdirecciones> findByUdnumerocel(Object udnumerocel) {
		return findByProperty(UDNUMEROCEL, udnumerocel);
	}

	public List findAll() {
		log.debug("finding all Usuariosdirecciones instances");
		try {
			String queryString = "from Usuariosdirecciones";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Usuariosdirecciones merge(Usuariosdirecciones detachedInstance) {
		log.debug("merging Usuariosdirecciones instance");
		try {
			Usuariosdirecciones result = (Usuariosdirecciones) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Usuariosdirecciones instance) {
		log.debug("attaching dirty Usuariosdirecciones instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Usuariosdirecciones instance) {
		log.debug("attaching clean Usuariosdirecciones instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static UsuariosdireccionesDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (UsuariosdireccionesDAO) ctx.getBean("UsuariosdireccionesDAO");
	}
}