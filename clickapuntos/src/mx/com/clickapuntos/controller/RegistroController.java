package mx.com.clickapuntos.controller;

import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import mx.com.clickapuntos.bean.RegistroUser;
import mx.com.clickapuntos.persistence.Promos;
import mx.com.clickapuntos.persistence.Usuarios;
import mx.com.clickapuntos.persistence.Usuariotipo;
import mx.com.clickapuntos.service.IMediaService;
import mx.com.clickapuntos.service.IUsuariosService;
import mx.com.clickapuntos.validator.RegistroUserValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/registroUser.htm")
@SessionAttributes("registroUser")
public class RegistroController {
	private IUsuariosService usuariosService;
	private RegistroUserValidator registroUserValidator;
public IMediaService mediaService;
	
	@Inject
	public void setHomeService(IMediaService mediaService) {
		this.mediaService = mediaService;
	}
	
	@Autowired
	public void UserLogginController(IUsuariosService usuariosService, RegistroUserValidator registroUserValidator) {
		this.usuariosService = usuariosService;
		this.registroUserValidator = registroUserValidator;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showRegistroUser(ModelMap model,@RequestParam(value="urlShow")String urlShow,HttpServletRequest req) {
		if ( urlShow.equals("registro")){
			model.put("registroUser", new RegistroUser());
			return "registroUser";
		}else
			return "terminosCondiciones";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(HttpServletRequest req,
	        @RequestParam("recaptcha_challenge_field") String challenge,
	        @RequestParam("recaptcha_response_field") String response,
	        @ModelAttribute("registroUser") RegistroUser ru,
			BindingResult result) {
		
	    String remoteAddr = req.getRemoteAddr();
	    ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
	    reCaptcha.setPrivateKey("6LehcdgSAAAAAEUaWUhZy6wsxuJ6ANjwJACAJHs9");

	    ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(remoteAddr, challenge, response);
		ru.setCaptcha(reCaptchaResponse);
		registroUserValidator.validate(ru, result);
	    
		System.out.println("Entro guardado registro");
		if (result.hasErrors()) {
			return "registroUser";
		}
		else{
			
			Usuarios user=new Usuarios();
			user.setPassword(ru.getPassword());
			user.setUsrusername(ru.getNickname());
			user.setUsremail(ru.getEmail());
			user.setUsrstatus("1");
			user.setProvider("loginClicka");
			Usuariotipo ut=usuariosService.getUsuarioTipoById(1);
            if(ut!=null){
            	user.setUsuariotipo(ut);
            }
			usuariosService.insertaUsuario(user);
			user=usuariosService.getUsuariosByEmail(user.getUsremail());
			usuariosService.createMensaje(new Long("0"),user);
			HttpSession sesion=req.getSession(true);
			Integer banPromo=(Integer)sesion.getAttribute("banPromo");
			if(banPromo!=null){
				if(banPromo>0){
					if(mediaService.getPuntosUsrByUserPromoId(user.getIdusuarios(), Long.parseLong(String.valueOf(banPromo)))==null){
						Promos promos=mediaService.getPromosById(banPromo);
						mediaService.insPuntosUsr(user.getIdusuarios(), banPromo, promos.getClientes().getIdcliente(), promos.getMaxPuntos());
						
					}
					banPromo=null;
					sesion.setAttribute("banPromo",banPromo);
				}
			}
			String mensaje="¡Te has registrado correctamente!, Activa tu cuenta desde el link que te hemos enviado a tu correo";
			req.setAttribute("mensajeExito", mensaje);
			System.out.println(mensaje);
		}
		
		return "registroUser";
	}
	
}
