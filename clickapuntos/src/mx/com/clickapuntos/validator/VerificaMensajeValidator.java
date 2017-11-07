package mx.com.clickapuntos.validator;

import javax.inject.Inject;

import mx.com.clickapuntos.bean.VerificaMensaje;
import mx.com.clickapuntos.persistence.MensajeUsuarios;
import mx.com.clickapuntos.service.IMediaService;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class VerificaMensajeValidator implements Validator {
public IMediaService mediaService;
	
	@Inject
	public void setHomeService(IMediaService mediaService) {
		this.mediaService = mediaService;
	}
	
	@Override
	public boolean supports(Class<?> form) {
		return VerificaMensaje.class.isAssignableFrom(form);
	}

	@Override
	public void validate(Object vm, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mensaje",
				"mensaje.required");
		VerificaMensaje vme = (VerificaMensaje)vm;
		if(vme != null){
			if(vme.getIdMensaje() != null){
				if(!vme.getIdMensaje().equals("")){
					MensajeUsuarios otro = mediaService.getMensajeById(Long.parseLong(vme.getIdMensaje()));
					if(!otro.getMensaje().equals(vme.getMensaje())){
						errors.rejectValue("mensaje", "mensaje.invalid");
					}
				}
			}
		}
	}

}
