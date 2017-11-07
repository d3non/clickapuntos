package mx.com.clickapuntos.dao;

import java.util.List;

import mx.com.clickapuntos.persistence.TipoPago;

public interface TipoPagoDAOI {
	public void create(TipoPago tp);
	public void update(TipoPago tp);
	public void delete(TipoPago tp);
	public List<TipoPago> findAll();
	public TipoPago findById(Long id);
	public List<TipoPago> findByProperty(String property,Object value);
	public List<TipoPago> findByExample(TipoPago tp);
}
