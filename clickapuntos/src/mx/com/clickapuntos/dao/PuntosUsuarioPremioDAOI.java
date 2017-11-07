package mx.com.clickapuntos.dao;

import java.util.List;

import mx.com.clickapuntos.persistence.PremiosUsuarioId;
import mx.com.clickapuntos.persistence.PuntosUsuarioPremio;

public interface PuntosUsuarioPremioDAOI {
	public void create(PuntosUsuarioPremio pu);
	public void update(PuntosUsuarioPremio pu);
	public void delete(PuntosUsuarioPremio pu);
	public List<PuntosUsuarioPremio> findAll();
	public PuntosUsuarioPremio findById(Long idPuntos);
	public List<PuntosUsuarioPremio> findByProperty(String property,Object value);
	public List<PuntosUsuarioPremio> findByUsrPremioId(Object value1);
	public List<PuntosUsuarioPremio> findByExample(PuntosUsuarioPremio pu);
	public PuntosUsuarioPremio findById(PremiosUsuarioId id);
}
