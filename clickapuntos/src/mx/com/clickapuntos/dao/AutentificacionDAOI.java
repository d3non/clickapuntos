package mx.com.clickapuntos.dao;

import java.util.List;

import mx.com.clickapuntos.persistence.Autentificacion;

public interface AutentificacionDAOI {
	public List<Autentificacion> findByProperty(String property,Object value);
	public List<Autentificacion> findAll();
}
