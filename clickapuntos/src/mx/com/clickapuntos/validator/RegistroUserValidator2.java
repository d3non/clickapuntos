package mx.com.clickapuntos.validator;

import javax.inject.Inject;

import mx.com.clickapuntos.bean.RegistroUser;
import mx.com.clickapuntos.persistence.Usuarios;
import mx.com.clickapuntos.service.IUsuariosService;

import org.apache.commons.validator.EmailValidator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class RegistroUserValidator2 implements Validator {
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
			}
		}
	}

}
