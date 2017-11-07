package mx.com.clickapuntos.dao;

import java.util.List;

import mx.com.clickapuntos.persistence.TarjetasPremios;

public interface TarjetasPremiosDAOI {
	public void create(TarjetasPremios tp);
	public void update(TarjetasPremios tp);
	public void delete(TarjetasPremios tp);
	public List<TarjetasPremios> findAll();
	public TarjetasPremios findById(Long idtarjeta);
	public List<TarjetasPremios> findByProperty(String property, Object value);
	public List<TarjetasPremios> findByExample(TarjetasPremios tp);
}
