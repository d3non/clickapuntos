package mx.com.clickapuntos.validator;

import javax.inject.Inject;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import mx.com.clickapuntos.bean.LogginUser;
import mx.com.clickapuntos.service.IUsuariosService;

public class LogginValidator implements Validator {
	
private IUsuariosService usuariosService;
	
	@Inject	
	public void setUsuarioService(IUsuariosService usuariosService) {
		this.usuariosService = usuariosService;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public boolean supports(Class form) {
		return LogginUser.class.isAssignableFrom(form);
	}

	@Override
	public void validate(Object loggin, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userEmail",
				"email.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userPassword",
				"password.required");
		LogginUser lu=(LogginUser)loggin;
		if(lu.getUserEmail()!=null && lu.getUserPassword()!=null){
			if(usuariosService.validaUsuario(lu.getUserEmail(), lu.getUserPassword())==false){
				errors.rejectValue("userEmail", "email.user");
			}
		}
	}

}
