package mx.com.clickapuntos.dao;

import java.util.List;

import mx.com.clickapuntos.persistence.DetallePromo;

public interface DetallePromoDAOI {
	public void create(DetallePromo dp);
	public void update(DetallePromo dp);
	public void delete(DetallePromo dp);
	public List<DetallePromo> findAll();
	public DetallePromo findById(Long idPromo);
	public List<DetallePromo> findByProperty(String property,Object value);
	public List<DetallePromo> findByExample(DetallePromo dp);
}
