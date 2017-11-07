package mx.com.clickapuntos.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mx.com.clickapuntos.bean.PremiosUser;
import mx.com.clickapuntos.persistence.PuntosUsuarioPremio;
import mx.com.clickapuntos.persistence.PuntosUsuarios;
import mx.com.clickapuntos.persistence.RutasImagenes;
import mx.com.clickapuntos.persistence.Usuarios;
import mx.com.clickapuntos.service.IMediaService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.metaparadigm.jsonrpc.JSONRPCBridge;
import com.metaparadigm.jsonrpc.MarshallException;

@Controller
public class CanjeController {
	private static Log log = LogFactory.getLog(CanjeController.class);
	public IMediaService mediaService;
	
	@Inject
	public void setHomeService(IMediaService mediaService) {
		this.mediaService = mediaService;
	}
	
	@RequestMapping("/centroCanje.htm")
	public String centroCanje(Map<String,Object> model, @RequestParam(value = "idTipo", required = true) String idTipo,
								HttpServletRequest req){
		
		HttpSession sesion = req.getSession(true);
		Usuarios user = (Usuarios)sesion.getAttribute("user");
		long numTotal = 0;
		int idCompaniaCelular = 0;
		long idUsuario = 0;
		
		if(user != null){
			PuntosUsuarios pus = mediaService.getPuntosUsuarioById(user.getIdusuarios());
			idUsuario = user.getIdusuarios();			
			if(pus != null){
				numTotal = pus.getPuntosDisponibles();
			}
			if ( user.getIdcompaniacelular() != null )
				idCompaniaCelular = user.getIdcompaniacelular();
		}
		
		List<PremiosUser> listaP = mediaService.getPremiosByStatus(numTotal, Integer.valueOf(idTipo), idCompaniaCelular);
		List<PuntosUsuarioPremio> pup = mediaService.getPuntosUsuarioPremioById(idUsuario);
		
		if(listaP != null){
			if(listaP.size() > 0){
				model.put("premios", listaP);
			}
		}
		
		if(pup != null){
			if(pup.size() > 0)
				model.put("premiopendiente", pup.get(0).getId().getIdPremio());
		}
		
		model.put("numTotal", numTotal);
		
		List<RutasImagenes> rutaClientes=mediaService.getAllByTipo("Clientes");
		if(rutaClientes != null){
			if(rutaClientes.size() > 0){
				model.put("rutaImagenesClientes", rutaClientes.get(0).getRuta());
			}
		}
		List<RutasImagenes> rutaPremios=mediaService.getAllByTipo("Premios");
		if(rutaPremios!=null){
			if(rutaPremios.size()>0){
				model.put("rutaImagenesPremios", rutaPremios.get(0).getRuta());
			}
		}
		Integer banPromo=(Integer)sesion.getAttribute("banPromo");
		if(banPromo!=null){
			if(banPromo>0){
				mediaService.aumentaPuntosPromo(banPromo);
				banPromo=null;
				sesion.setAttribute("banPromo",banPromo);
			}
		}
		return "canje";
	}
	

	@RequestMapping(value="/{idTipoPremios}/centroCanje.htm",method = RequestMethod.GET)
	public String centroCanje(@PathVariable String idTipoPremios,Map<String,Object> model, HttpServletRequest req){
		HttpSession session = req.getSession(true);
		Usuarios user = (Usuarios)session.getAttribute("user");
		long numTotal = 0;
		int idCelular = 0;
		if(user != null){
			PuntosUsuarios pus = mediaService.getPuntosUsuarioById(user.getIdusuarios());
			idCelular = user.getIdcompaniacelular();
			if(pus != null){
				numTotal = pus.getPuntosDisponibles();
			}
			
		}
		
		List<PremiosUser> listaP = mediaService.getPremiosByStatus(numTotal, Integer.valueOf(idTipoPremios), idCelular);
		
		if(listaP != null){
			if(listaP.size() > 0){
				model.put("premios", listaP);
			}
		}
		
		model.put("numTotal", numTotal);
		if(idTipoPremios != null){
			if(idTipoPremios.equals("1")){
				model.put("titulo", "Recargas electrónicas");
			}
			else if (idTipoPremios.equals("2")){
				model.put("titulo", "Dinero");
			}
		}
		model.put("idTipoPremios", idTipoPremios);
		return "monetarios";
	}
	
	@RequestMapping(value="/{idTipoPremios}/centroCanje.htm",method = RequestMethod.POST)
	public String onSubmit(@PathVariable String idTipoPremios,Map<String,Object> model,@RequestParam(value="opcion")String idPremio){
		System.out.println("Antes de validar???");
		String urlAccion="premios/"+idPremio+".htm?keepThis=true&TB_iframe=true&height=230&width=400";
		model.put("urlAccion", urlAccion);
		return "canjea";
	}
	
	@RequestMapping("/reenviarMensaje.htm")
	public String reenviaMensaje(@RequestParam(value="idMensaje") Long idMensaje,Map<String,Object> model,@RequestParam(value="idPremio")String idPremio,
								HttpServletRequest req){
		HttpSession sesion=req.getSession(true);
		System.out.println("Reenvio mensaje: " + idMensaje);
		Usuarios user=(Usuarios) sesion.getAttribute("user");
		mediaService.createMensaje(idMensaje, user);
		String urlAccion="premios/"+idPremio+".htm?keepThis=true&TB_iframe=true&height=230&width=400";
		model.put("urlAccion", urlAccion);
		return "canjea";
	}
}
