package mx.com.clickapuntos.dao;

import java.util.List;

import mx.com.clickapuntos.persistence.ParametrosVigencias;

public interface ParametrosVigenciasDAOI {
	public void create(ParametrosVigencias ParametrosVigencias);
	public void update(ParametrosVigencias ParametrosVigencias);
	public void delete(ParametrosVigencias ParametrosVigencias);
	public List<ParametrosVigencias> findAll();
	public ParametrosVigencias findById(Long idParametrosVigencias);
	public List<ParametrosVigencias> findByProperty(String property,Object value);
	public List<ParametrosVigencias> findByExample(ParametrosVigencias ParametrosVigencias);
}
