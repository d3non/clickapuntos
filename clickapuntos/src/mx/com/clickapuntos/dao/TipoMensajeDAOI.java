package mx.com.clickapuntos.dao;

import java.util.List;

import mx.com.clickapuntos.persistence.TipoMensaje;

public interface TipoMensajeDAOI {
	public void create(TipoMensaje tp);
	public void update(TipoMensaje tp);
	public void delete(TipoMensaje tp);
	public List<TipoMensaje> findAll();
	public TipoMensaje findById(Long id);
	public List<TipoMensaje> findByProperty(String property,Object value);
	public List<TipoMensaje> findByExample(TipoMensaje tp);
}
