package mx.com.clickapuntos.dao;

import java.util.List;

import mx.com.clickapuntos.persistence.DetallePuntos;

public interface DetallePuntosDAOI {
	public void create(DetallePuntos dp);
	public void update(DetallePuntos dp);
	public void delete(DetallePuntos dp);
	public List<DetallePuntos> findAll();
	public DetallePuntos findById(Long idPuntos);
	public List<DetallePuntos> findByProperty(String property,Object value);
	public List<DetallePuntos> findByExample(DetallePuntos dp);
}
