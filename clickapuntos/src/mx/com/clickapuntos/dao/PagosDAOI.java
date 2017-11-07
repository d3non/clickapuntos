package mx.com.clickapuntos.dao;

import java.util.List;

import mx.com.clickapuntos.persistence.Pagos;


public interface PagosDAOI {
	public void create(Pagos pagos);
	public void update(Pagos pagos);
	public void delete(Pagos pagos);
	public List<Pagos> findAll();
	public Pagos findById(Long idPagos);
	public List<Pagos> findByProperty(String property,Object value);
	public List<Pagos> findByExample(Pagos pagos);
}
