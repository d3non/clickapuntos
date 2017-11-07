package mx.com.clickapuntos.controller;


import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import mx.com.clickapuntos.bean.VerificaMensaje;
import mx.com.clickapuntos.persistence.MensajeUsuarios;
import mx.com.clickapuntos.persistence.PuntosUsuarioPremio;
import mx.com.clickapuntos.persistence.RutasImagenes;
import mx.com.clickapuntos.persistence.Usuarios;
import mx.com.clickapuntos.service.IMediaService;
import mx.com.clickapuntos.validator.VerificaMensajeValidator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/premios/{idPremio}/{idTipoPremios}.htm")
@SessionAttributes("verificaMensaje")
public class VerificaMensajePremioController {
	private VerificaMensajeValidator verificaMensajeValidator;
	public IMediaService mediaService;
	
	@Inject
	public void setHomeService(IMediaService mediaService) {
		this.mediaService = mediaService;
	}
	
	@Inject
	public void setVerificaMensajeValidator(
			VerificaMensajeValidator verificaMensajeValidator) {
		this.verificaMensajeValidator = verificaMensajeValidator;
	}
	
	@RequestMapping(value = "/premios/{idPremio}/{idTipoPremios}",method = RequestMethod.GET)
	public String showVerficaMensaje(ModelMap model,@PathVariable("idPremio") String idPremio, @PathVariable("idTipoPremios") String idTipoPremios,
			HttpServletRequest req) {
		HttpSession sesion = req.getSession(true);
		Usuarios user = (Usuarios)sesion.getAttribute("user");
		long idMensaje = 0;
		VerificaMensaje vm = new VerificaMensaje();
		
		System.out.println("idPremio: "  +  idPremio);
		System.out.println("idTipo: "  +  idTipoPremios);
		
		if(user != null){
			
			List<PuntosUsuarioPremio> pup = mediaService.getPuntosUsuarioPremioById(user.getIdusuarios());
			//List<PuntosUsuarioPremio> pup = mediaService.getPuntosUsuarioPremio(user.getIdusuarios(), Long.parseLong(idPremio));

			if(pup.size() > 0 ){
				idMensaje = pup.get(0).getMensajeId();
				Timestamp tiempo = pup.get(0).getId().getFechaCambioPuntos();
				model.put("tiempo", String.valueOf(tiempo));
				vm.setTiempo(tiempo);
				
				if ( !idPremio.equals(pup.get(0).getId().getIdPremio().toString() )){
					/*idMensaje = mediaService.createMensaje(idMensaje, user);
					Timestamp tiempo = mediaService.insPremioUsuario(user.getIdusuarios(), Long.parseLong(idPremio),idMensaje);
					//System.out.println("Tiempo: " + tiempo);
					model.put("tiempo", String.valueOf(tiempo));
					vm.setTiempo(tiempo);*/
					req.setAttribute("mensajeExito", "Tienes un premio pendiente por canjear");
				}
			}
			else{
				System.out.println("GENERAR MENSAJE");
				idMensaje = mediaService.createMensaje(idMensaje, user);
				Timestamp tiempo = mediaService.insPremioUsuario(user.getIdusuarios(), Long.parseLong(idPremio),idMensaje);
				model.put("tiempo", String.valueOf(tiempo));
				vm.setTiempo(tiempo);
				//req.setAttribute("mensajeExito", "Te hemos enviado un SMS a tu celular con tu código de canje");
			}
			
			model.put("idMensaje", idMensaje);
			
		}
		
		MensajeUsuarios mu = mediaService.getMensajeById(idMensaje);
		
		vm.setIdMensaje(String.valueOf(idMensaje));
		vm.setContador(mu.getContador());
		
		model.addAttribute("verificaMensaje", vm);
		model.put("idPremio", idPremio);

		List<RutasImagenes> rutaPremios = mediaService.getAllByTipo("Premios");
		if(rutaPremios!=null){
			if(rutaPremios.size()>0){
				model.put("rutaImagenesPremios", rutaPremios.get(0).getRuta());
				System.out.println("rutaImagenesPremios " + rutaPremios.get(0).getRuta());
			}
		}
		
		return "codigoVerificacion";
	}	
	
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(@ModelAttribute("verificaMensaje") VerificaMensaje vm,
			BindingResult result,@PathVariable String idPremio,ModelMap model) {
		verificaMensajeValidator.validate(vm,result);
		model.put("idPremio", idPremio);
		System.out.println("idPremio " + idPremio);
		List<RutasImagenes> rutaPremios = mediaService.getAllByTipo("Premios");
		if(rutaPremios != null){
			if(rutaPremios.size() > 0){
				model.put("rutaImagenesPremios", rutaPremios.get(0).getRuta());
				System.out.println("rutaImagenesPremios " + rutaPremios.get(0).getRuta());
				//System.out.println("rutaImagenesPremios " + rutaPremios.get(0).);
			}
		}
		if (result.hasErrors()) {
			return "codigoVerificacion";
		} else {
			//System.out.println("Sin error " + vm.getIdMensaje());
			//System.out.println("Sin error " + vm.getTiempo());
			String urlAccion="canjeaPremio.htm?idPremio="+idPremio+"&idMensaje="+vm.getIdMensaje()+"&tiempo="+vm.getTiempo()+"&keepThis=true&TB_iframe=true&height=500&width=290";
			model.put("urlAccion", urlAccion);
			return "canjea";
		}
	}
}
