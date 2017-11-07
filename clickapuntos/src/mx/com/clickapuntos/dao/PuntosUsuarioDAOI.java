package mx.com.clickapuntos.dao;

import java.util.List;

import mx.com.clickapuntos.persistence.PuntosUsuarios;

public interface PuntosUsuarioDAOI {
	public void create(PuntosUsuarios tp);
	public void update(PuntosUsuarios tp);
	public void delete(PuntosUsuarios tp);
	public List<PuntosUsuarios> findAll();
	public PuntosUsuarios findById(Long id);
	public List<PuntosUsuarios> findByProperty(String property,Object value);
	public List<PuntosUsuarios> findByExample(PuntosUsuarios tp);
}
