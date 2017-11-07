package mx.com.clickapuntos.dao;

import java.util.List;

import mx.com.clickapuntos.dao.impl.GenericDAO;

import org.springframework.context.ApplicationContext;

public interface IGenericDAO<T> {
	public void Save(T t);
	public void attachDirty(T t);
	public List<T> findAll();
	public void delete(T t);
	public T findById(Object id);
	public List<T> findByProperty(String propertyName, Object value);
	public GenericDAO<?> getFromApplicationContext(ApplicationContext ctx, String Bean);
	T findByIdPrueba(Integer id);
	public T merge(T t);
	public List<T> findByPropertyOrder(String propertyName, Object value, Object order);
	public List<T> findBySQL(final String sql);
	public List<T> findWithWhere(String sql);
	public List<T> findBySQLEnt(final String  sql);
	public List<T> getComentarios(String sql);
	public List<T> getMecanica(String sql);
}
