package mx.com.clickapuntos.controller;

import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import mx.com.clickapuntos.bean.Facebook;
import mx.com.clickapuntos.persistence.Autentificacion;
import mx.com.clickapuntos.persistence.MensajeUsuarios;
import mx.com.clickapuntos.persistence.Usuarios;
import mx.com.clickapuntos.service.IUsuariosService;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsuariosController {
	private IUsuariosService usuariosService;
	
	@Inject	
	public void setUsuarioService(IUsuariosService usuariosService) {
		this.usuariosService = usuariosService;
	}
	
	@RequestMapping({"/guardaUser.htm"})
	public String showHomePage(Map<String,Object> model,				
			@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "tipoUsuario", required = true) Integer tipoUsuario){		
		System.out.println("ABCDEFG: "+ email);
		usuariosService.validaUsuario(email);
		
//		usuarioService.insertaUsuario(new Usuarios());
		return "home";
	}
	@RequestMapping("/cerrarSesion.htm")
	public String cerrarSesion(@RequestParam(value="url")String urlA,HttpServletRequest req){
		HttpSession sesion=req.getSession(true);
		Usuarios users=(Usuarios)sesion.getAttribute("users");
		users=null;
		sesion.setAttribute("user", users);
		String urlAnt=(String)sesion.getAttribute("urlAnt");
		if(urlAnt!=null)
	        if(urlAnt.substring(0,urlAnt.indexOf(".htm")).equals(urlA.substring(0,urlA.indexOf(".htm")))){
	        	urlA=urlAnt;
	        }
		urlAnt=null;
        sesion.setAttribute("urlAnt", null);
		return "redirect:"+urlA;
	}
	@RequestMapping("/eliminarFoto.htm")
	public String eliminarFoto(HttpServletRequest req){
		HttpSession sesion=req.getSession(true);
		Usuarios user=(Usuarios)sesion.getAttribute("user");
		user.setUsrfoto(null);
		usuariosService.actualizaUsuario(user);
		sesion.setAttribute("user", user);
		return "redirect:perfilUser.htm";
	}
	@RequestMapping("/confirmacionUser.htm")
	public String actualizaEstado(HttpServletRequest req){
		String idUser=req.getParameter("idUser");
		String llaveclickapuntos=req.getParameter("llaveclickapuntos");
		if(idUser!=null){
			Usuarios user=usuariosService.getUsuariosByIdUser(Long.parseLong(idUser));
			if(user!=null){
				if(llaveclickapuntos!=null){
					List<MensajeUsuarios> mus=usuariosService.getMensajeByIdUser(user.getIdusuarios());
					if(mus!=null){
						for(MensajeUsuarios mu:mus){
							if(mu.getMensaje().equals(llaveclickapuntos) && mu.getId().getIdTipoMensaje().equals(new Long("1"))){
								user.setUsrstatus("2");
								usuariosService.actualizaUsuario(user);
								HttpSession sesion=req.getSession(true);
								String mensaje="Felicidades "+user.getUsrusername()+" tu cuenta ha sido activada. Bienvenido!!";
								sesion.setAttribute("user",user);
								sesion.setAttribute("mensaje", mensaje);
							}
						}
					}
				}
			}
		}
		return "redirect:";
	}
	@RequestMapping("/loginBy.htm")
	public String loginBy(HttpServletRequest req){
		List<Autentificacion> las=usuariosService.getAutentificacionAll();
		if(las!=null){
			if(las.size()>0){
				for(Autentificacion aut:las){
					if(aut.getProvider().equals("facebook"))
						req.setAttribute("urlFacebook", Facebook.getLoginRedirectURL(aut.getApikey(),aut.getApisecret(),aut.getCallbackurl()));
					if(aut.getProvider().equals("twitter")){
						req.setAttribute("urlTwitter", "logginTwitter.htm?apiKey="+aut.getApikey()+"&apiSecret="+aut.getApisecret()+"&callbackURL="+aut.getCallbackurl());
					}
				}
			}
		}
		req.setAttribute("urlClickapuntos", "logginForm.htm");
		return "logins";
	}
}
