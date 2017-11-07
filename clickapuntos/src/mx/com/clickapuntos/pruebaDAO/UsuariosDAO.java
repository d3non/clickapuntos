package mx.com.clickapuntos.pruebaDAO;

import java.util.List;

import mx.com.clickapuntos.persistence.Usuarios;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Usuarios entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see mx.com.clickapuntos.persistence.Usuarios
 * @author MyEclipse Persistence Tools
 */

public class UsuariosDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(UsuariosDAO.class);
	// property constants
	public static final String USRUSERNAME = "usrusername";
	public static final String USRTERCEROID = "usrterceroid";
	public static final String USRSTATUS = "usrstatus";
	public static final String USREMAIL = "usremail";

	protected void initDao() {
		// do nothing
	}

	public void save(Usuarios transientInstance) {
		log.debug("saving Usuarios instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Usuarios persistentInstance) {
		log.debug("deleting Usuarios instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Usuarios findById(java.lang.Integer id) {
		log.debug("getting Usuarios instance with id: " + id);
		try {
			Usuarios instance = (Usuarios) getHibernateTemplate().get(
					"mx.com.clickapuntos.persistence.Usuarios", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Usuarios> findByExample(Usuarios instance) {
		log.debug("finding Usuarios instance by example");
		try {
			List<Usuarios> results = (List<Usuarios>) getHibernateTemplate()
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
		log.debug("finding Usuarios instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Usuarios as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Usuarios> findByUsrusername(Object usrusername) {
		return findByProperty(USRUSERNAME, usrusername);
	}

	public List<Usuarios> findByUsrterceroid(Object usrterceroid) {
		return findByProperty(USRTERCEROID, usrterceroid);
	}

	public List<Usuarios> findByUsrstatus(Object usrstatus) {
		return findByProperty(USRSTATUS, usrstatus);
	}

	public List<Usuarios> findByUsremail(Object usremail) {
		return findByProperty(USREMAIL, usremail);
	}

	public List findAll() {
		log.debug("finding all Usuarios instances");
		try {
			String queryString = "from Usuarios";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Usuarios merge(Usuarios detachedInstance) {
		log.debug("merging Usuarios instance");
		try {
			Usuarios result = (Usuarios) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Usuarios instance) {
		log.debug("attaching dirty Usuarios instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Usuarios instance) {
		log.debug("attaching clean Usuarios instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static UsuariosDAO getFromApplicationContext(ApplicationContext ctx) {
		return (UsuariosDAO) ctx.getBean("UsuariosDAO");
	}
}