package mx.com.clickapuntos.dao;

import java.util.List;

import mx.com.clickapuntos.persistence.EmailConfirmacion;

public interface EmailConfirmacionDAOI {
	public List<EmailConfirmacion> findAll();
}
