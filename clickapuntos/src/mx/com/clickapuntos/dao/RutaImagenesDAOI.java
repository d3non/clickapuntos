package mx.com.clickapuntos.dao;

import java.util.List;

import mx.com.clickapuntos.persistence.RutasImagenes;

public interface RutaImagenesDAOI {
	public void create(RutasImagenes tcpp);
	public void update(RutasImagenes tcpp);
	public void delete(RutasImagenes tcpp);
	public List<RutasImagenes> findAll();
	public RutasImagenes findById(Long id);
	public List<RutasImagenes> findByProperty(String property,Object value);
	public List<RutasImagenes> findByExample(RutasImagenes tcpp);
}
