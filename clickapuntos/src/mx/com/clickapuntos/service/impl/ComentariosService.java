package mx.com.clickapuntos.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import mx.com.clickapuntos.dao.impl.ComentariosDAO;
import mx.com.clickapuntos.persistence.Comentarios;
import mx.com.clickapuntos.service.IComentariosService;

@Service
public class ComentariosService implements IComentariosService {
	private ComentariosDAO comentariosDAO;
	
	@Inject
	public void setComentariosDAO(ComentariosDAO  comentariosDAO) {
		this.comentariosDAO = comentariosDAO;
	}
	
	@Override
	public void Save(Comentarios coment) {
		System.out.println("Guardando Comentario.....");
		comentariosDAO.save(coment);
	}

}
