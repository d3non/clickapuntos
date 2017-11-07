package mx.com.clickapuntos.controller;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mx.com.clickapuntos.bean.Facebook;
import mx.com.clickapuntos.bean.LogginUser;
import mx.com.clickapuntos.persistence.Autentificacion;
import mx.com.clickapuntos.persistence.Promos;
import mx.com.clickapuntos.persistence.PuntosUsuarios;
import mx.com.clickapuntos.persistence.Usuarios;
import mx.com.clickapuntos.service.IMediaService;
import mx.com.clickapuntos.service.IUsuariosService;
import mx.com.clickapuntos.service.impl.CustomUserDetailsService;
import mx.com.clickapuntos.validator.LogginValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@RequestMapping("/logginForm.htm")
@SessionAttributes("logginUser")
public class LogginUserController {
	private IUsuariosService usuariosService;
	private LogginValidator logginValidator;
	public IMediaService mediaService;
	private CustomUserDetailsService customUserDetailsService;
	
	@Inject
	public void setCustomUserDetailsService(
			CustomUserDetailsService customUserDetailsService) {
		this.customUserDetailsService = customUserDetailsService;
	}

	@Inject
	public void setHomeService(IMediaService mediaService) {
		this.mediaService = mediaService;
	}

	@Autowired
	public void UserLogginController(IUsuariosService usuariosService, LogginValidator logginValidator) {
		this.usuariosService = usuariosService;
		this.logginValidator = logginValidator;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showUserLogginForm(ModelMap model,@RequestParam(value="urlShow")String urlShow,HttpServletRequest req) {
		LogginUser lu = new LogginUser();
		lu.setUrlShow(urlShow);
		if(urlShow.equals("logins")){
			List<Autentificacion> las=usuariosService.getAutentificacionAll();
			if(las!=null){
				if(las.size()>0){
					for(Autentificacion aut:las){
						if(aut.getProvider().equals("facebook"))
							lu.setUrlFacebook(Facebook.getLoginRedirectURL(aut.getApikey(),aut.getApisecret(),aut.getCallbackurl()));
						if(aut.getProvider().equals("twitter")){
							lu.setUrlTwitter("logginTwitter.htm?apiKey="+aut.getApikey()+"&apiSecret="+aut.getApisecret()+"&callbackURL="+aut.getCallbackurl());
						}
					}
				}
			}
		}
		else{
			HttpSession sesion=req.getSession(true);
			Usuarios user=(Usuarios)sesion.getAttribute("user");
			long numTotal=0;
			if(user!=null){
				PuntosUsuarios pus=mediaService.getPuntosUsuarioById(user.getIdusuarios());
				if(pus!=null){
					numTotal=pus.getPuntosDisponibles();
				}
			}
			model.put("numTotal", numTotal);
		}
			
		model.addAttribute("logginUser", lu);
		return urlShow;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(@ModelAttribute("logginUser") LogginUser lu,
			BindingResult result,HttpServletRequest req,HttpServletResponse response) throws IOException {
		System.out.println(lu.getUserEmail());
		System.out.println(lu.getUserPassword());
		logginValidator.validate(lu, result);
		if (result.hasErrors()) {
			return lu.getUrlShow();
		} else {
			Usuarios users=usuariosService.getUsuariosByEmail(lu.getUserEmail());
			users.setUsrfechaultimasesion(new java.sql.Date(new java.util.Date().getTime()));
			long numSesion=1;
			if(users.getUsrnumerosesion()!=null)
				numSesion+=(users.getUsrnumerosesion());
			users.setUsrnumerosesion(numSesion);
			usuariosService.actualizaUsuario(users);
			HttpSession sesion=req.getSession(true);
			if(numSesion >= 2 && usuariosService.datosIncompletos(users) == true){
				String mensaje="Hemos notado que faltan algunos datos en tu perfil, " +
						"por favor termina de ingresarlos en la sección de Datos Generales, Gracias!";
				sesion.setAttribute("mensaje", mensaje);
				//System.out.println("Entro: " + numSesion + mensaje);
			}
			Integer banPromo=(Integer)sesion.getAttribute("banPromo");
			if(banPromo!=null){
				if(banPromo>0){
					Promos promos=mediaService.getPromosById(banPromo);
					mediaService.insPuntosUsr(users.getIdusuarios(), banPromo, promos.getClientes().getIdcliente(), promos.getMaxPuntos());
					banPromo=null;
					sesion.setAttribute("banPromo",banPromo);
				}
			}
			sesion.setAttribute("user", users);
			String path = req.getContextPath();
			String basePath = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+path+"/";
			String url=basePath+"videos.htm";
			if(lu.getUrlShow().equals("logins")){
				req.setAttribute("exito", "exito");
				req.setAttribute("urlAnt",url);
				return "logins";
			}
			UserDetails user=customUserDetailsService.loadUserByUsername(users.getUsremail());
			if(user!=null){
				
			}
			
			return "redirect:/videos.htm";
		}
	}
	
}
