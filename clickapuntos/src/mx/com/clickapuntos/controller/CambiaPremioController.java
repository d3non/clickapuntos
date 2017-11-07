package mx.com.clickapuntos.controller;


import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import mx.com.clickapuntos.bean.RegistroUser;
import mx.com.clickapuntos.bean.XML_ServiceTAE;
import mx.com.clickapuntos.persistence.Premios;
import mx.com.clickapuntos.persistence.RutasImagenes;
import mx.com.clickapuntos.persistence.PuntosUsuarioPremio;
import mx.com.clickapuntos.persistence.TarjetasPremios;
import mx.com.clickapuntos.bean.PremiosUser;
import mx.com.clickapuntos.persistence.Usuarios;
import mx.com.clickapuntos.persistence.Usuariosdatos;
import mx.com.clickapuntos.service.IMediaService;
import mx.com.clickapuntos.service.IUsuariosService;
import mx.com.clickapuntos.service.impl.MediaService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/canjeaPremio.htm")
@Controller
public class CambiaPremioController {
	private IMediaService mediaService;
	private IUsuariosService usuariosService;
	
	@Inject
    public void setUsuariosService(IUsuariosService usuariosService) {
		this.usuariosService = usuariosService;
	}
	
	@Inject
	public void setHomeService(IMediaService mediaService) {
		this.mediaService = mediaService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showCambiaPremio(Map<String,Object> model,@RequestParam(value="idPremio")String idPremio,
									@RequestParam(value="idMensaje")String idMensaje,@RequestParam(value="tiempo") String tiempo,HttpServletRequest req){
		HttpSession session = req.getSession(true);
		Usuarios user = (Usuarios) session.getAttribute("user");
		System.out.println("Entro canjea premio ");

		if(user != null){
			Usuariosdatos usuariosDatos = usuariosService.getUsuariosDatosByIdUser(Integer.parseInt(String.valueOf(user.getIdusuarios())));
			if(usuariosDatos != null){
				model.put("nombreUsuario", usuariosDatos.getUsrnombres());
			}
			Premios premio = mediaService.getPremiosById(Integer.parseInt(idPremio));
			
			List<RutasImagenes> rutaPremios=mediaService.getAllByTipo("Premios");
			if(rutaPremios!=null){
				if(rutaPremios.size()>0){
					model.put("rutaImagenesPremios", rutaPremios.get(0).getRuta());
				}
			}

			if(premio != null){
				model.put("nombrePremio",premio.getPremionombre());
				model.put("urlImagen", premio.getPremiourlimg());
			}
		}
		RegistroUser ru = new RegistroUser();
		model.put("ru", ru);
		return "canjeaPremio";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(@ModelAttribute("ru") RegistroUser ru,@RequestParam(value="idPremio")String idPremio,
			@RequestParam(value="idMensaje")String idMensaje,@RequestParam(value="tiempo") Timestamp tiempo, HttpServletRequest req){
		if(ru != null) {
			if(ru.getCondiciones()){
				String sku = "";
				boolean result = false;
				Long noTransaccion = null;
				HttpSession session = req.getSession(true);
				Usuarios user = (Usuarios) session.getAttribute("user");					
				Premios p = mediaService.getPremiosById(Integer.parseInt(idPremio));
				List<PuntosUsuarioPremio> pup = mediaService.getPuntosUsuarioPremioById(user.getIdusuarios());
				if ( pup.get(0).getId().getIdTransaccion() != null )
					noTransaccion = pup.get(0).getId().getIdTransaccion();
				
				//Si el premio es recarga electrónica
				if ( p.getIdtipopremio() == 1 ){
					List<PremiosUser> pu = mediaService.getPremiosByStatus(Integer.parseInt(idPremio), user.getIdcompaniacelular());
					PremiosUser res = pu.get(0);
					if ( res.getSku() != null )
						sku = res.getSku();
					
					System.out.println("Tiempo: " +  tiempo);
					System.out.println("SKU: " +  sku);
					System.out.println("Transaccion: " +  noTransaccion);
					
					XML_ServiceTAE TAEServiceCall = new XML_ServiceTAE();
					result = TAEServiceCall.taeWebService(noTransaccion.intValue(), sku, user.getUsrcelular(), user.getIdcompaniacelular());
				}
				//Si el premio es código iTunes
				else if ( p.getIdtipopremio() == 2 ){
					List<TarjetasPremios> ltp = mediaService.getTarjetasPremios(1, p.getPremiocantidad());
					if ( ltp.size() > 0 ){
						TarjetasPremios tp = ltp.get(0);
						if ( tp.getCodigo() != null ){
							System.out.println("Codigo iTunes-------------: " +  tp.getCodigo());
							System.out.println("Codigo tarjeta-------------: " +  tp.getId());
							System.out.println("Transaccion-------------: " +  noTransaccion);
							result = mediaService.enviaMensaje(user.getUsrcelular(), "Hola tu código para descargar música es : " 
									+ tp.getCodigo()
									+ ", ¡ingrésalo en tu cuenta de iTunes y disfruta!.Equipo Clickapuntos");
							if ( result )
								mediaService.actualizaTarjetaPremio(tp, noTransaccion);
						}
					}
				}
				
				req.setAttribute("mensajeExito", "Lo sentimos, ha ocurrido un error en el sistema por favor inténtalo más tarde.");
				if( p!= null && result ){
					mediaService.actualizaPremioUsuario(pup.get(0).getId().getIdTransaccion(), user.getIdusuarios(), Long.parseLong(idPremio),tiempo, "2", p.getPremiopuntos());
					req.setAttribute("mensajeExito", "¡Felicidades!, El canje de puntos ha sido exitoso");
				}
			}
		}
		return "canjeaPremio";
	}
}
