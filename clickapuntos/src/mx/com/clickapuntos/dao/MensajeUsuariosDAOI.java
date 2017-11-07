package mx.com.clickapuntos.dao;

import java.util.List;

import mx.com.clickapuntos.persistence.MensajeUsuarios;

public interface MensajeUsuariosDAOI {
	public void create(MensajeUsuarios MensajeUsuarios);
	public void update(MensajeUsuarios MensajeUsuarios);
	public void delete(MensajeUsuarios MensajeUsuarios);
	public List<MensajeUsuarios> findAll();
	public MensajeUsuarios findById(Long idMensajeUsuarios);
	public List<MensajeUsuarios> findByProperty(String property,Object value);
	public List<MensajeUsuarios> findByExample(MensajeUsuarios MensajeUsuarios);
}
