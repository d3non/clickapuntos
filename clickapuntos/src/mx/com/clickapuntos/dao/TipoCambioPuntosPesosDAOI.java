package mx.com.clickapuntos.dao;

import java.util.List;

import mx.com.clickapuntos.persistence.TipoCambioPuntosPesos;

public interface TipoCambioPuntosPesosDAOI {
	public void create(TipoCambioPuntosPesos tcpp);
	public void update(TipoCambioPuntosPesos tcpp);
	public void delete(TipoCambioPuntosPesos tcpp);
	public List<TipoCambioPuntosPesos> findAll();
	public TipoCambioPuntosPesos findById(Long id);
	public List<TipoCambioPuntosPesos> findByProperty(String property,Object value);
	public List<TipoCambioPuntosPesos> findByExample(TipoCambioPuntosPesos tcpp);
}
