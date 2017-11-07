package mx.com.clickapuntos.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import mx.com.clickapuntos.bean.RegistroUser;
import mx.com.clickapuntos.persistence.Usuarios;
import mx.com.clickapuntos.service.IUsuariosService;
import mx.com.clickapuntos.validator.RegistroUserValidator2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/userRegistroEmail.htm")
@SessionAttributes("registroUser")
public class UserRegistroEmailController {
	private IUsuariosService usuariosService;
	private RegistroUserValidator2 registroUserValidator2;

	@Autowired
	public void UserLogginController(IUsuariosService usuariosService, RegistroUserValidator2 registroUserValidator2) {
		this.usuariosService = usuariosService;
		this.registroUserValidator2 = registroUserValidator2;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showRegistroUser(ModelMap model,HttpServletRequest req){
		HttpSession sesion=req.getSession(true);
		RegistroUser ru=new RegistroUser();
		Usuarios user=(Usuarios) sesion.getAttribute("user");
		if(user!=null){
			if(user.getUsremail()!=null){
				if(!user.getUsremail().equals("")){
					ru.setEmail(user.getUsremail());
				}
			}
		}
		model.put("registroUser", ru);
		return "registroEmail";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(@ModelAttribute("registroUser") RegistroUser ru,
			BindingResult result,HttpServletRequest req) {
		registroUserValidator2.validate(ru, result);
		System.out.println("Entro guardado registro");
		if (result.hasErrors()) {
			return "registroEmail";
		}
		else{
			
			HttpSession sesion=req.getSession(true);
			Usuarios user=(Usuarios) sesion.getAttribute("user");
			if(user!=null){
				user.setUsremail(ru.getEmail());
				usuariosService.actualizaUsuario(user);
				usuariosService.createMensaje(new Long("0"),user);
				String mensaje="¡Gracias por registrarte!, activa tu cuenta desde el link que te hemos enviado a tu correo y comienza a acumular puntos!";
				req.setAttribute("mensajeExito", mensaje);
				System.out.println(mensaje);
				sesion.setAttribute("user", user);
			}
		}
		return "registroEmail";
	}
}
