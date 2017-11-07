package mx.com.clickapuntos.controller;

import java.sql.Date;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpSession;
import mx.com.clickapuntos.bean.UserBean;
import mx.com.clickapuntos.persistence.PuntosUsuarios;
import mx.com.clickapuntos.persistence.Usuarios;
import mx.com.clickapuntos.persistence.Usuariosdirecciones;
import mx.com.clickapuntos.service.IMediaService;
import mx.com.clickapuntos.service.IUsuariosService;
import mx.com.clickapuntos.validator.UserPerfilValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import mx.com.clickapuntos.persistence.Usuariosdatos;


@Controller
@RequestMapping("/perfilUser.htm")
@SessionAttributes("userBean")
public class PerfilController {
	private IUsuariosService usuariosService;
	private UserPerfilValidator userPerfilValidator;
	public IMediaService mediaService;
	@Inject
	public void setHomeService(IMediaService mediaService) {
		this.mediaService = mediaService;
	}

	@Autowired
	public void UserLogginController(IUsuariosService usuariosService, UserPerfilValidator userPerfilValidator) {
		this.usuariosService = usuariosService;
		this.userPerfilValidator = userPerfilValidator;
	}
	
	@RequestMapping(method = RequestMethod.GET)
    public String showPerfilUser(ModelMap model,HttpServletRequest req){
		HttpSession sesion = req.getSession(true);
		Usuarios user = (Usuarios) sesion.getAttribute("user");
		UserBean userBean = new UserBean();
		userBean.setCompanias(usuariosService.getCompaniasAll());
		
		if(user != null){
			user = usuariosService.getUsuariosByIdUser(user.getIdusuarios());
			if(user.getUsrusername()!=null){
				userBean.setNickname(user.getUsrusername());
				userBean.setNombre(user.getUsrusername());
			}
			if(user.getIdcompaniacelular()!=null){
				userBean.setCompania(String.valueOf(user.getIdcompaniacelular()));
			}
			if(user.getTipoplan()!=null){
				userBean.setTipoplan(String.valueOf(user.getTipoplan()));
			}
			if(user.getUsremail()!=null){
				if(!user.getUsremail().equals("")) userBean.setCorreo(user.getUsremail());
			}
			if(user.getUsrsexo()!=null){
				if(!user.getUsrsexo().equals("")) userBean.setSexo(user.getUsrsexo());
			}
			userBean.setBloqueoCelular("No blockeo");
			if(user.getUsrcelular()!=null){
				if(!user.getUsrcelular().equals("")) userBean.setCelular(user.getUsrcelular());
				userBean.setBloqueoCelular("blockeo");
			}
			userBean.setIdUser(String.valueOf(user.getIdusuarios()));

			Usuariosdatos usuariosDatos=usuariosService.getUsuariosDatosByIdUser(Integer.parseInt(userBean.getIdUser()));
			if(usuariosDatos!=null){
				String fecha=null;
				if(usuariosDatos.getUsrnombres()!=null) userBean.setNombre(usuariosDatos.getUsrnombres());
				if(usuariosDatos.getUsramaterno()!=null)userBean.setApellidoMaterno(usuariosDatos.getUsramaterno());
				if(usuariosDatos.getUsrapaterno()!=null)userBean.setApellidoPaterno(usuariosDatos.getUsrapaterno());
				if(usuariosDatos.getFechaNacimiento()!=null){
					fecha=String.valueOf(usuariosDatos.getFechaNacimiento());
					String[] fechas=fecha.split("-");

					if(fechas.length==3){
						userBean.setAnio(fechas[0]);
						userBean.setMes(fechas[1]);
						userBean.setDia(fechas[2]);
					}
				}
				
			}
			Usuariosdirecciones usuariosDirecciones=usuariosService.getUsuariosDireccionesByIdUser(Integer.parseInt(userBean.getIdUser()));
			if(usuariosDirecciones!=null){
				if(usuariosDirecciones.getUdcalle()!=null) userBean.setCalle(usuariosDirecciones.getUdcalle());
				if(usuariosDirecciones.getUdcodigopostal()!=null) userBean.setCp(usuariosDirecciones.getUdcodigopostal());
			}
			
		}
		
		sesion.setAttribute("user", user);
		
		model.addAttribute("userBean",userBean);
		long numTotal=0;
		if(user!=null){
			PuntosUsuarios pus=mediaService.getPuntosUsuarioById(user.getIdusuarios());
			if(pus!=null){
				numTotal=pus.getPuntosDisponibles();
			}
		}
		model.put("numTotal", numTotal);
		Integer banPromo=(Integer)sesion.getAttribute("banPromo");
		if(banPromo!=null){
			if(banPromo>0){
				banPromo=null;
				sesion.setAttribute("banPromo",banPromo);
			}
		}
		return "perfilUser";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(@ModelAttribute("userBean") UserBean ub,
			BindingResult result,HttpServletRequest req,ModelMap model) {
		
		if(ub.getIdUser()!=null){
			System.out.println("Tracing 1");
			if(!ub.getIdUser().equals("")){
				System.out.println("Tracing 2");
				userPerfilValidator.validate(ub, result);
				Usuarios user=usuariosService.getUsuariosByIdUser(Long.valueOf(ub.getIdUser()));
				long numTotal=0;
				if(user!=null){
					PuntosUsuarios pus=mediaService.getPuntosUsuarioById(user.getIdusuarios());
					if(pus!=null){
						numTotal=pus.getPuntosDisponibles();
					}
				}
				model.put("numTotal", numTotal);
				System.out.println(" Errores : "  + result);
				if(!result.hasErrors()){
					System.out.println("Tracing 3");
					user.setUsrcelular(ub.getCelular());
					user.setIdcompaniacelular(Integer.parseInt(ub.getCompania()));
					user.setTipoplan(Integer.parseInt(ub.getTipoplan()));
					user.setUsremail(ub.getCorreo());
					user.setUsrusername(ub.getNickname());
					Usuariosdatos userDatos=usuariosService.getUsuariosDatosByIdUser(Integer.parseInt(ub.getIdUser()));
					if(userDatos==null){
						userDatos=new Usuariosdatos();
					}
					Date fechaNac=Date.valueOf(ub.getAnio()+"-"+ub.getMes()+"-"+ub.getDia());
					userDatos.setFechaNacimiento(fechaNac);
					userDatos.setIdusuarios(Integer.parseInt(ub.getIdUser()));
					userDatos.setUsramaterno(ub.getApellidoMaterno().toUpperCase());
					userDatos.setUsrapaterno(ub.getApellidoPaterno().toUpperCase());
					userDatos.setUsrnombres(ub.getNombre().toUpperCase());
					usuariosService.SaveOrUpdate(userDatos);
					user.setUsuariosdatos(userDatos);
					Usuariosdirecciones userDirecciones=usuariosService.getUsuariosDireccionesByIdUser(Integer.parseInt(ub.getIdUser()));
					if(userDirecciones==null){
						userDirecciones=new Usuariosdirecciones();
					}
					userDirecciones.setIdusuariosdirecciones(Integer.parseInt(ub.getIdUser()));
					userDirecciones.setUdcalle(ub.getCalle());
					userDirecciones.setUdnumerocel(ub.getCelular());
					userDirecciones.setUdcodigopostal(ub.getCp());
					usuariosService.SaveOrUpdateDirecciones(userDirecciones);
					user.setUsuariosdirecciones(userDirecciones);
					user.setUsrsexo(ub.getSexo());
					usuariosService.actualizaUsuario(user);
					HttpSession sesion=req.getSession(true);
					Usuarios us=(Usuarios)sesion.getAttribute("user");
					if(us!=null){
						us=usuariosService.getUsuariosByIdUser(user.getIdusuarios());
						if(us.getUsrstatus()!=null){
							if(us.getUsrstatus().equals("1")){
								usuariosService.createMensaje(new Long("0"),us);
							}
						}
						sesion.setAttribute("user", us);
					}
					System.out.println("Exito en actualizacion User");
				}
			}
		}
		return "perfilUser";
	}
}
