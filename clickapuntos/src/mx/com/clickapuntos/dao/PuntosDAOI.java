package mx.com.clickapuntos.dao;

import java.util.List;

import mx.com.clickapuntos.persistence.Puntos;

public interface PuntosDAOI {
	public void create(Puntos pu);
	public void update(Puntos pu);
	public void delete(Puntos pu);
	public List<Puntos> findAll();
	public Puntos findById(Long idPuntos);
	public List<Puntos> findByProperty(String property,Object value);
	public List<Puntos> findByExample(Puntos pu);
}
