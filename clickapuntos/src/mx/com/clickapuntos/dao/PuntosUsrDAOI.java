package mx.com.clickapuntos.dao;

import java.util.List;

import mx.com.clickapuntos.persistence.PuntosUsr;

public interface PuntosUsrDAOI {
	public void create(PuntosUsr pu);
	public void update(PuntosUsr pu);
	public void delete(PuntosUsr pu);
	public List<PuntosUsr> findAll();
	public PuntosUsr findById(Long idPuntos);
	public List<PuntosUsr> findByProperty(String property,Object value);
	public List<PuntosUsr> findByUsrPromoId(Object value1,Object value2);
	public List<PuntosUsr> findByExample(PuntosUsr pu);
}
