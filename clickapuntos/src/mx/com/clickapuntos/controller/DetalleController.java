package mx.com.clickapuntos.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mx.com.clickapuntos.persistence.Mediapromo;
import mx.com.clickapuntos.persistence.Promos;
import mx.com.clickapuntos.persistence.Usuarios;
import mx.com.clickapuntos.service.IMediaService;
import mx.com.clickapuntos.service.IUsuariosService;
import mx.com.clickapuntos.util.ArmaSlider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.metaparadigm.jsonrpc.JSONRPCBridge;
import com.metaparadigm.jsonrpc.MarshallException;


@Controller
public class DetalleController {
	
	public IMediaService mediaService;
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
	
	@RequestMapping("/guardaPuntosUsr.htm")
	public synchronized String guardaPuntosUsr(Map<String,Object> model,				
			@RequestParam(value = "idUser") Long idUser,
			@RequestParam(value = "idPromo", required = true) Integer idPromo,HttpServletRequest req,HttpServletResponse response){
		Promos promos=mediaService.getPromosById(idPromo);
		if(promos!=null){
			if(idUser!=0){
				if(mediaService.getPuntosUsrByUserPromoId(idUser, Long.parseLong(String.valueOf(idPromo)))==null){
					System.out.println("NO Existe puntos hacia ese usuario de esa promo");
					Usuarios user=usuariosService.getUsuariosByIdUser(idUser);
					if(user!=null){
						Long numPuntos=mediaService.insPuntosUsr(idUser, idPromo, promos.getClientes().getIdcliente(), promos.getMaxPuntos());
						mediaService.descuentaPuntosPromo(idPromo);
						System.out.println("Actualizacion correcta");
						String res=String.valueOf(numPuntos);
						try {
							response.setContentType("text/html;  charset=iso-8859-1");
					        response.setHeader("Cache-Control", "no-cache");
					        PrintWriter out = response.getWriter();
					        response.getWriter().write(res);
						} catch (IOException e) {
							System.out.println("Otro error " + e);		
						}
					}
				}
				else{
					System.out.println("Existe ya la asignacion de puntos hacia ese usuario");
				}
				List<Mediapromo> mp=mediaService.getMediaPormoByIdPromo(idPromo);
				if(mp!=null){
					if(mp.size()>0){
						mediaService.SaveOrUpdateMediaUsuario(mp.get(0).getId().getMediaIdmedia(), Integer.parseInt(String.valueOf(idUser)));
					}		
				}
			}
			else{
				HttpSession sesion=req.getSession(true);
				Integer banPromo=idPromo;
				sesion.setAttribute("banPromo", banPromo);
				mediaService.descuentaPuntosPromo(idPromo);
				System.out.println("ID PROMO:"+banPromo);
			}
			
		}
		
		return null;
	}
	@RequestMapping("/obtieneTam.htm")
	public String obtieneTam(@RequestParam(value="tamW") String tamW,@RequestParam(value="tamH") String tamH){
		System.out.println("ancho:" + tamW);
		return null;
	}
}
