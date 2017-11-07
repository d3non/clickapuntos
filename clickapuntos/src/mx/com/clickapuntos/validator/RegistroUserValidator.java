package mx.com.clickapuntos.validator;

import javax.inject.Inject;

import mx.com.clickapuntos.bean.RegistroUser;
import mx.com.clickapuntos.persistence.Usuarios;
import mx.com.clickapuntos.service.IUsuariosService;

import org.apache.commons.validator.EmailValidator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import net.tanesha.recaptcha.ReCaptchaResponse;
public class RegistroUserValidator implements Validator {
	private IUsuariosService usuariosService;
	
	@Inject	
	public void setUsuarioService(IUsuariosService usuariosService) {
		this.usuariosService = usuariosService;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public boolean supports( Class form) {
		return RegistroUser.class.isAssignableFrom(form);
	}

	@Override
	public void validate(Object registroUser, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email",
				"email.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nickname",
				"nombre.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"password.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordCheck",
				"password.required");
		RegistroUser ru=(RegistroUser) registroUser;
		if(ru!=null){
			if(ru.getEmail()!=null){
				if(!ru.getEmail().equals("")){
					boolean resp=EmailValidator.getInstance().isValid(ru.getEmail());
					if(resp==false){
						errors.rejectValue("email", "email.novalid");
					}
					else{
						Usuarios userAux=usuariosService.getUsuariosByEmail(ru.getEmail());
						if(userAux!=null){
							errors.rejectValue("email", "email.usuarios");
						}
					}
				}
				if(!ru.getPassword().equals("")){
					if(!ru.getPassword().equals(ru.getPasswordCheck())){
						errors.rejectValue("passwordCheck", "passwordCheck.invalid");
					}
				}
				if(!ru.getCondiciones()){
					errors.rejectValue("condiciones", "error.condiciones");
				}
				
			    if (!ru.getCaptcha().isValid()) {
			    	errors.rejectValue("captcha", "error.badCaptcha");
			    	/*FieldError fieldError = new FieldError(
			            "comment",
			            "captcha",
			            response,
			            false,
			            new String[] { "error.badCaptcha" },
			            null,
			            "Trata un nuevo código de validación");
			        result.addError(fieldError);*/
			    }

			}
		}
	}

}
