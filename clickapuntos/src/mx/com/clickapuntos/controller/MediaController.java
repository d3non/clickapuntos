package mx.com.clickapuntos.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mx.com.clickapuntos.bean.Facebook;
import mx.com.clickapuntos.persistence.Autentificacion;
import mx.com.clickapuntos.persistence.Comentarios;
import mx.com.clickapuntos.persistence.Mediapromo;
import mx.com.clickapuntos.persistence.Mediausuario;
import mx.com.clickapuntos.persistence.Promos;
import mx.com.clickapuntos.persistence.PuntosUsuarios;
import mx.com.clickapuntos.persistence.RutasImagenes;
import mx.com.clickapuntos.persistence.Usuarios;
import mx.com.clickapuntos.service.IDetalleService;
import mx.com.clickapuntos.service.IMediaService;
import mx.com.clickapuntos.service.IUsuariosService;
import mx.com.clickapuntos.util.ArmaSlider;
import mx.com.clickapuntos.bean.PromocionesBean;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.metaparadigm.jsonrpc.JSONRPCBridge;
import com.metaparadigm.jsonrpc.MarshallException;

/* ----------------------------------------------------------------------
* MediaController 1.0
* 
* Este software contiene informacion totalmente confidencial propiedad de Clickapuntos.
* Queda totalmente prohibido su uso o divulgacion en forma parcial o total y solamente
* podra ser utilizada de acuerdo a los terminos y estatutos que determine dicha empresa
*
* Diseño: ISC Diego A. Zarate Diaz
* diegoazd@hotmail.com
* PixanMedia
*
* Construcción: Diego A. Zarate Diaz
* diegoazd@hotmail.com
* PixanMedia
*
*Esta clase es el controlador de Spring, se encarga de resolver todo lo relacionado
*al wireframe de campañas y videos. 
*
* Septiembre 2011
* ---------------------------------------------------------------------*/



@Controller
public class MediaController {
	private static Log log = LogFactory.getLog(MediaController.class);
	
	public IMediaService mediaService;
	public IDetalleService detalleService;
	public ArmaSlider slider = new ArmaSlider();
	private IUsuariosService usuariosService;
	
	@Inject
    public void setUsuariosService(IUsuariosService usuariosService) {
		this.usuariosService = usuariosService;
	}
	
	@Inject
	public void setHomeService(IMediaService mediaService) {
		this.mediaService = mediaService;
	}
	public void setDetalleService(IDetalleService detalleService) {
		this.detalleService = detalleService;
	}

	
	
	/*
	 * Metodo que resuelve la url de /videos y traera la información necesaria para cargar la pantalla
	 * 
	 * */
	



	@RequestMapping({"/videos.htm"})
	
	public String showMedias(Map<String,Object> model, HttpServletRequest req){	
		model.put("itemsSlid", mediaService.getPromos());
		model.put("itemsTop",  mediaService.getTops());
		model.put("itemsFiltro", mediaService.getFiltrado());
		model.put("itemsPremios", mediaService.getPremios());
		
		List<RutasImagenes> rutaVideos=mediaService.getAllByTipo("Videos");
		if(rutaVideos!=null){
			if(rutaVideos.size()>0){
				model.put("rutaImagenesVideos", rutaVideos.get(0).getRuta());
			}
		}
		List<RutasImagenes> rutaPromos=mediaService.getAllByTipo("Promos");
		if(rutaPromos!=null){
			if(rutaPromos.size()>0){
				model.put("rutaImagenesPromos", rutaPromos.get(0).getRuta());
			}
		}
		List<RutasImagenes> rutaClientes=mediaService.getAllByTipo("Clientes");
		if(rutaClientes!=null){
			if(rutaClientes.size()>0){
				model.put("rutaImagenesClientes", rutaClientes.get(0).getRuta());
			}
		}
		HttpSession sesion=req.getSession(true);
		long numTotal=0;
		Usuarios user=(Usuarios)sesion.getAttribute("user");
		if(user!=null){
			PuntosUsuarios pus=mediaService.getPuntosUsuarioById(user.getIdusuarios());
			if(pus!=null){
				numTotal=pus.getPuntosDisponibles();
			}
		}
		model.put("numTotal", numTotal);
		Integer banPromo=(Integer)sesion.getAttribute("banPromo");
		if(banPromo!=null){
			System.out.println("banPromo:"+ banPromo);
			if(banPromo>0){
				mediaService.aumentaPuntosPromo(banPromo);
				banPromo=null;
				sesion.setAttribute("banPromo",banPromo);
			}
			
		}
		return "videos";
	
	}
	/*
	 * Metodo que al cambiar un filtro del wireframe de las promociones refresca la información para esta pantalla.
	 * 
	 * */
	
