package mx.com.clickapuntos.validator;

import javax.inject.Inject;
import mx.com.clickapuntos.bean.UserBean;
import mx.com.clickapuntos.persistence.Usuarios;
import mx.com.clickapuntos.service.IUsuariosService;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.apache.commons.validator.EmailValidator;

public class UserPerfilValidator implements Validator{
	private IUsuariosService usuariosService;
	
	@Inject	
	public void setUsuarioService(IUsuariosService usuariosService) {
		this.usuariosService = usuariosService;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public boolean supports(Class form) {
		return UserBean.class.isAssignableFrom(form);
	}

	@Override
	public void validate(Object userBean, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "correo",
				"email.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre",
				"nombre.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nickname",
				"nickname.required");
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "calle",
		//		"calle.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apellidoPaterno",
				"apellidoPaterno.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apellidoMaterno",
				"apellidoMaterno.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "celular",
				"celular.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cp",
				"cp.required");
		UserBean ub=(UserBean) userBean;
		if(ub!=null){
			System.out.println("Id User en validate:  " + ub.getIdUser());
			if(ub.getCorreo()!=null){
				if(!(ub.getCorreo().equals(""))){
					boolean resp=EmailValidator.getInstance().isValid(ub.getCorreo());
					if(resp==false){
						errors.rejectValue("correo", "email.novalid");
					}
					else{
						Usuarios userAux=usuariosService.getUsuariosByEmail(ub.getCorreo());
						if(userAux!=null){
							if(ub.getIdUser()==null){
								errors.rejectValue("correo", "email.usuarios");
							}
							else if(!(userAux.getIdusuarios().equals(Long.parseLong(ub.getIdUser())))){
								errors.rejectValue("correo", "email.usuarios");
							}
							System.out.println(userAux.getIdusuarios());
						}
					}
				}
				if(ub.getBloqueoCelular()!=null){
					if(!ub.getBloqueoCelular().equals("blockeo")){
						if(!ub.getCelular().equals("")){
							Usuarios userAux=usuariosService.getUsuariosByCelular(ub.getCelular());
							if(userAux!=null){
								if(ub.getIdUser()==null){
									errors.rejectValue("celular", "celular.usuarios");
								}
								else if(!(userAux.getIdusuarios().equals(Long.parseLong(ub.getIdUser())))){
									errors.rejectValue("celular", "celular.usuarios");
								}
								System.out.println(userAux.getIdusuarios());
							}
							if(ub.getCelularcheck().equals("") && !ub.getCelular().equals("")){
								errors.rejectValue("celularcheck", "celularcheck.invalid");
							}
							if(!ub.getCelularcheck().equals("")){
								if(!ub.getCelular().equals(ub.getCelularcheck())){
									errors.rejectValue("celularcheck", "celularcheck.invalid");
								}
							}
							if(ub.getCelular().length()!=10){
								errors.rejectValue("celular", "celular.longitud");
							}
							if(!esNumero(ub.getCelular())){
								errors.rejectValue("celular", "celular.numerico");
							}
						}
					}
				}
				
			}
		}
	}
	public static boolean esNumero(String cadena){
		try {
			if(esEntero(cadena) || esDoble(cadena))
				return true;
			else	return false;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
	public static boolean esEntero(String cadena){
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
	public static boolean esDoble(String cadena){
		try {
			Double.parseDouble(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
}
