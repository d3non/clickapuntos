package mx.com.clickapuntos.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.clickapuntos.persistence.ComentarioPromoMediaUsuarioId;
import mx.com.clickapuntos.persistence.Comentarios;
import mx.com.clickapuntos.service.IComentariosService;
import mx.com.clickapuntos.service.IMediaService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.metaparadigm.jsonrpc.JSONRPCBridge;
import com.metaparadigm.jsonrpc.MarshallException;

@Controller
public class ComentariosController {
	private IComentariosService comentariosService;
	public IMediaService mediaService;
	@Inject
	public void setComentariosService(IComentariosService comentariosService) {
		this.comentariosService = comentariosService;
	}
	@Inject
	public void setHomeService(IMediaService mediaService) {
		this.mediaService = mediaService;
	}
	@RequestMapping({"/guardaComentario.htm"})
	public String insTop5(Map<String,Object> model,HttpServletRequest req,HttpServletResponse response){
		if(req.getParameter("idUsuario").equals("")==false){
			System.out.println("idPromo: " + req.getParameter("idPromo"));
			System.out.println("idMedia: " + req.getParameter("idMedia"));
			System.out.println("idUsuario " + req.getParameter("idUsuario"));
			System.out.println("comentarioTexto: " + req.getParameter("comentarioTexto"));
			System.out.println("Iniciando guardado de medias");
			Comentarios comenta=new Comentarios();
			ComentarioPromoMediaUsuarioId id=new ComentarioPromoMediaUsuarioId();
			id.setMediaIdmedia(Integer.parseInt(req.getParameter("idMedia")));
			id.setPromosIdpromo(Integer.parseInt(req.getParameter("idPromo")));
			id.setUsuariosIdUsuario(Long.parseLong(req.getParameter("idUsuario")));
			comenta.setId(id);
			comenta.setComentariostexto(req.getParameter("comentarioTexto"));
			comenta.setComentarioreporte(Integer.parseInt(req.getParameter("comentarioReporte")));
			comenta.setComentariostatus(req.getParameter("comentarioStatus"));
			comenta.setComentarioreporte(Integer.parseInt(req.getParameter("comentarioReporte")));
			comenta.setComentariotono(Integer.parseInt(req.getParameter("comentarioTono")));
			comenta.setFechacomentario(new Timestamp(new Date().getTime()));
			comentariosService.Save(comenta);
		
		}
		//**************************************
		String res="";

		try {
			res = JSONRPCBridge.getGlobalBridge().getSerializer().toJSON(mediaService.getComentariosBean(Integer.parseInt(req.getParameter("idPromo"))));       
			
			response.setContentType("text/html;  charset=iso-8859-1");
	        response.setHeader("Cache-Control", "no-cache");
	        PrintWriter out = response.getWriter();
	        response.getWriter().write(res);
		} catch (MarshallException me) {
			System.out.println("Error JSON");		
		} catch (IOException e) {
			System.out.println("Otro error " + e);		
		}
		return null;
	}
}
