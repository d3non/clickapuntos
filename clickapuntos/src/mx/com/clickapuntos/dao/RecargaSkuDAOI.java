package mx.com.clickapuntos.dao;

import java.util.List;

import mx.com.clickapuntos.persistence.Recargasku;

public interface RecargaSkuDAOI {
	public List<Recargasku> findByProperty(Integer property,Object value);
	public List<Recargasku> findAll();
}