	@SuppressWarnings("unused")
	@RequestMapping({"/getFiltro.htm"})
	public String getFiltro(Map<String,Object> model,				
			@RequestParam(value = "tipo", required = true) String tipo,
			@RequestParam(value = "idFiltros", required = true) String idFiltros,
			HttpServletResponse response){
		
		System.out.println("tipo: " + tipo + " idFiltros: " + idFiltros);
		String res="";

		try {
			res = JSONRPCBridge.getGlobalBridge().getSerializer().toJSON(mediaService.getListadoPrin(Integer.parseInt(tipo), idFiltros));				
			log.info(res);
			response.setContentType("text/html;  charset=iso-8859-1");
	        response.setHeader("Cache-Control", "no-cache");
	        PrintWriter out = response.getWriter();
	        response.getWriter().write(res);
		} catch (MarshallException me) {
			log.error("Error al transformar a JSON"+ me);			
		} catch (IOException e) {
			log.error(e);			
		}
		return null;
	}


	//Nota: Para este punto el usuario ya deberia estar logeado y por lo tanto el dato en sesion	
	/*
	 * idMedia  Es el id de la el id de la Media
	 * tipoAccion Este valor es de uso interno.
	 * 
	 * Metodo que se encarga de guardar en mediaUsuario de acuerdo a las siguientes reglas:
	 * 
	 * 1.- Si da una reproduccion 2.- Si se hizo un clic 3.- Si le dio un like 4.- Si no le gusta
	 * 5.- Favoritos 6.-Ni gusta ni disgusta ya 7.- No favoritos 
	 * */
	
	@RequestMapping({"/guardaMedia.htm"})
	public String insTop5(Map<String,Object> model,
			@RequestParam(value = "idMedia", required = true) Integer idMedia,
			@RequestParam(value = "tipoAccion", required = true) Integer tipoAccion,
			@RequestParam(value = "idUsuario", required = true) Integer idUsuario){
		log.info("Iniciando guardado de medias");
		System.out.println("Iniciando guardado de medias");
		mediaService.insMediaUs(idMedia, tipoAccion, idUsuario);
		
		return null;
	}
	
	/*
	 * Metodo por el cual cuando en la URL encuentra publicidad/{XX}/{XX} lo va a encontrar
	 * y redirigira al detalle de la campalla cuando esta es de tipo concurso
	 * 
	@RequestMapping(value="/{campaign}.htm",method=RequestMethod.GET)
	public String sendCampania(Map<String,Object> model,				
			@PathVariable String campaign){
		log.info("Redirigiendo a campania");
		
		return "/"+campaign;
	}*/
	
	/*
	 * 
	 * Metodo por el cual cuando en la URL encuentra publicidad/{XX}/{XX}/{XX} lo va a encontrar
	 * y redirigira al detalle de la campalla de dicho producto
	 * 
	 * */
	
