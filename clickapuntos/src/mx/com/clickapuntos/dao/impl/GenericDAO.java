package mx.com.clickapuntos.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import mx.com.clickapuntos.dao.IGenericDAO;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

/* ----------------------------------------------------------------------
* MediaService 1.0
* 
* Este software contiene informacion totalmente confidencial propiedad de PixanMedia.
* Queda totalmente prohibido su uso o divulgacion en forma parcial o total y solamente
* podra ser utilizada de acuerdo a los terminos y estatutos que determine dicha empresa
*
* Diseño: ISC Diego A. Zarate Diaz
* diegoazd@hotmail.com
* PixanMedia
*
* Construcción: Diego A. Zarate Diaz
* diegoazd@hotmail.com
* PixanMedia
*
* Este clase un DAO generico que usa HibernateDaoSupport de spring para apoyarse en el manejo de las sesiones
*  
*
* Septiembre 2011
* ---------------------------------------------------------------------*/

public class GenericDAO<T> extends HibernateDaoSupport implements IGenericDAO<T>{
	private static final Logger log = LoggerFactory.getLogger(GenericDAO.class);	
	
	protected Class<T> entityClass;
		
	public GenericDAO(Class<T> type) {
		this.entityClass = type;

    }
	
	/*
	 * Clase que se encarga de guarde un T(tipo parametrizado)
	 * */
	@Override
	public void Save(T t) {
		log.debug("saving Usuario instance");
		try {
			getHibernateTemplate().save(t);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
		
	}
	
	@Override
	public void attachDirty(T t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(T t) {
		// TODO Auto-generated method stub
		
	}
	
	/*
	 * Clase que regresa todo lo que ay en la base de datos(tipo parametrizado)
	 * */
	@Override
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		log.debug("finding all Usuario instances");
		try {
			
			String queryString = "from "+entityClass.getName();
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	/*
	 * Clase que consulta por id(Objeto con el tipo de campo puede ser un Integer, String, Llage multiplo, etc),
	 *  en T(que es un tipoparametrizado)
	 * */
	@SuppressWarnings("unchecked")
	@Override
	public T findById(Object id) {		
		log.debug("getting Generic instance with id: " + id);
		try {
			T tGen = (T)getHibernateTemplate().get(
					entityClass.getName(), (Serializable) id);
			return tGen;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public T findByIdPrueba(Integer id) {
		log.debug("getting Generic instance with id: " + id);
		try {
			T tGen = (T)getHibernateTemplate().get(
					entityClass.getName(), id);
			return tGen;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	/*
	 * Consulta en la base de datos por propiedad en la BD
	 * */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByProperty(
			String propertyName, Object value) {	
	
		log.debug("finding Generic instance with property: " + propertyName
			+ ", value: " + value);
		try {
			String queryString = "from "+ entityClass.getName() +" as model where model."
				+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	/*
	 * Actualiza en la BD una clase T(tipo parametrizado)
	 * */
	public T merge(T t) {
		log.debug("merging Generic instance");
		try {
			T result = (T) getHibernateTemplate().merge(
					t);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
	
	/*
	 * Busca por propiedad y también manda como parametro el campo que se va a ordenar
	 * */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByPropertyOrder(
			String propertyName, Object value, Object order) {	
	
		log.debug("finding Generic instance with property: " + propertyName
			+ ", value: " + value);
		try {
			String queryString = "from "+ entityClass.getName() +" as model where model."
				+ propertyName + "= ? order by "+order +" desc";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	/*
	 * En este metodo se manda el where de la sentencia HQL
	 * */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findWithWhere(String sql){		
		log.debug("finding Generic instance with SQL: " + sql);
		try {
			
			String queryString = "from "+ entityClass.getName() +" where "+sql;
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}	
	
	/*
	 * En este metodo se ejecuta una consulta SQL y regresa una lista del tipo Object[]
	 * */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	@Transactional(readOnly=false)
	public List<T> findBySQL(final String  sql){	
	
		log.debug("finding Generic instance with SQL cueri: "+sql );
		try {			
			List resultList = (List<T>)getHibernateTemplate().executeFind(new HibernateCallback() {
				@Override
				public T doInHibernate(Session session) throws HibernateException,
						SQLException {
					Query finalQuery = session.createSQLQuery(sql);
					return (T) finalQuery.list();
				}
			});			
			
			
			return resultList;
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	/*
	 * En este metodo se ejecuta una consulta SQL y regresa una lista del tipo List<T> donde T es el tipo parametrizable
	 * */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	@Transactional(readOnly=false)
	public List<T> findBySQLEnt(final String  sql){	
	
		log.debug("finding Generic instance with SQL cueri: "+sql );
		try {			
			List resultList = (List<T>)getHibernateTemplate().executeFind(new HibernateCallback() {
				@Override
				public T doInHibernate(Session session) throws HibernateException,
						SQLException {
					Query finalQuery = session.createSQLQuery(sql).addEntity(entityClass);
					return (T) finalQuery.list();
				}
			});			
			
			
			return resultList;
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}	
	
	
	/*
	 * En este metodo se ejecuta una consulta SQL y regresa una lista del tipo List<T> donde T es el tipo parametrizable
	 * */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	@Transactional(readOnly=false)
	public List<T> getComentarios(final String  sql){	
	
		log.debug("obtenemos la lista de comentaios: "+sql );
		try {			
			List resultList = (List<T>)getHibernateTemplate().executeFind(new HibernateCallback() {
				@Override
				public T doInHibernate(Session session) throws HibernateException,
						SQLException {
					Query finalQuery = session.createSQLQuery(sql).addEntity(entityClass);
					return (T) finalQuery.list();
				}
			});			
			
			
			return resultList;
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}	
	
	
	
	

	/* (non-Javadoc)
	 * @see mx.com.clickapuntos.dao.IGenericDAO#getMecanica(java.lang.String)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	@Transactional(readOnly=false)

	public List<T> getMecanica(final String sql) {

		log.debug("obtenemos la lista de mecanica: "+sql );
		try {			
			List resultList = (List<T>)getHibernateTemplate().executeFind(new HibernateCallback() {
				@Override
				public T doInHibernate(Session session) throws HibernateException,
						SQLException {
					Query finalQuery = session.createSQLQuery(sql).addEntity(entityClass);
					return (T) finalQuery.list();
				}
			});			
			
			
			return resultList;
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
		
	}

	/*
	 * Regresa el GenericDAO que del ApplicationContext
	 * */
	public GenericDAO<?> getFromApplicationContext(ApplicationContext ctx,
			String Bean) {
		return (GenericDAO<?>) ctx.getBean(Bean);
	}


	
	
	
}
