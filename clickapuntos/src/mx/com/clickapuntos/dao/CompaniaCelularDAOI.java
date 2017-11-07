package mx.com.clickapuntos.dao;

import java.util.List;

import mx.com.clickapuntos.persistence.CompaniaCelular;

public interface CompaniaCelularDAOI {
	public List<CompaniaCelular> findByProperty(String property,Object value);
	public List<CompaniaCelular> findAll();
}