	//@RequestMapping(value="/publicidad/{campania}/{idPromo}/{nombreCliente}/{idMedia}.htm", method=RequestMethod.GET)
	@RequestMapping(value="/{campaign}.htm", method=RequestMethod.GET)
	public String sendCampania(Map<String, Object> model, @PathVariable String campaign, HttpServletRequest req){
	//public String sendCampania(Map<String, Object> model, @PathVariable String campania, @PathVariable Integer idPromo, @PathVariable String nombreCliente, @PathVariable Integer idMedia,HttpServletRequest req){
		
		List<PromocionesBean> idpromomedia = mediaService.getIdpromomedia(campaign);
		String imgBackground = "";
		String imgFeed = "";
		String prdescripcion = "";
		String prmecanica = "";
		String prmecanicalargo = "";

		int idPromo = 0;
		int idMedia = 0;
		int mediaTipo = 0;
		if (idpromomedia.size() > 0){
			if (idpromomedia.get(0).getIdPromo()!=null)
				idPromo = idpromomedia.get(0).getIdPromo();
			if (idpromomedia.get(0).getIdMedia()!=null)
				idMedia = idpromomedia.get(0).getIdMedia();
			if (idpromomedia.get(0).getIdMediaTipo()!=null)
				mediaTipo = idpromomedia.get(0).getIdMediaTipo();
		}

		List<Comentarios> listaComentarios = mediaService.getComentariosByIdPromo(idPromo);
		List<Mediapromo> mu = mediaService.getMediaPormoByIdPromo(idPromo);
		
		if(mu!=null){
			if(mu.size()>0){
				List<Mediausuario> mus = mediaService.getMediaUsuarioByIdPromo(mu.get(0).getId().getMediaIdmedia());
				int numRep=0;
				for(Mediausuario ms:mus){
					numRep+=(ms.getMediausuarionumreproduccion());
				}
				model.put("numReproducciones", numRep);
			}
			
		}
		model.put("itemsSlid", mediaService.getPromos());
		model.put("detalle", listaComentarios);
		model.put("usuarios", mediaService.getUsuarios());
		model.put("totalComentarios",listaComentarios.size() );
		model.put("tipoMecanica", mediaService.getTipoMecanica());
		model.put("itemsPromos", mediaService.getListadoPrin(0, null));	
		model.put("promosAll", mediaService.getPromosAll());
		model.put("mediaAll", mediaService.getMediaAll());
		
		List<Promos> promos = mediaService.getPromosAll();
		
		for(int i = 0; i<promos.size(); i++){
			if ( promos.get(i).getIdpromo().equals(idPromo) && promos.get(i).getPromoimagenwallpaper() != null )
				imgBackground = promos.get(i).getPromoimagenwallpaper();
			if ( promos.get(i).getIdpromo().equals(idPromo) && promos.get(i).getPromoimagenfeed() != null )
				imgFeed = promos.get(i).getPromoimagenfeed();
			if ( promos.get(i).getIdpromo().equals(idPromo) && promos.get(i).getPromodescripcion() != null )
				prdescripcion = promos.get(i).getPromodescripcion();
			if ( promos.get(i).getIdpromo().equals(idPromo) && promos.get(i).getPromomecanica() != null )
				prmecanica = promos.get(i).getPromomecanica();
			if ( promos.get(i).getIdpromo().equals(idPromo) && promos.get(i).getPromomecanicalargo() != null )
				prmecanicalargo = promos.get(i).getPromomecanicalargo();
			
		}
		model.put("background", imgBackground);
		model.put("imagenshare", imgFeed);
		model.put("prdescripcion", prdescripcion);
		model.put("prmecanica", prmecanica);
		model.put("prmecanicalargo", prmecanicalargo);
		model.put("idPromo", idPromo);
		model.put("idMedia", idMedia);
		
		System.out.println("prueba MediaController: "+" , "+ campaign);
		System.out.println("idMedia MediaController: "+" , "+ idMedia);
		System.out.println("idPromo MediaController: "+" , "+ idPromo);
		
		long anchoP=1024;
		long altoP=600;
		if(req.getParameter("tamW")!=null){
			if(!req.getParameter("tamW").equals("")){
				anchoP=Long.parseLong(req.getParameter("tamW"))-100;
			}
		}
		if(req.getParameter("tamH")!=null){
			if(!req.getParameter("tamH").equals("")){
				altoP=Long.parseLong(req.getParameter("tamH"))-200;
			}
		}
		HttpSession sesion=req.getSession(true);
		List<Autentificacion> las=usuariosService.getAutentificacionAll();
		String mensaje=(String)sesion.getAttribute("mensaje");
		if(mensaje!=null){
			model.put("mensaje", mensaje);
			mensaje=null;
			sesion.setAttribute("mensaje", mensaje);
		}
		if(las!=null){
			if(las.size()>0){
				for(Autentificacion aut:las){
					if(aut.getProvider().equals("facebook"))
						req.setAttribute("urlFacebook", Facebook.getLoginRedirectURL(aut.getApikey(),aut.getApisecret(),aut.getCallbackurl()));
					if(aut.getProvider().equals("twitter"))
						req.setAttribute("urlTwitter", "logginTwitter.htm?apiKey="+aut.getApikey()+"&apiSecret="+aut.getApisecret()+"&callbackURL="+aut.getCallbackurl());
				}
			}
		}
		model.put("anchoPantalla", anchoP);
		model.put("altoPantalla", altoP);
		
		if(mediaTipo==2){
			model.put("imagenPromo", "exito");
		}
		
		long numTotal=0;
		Usuarios user=(Usuarios)sesion.getAttribute("user");
		if(user!=null){
			PuntosUsuarios pus=mediaService.getPuntosUsuarioById(user.getIdusuarios());
			if(pus!=null){
				numTotal=pus.getPuntosDisponibles();
			}
		}
		
		model.put("numTotal", numTotal);
		List<RutasImagenes> rutaVideos=mediaService.getAllByTipo("Videos");
		if(rutaVideos!=null){
			if(rutaVideos.size()>0)
				model.put("rutaImagenesVideos", rutaVideos.get(0).getRuta());
		}
		return "concurso/detalle";
		
	}
	
	/*
	 * 
	 * 
	 * */
	
	@RequestMapping({"/promociones.htm"})
	public String getYoutoube(Map<String, Object> model,
			@RequestParam(value = "vidYou", required = false) String vidYou,
			@RequestParam(value = "idMedia", required = false) Integer idMedia){
		log.info("Redirigiendo a campania");
		System.out.println(vidYou+ "   "+idMedia);
		model.put("itemVideo", vidYou);
		model.put("idMedia", idMedia);
		return "reprodVid";
	}
	
	@RequestMapping("/fullScreen.htm")
	String showfullScreen(Map<String, Object> model,@RequestParam(value="idUser") String idUser,
							@RequestParam(value="idPromo") String idPromo,
							@RequestParam(value="urlVideo") String urlVideo,
							@RequestParam(value="anchoPantalla") String anchoPantalla,
							@RequestParam(value="altoPantalla") String altoPantalla){
		model.put("idUser", idUser);
		model.put("idPromo", idPromo);
		model.put("urlVideo", urlVideo);
		model.put("anchoPantalla",Long.parseLong(anchoPantalla)+27);
		model.put("altoPantalla",Long.parseLong(altoPantalla)-30);
		
		return "fullScreenVideo";
	}
	
	@RequestMapping("/concurso/selfclose.htm")
	String selfclose(Map<String, Object> model){
		return "selfclose";
	}


}
