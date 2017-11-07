package mx.com.clickapuntos.controller;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mx.com.clickapuntos.bean.UploadItem;
import mx.com.clickapuntos.persistence.RutasImagenes;
import mx.com.clickapuntos.persistence.Usuarios;
import mx.com.clickapuntos.service.IMediaService;
import mx.com.clickapuntos.service.IUsuariosService;
import mx.com.clickapuntos.validator.FileUploadValidator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value = "/userFoto.htm")
@SessionAttributes("uploadItem")
public class FotoController {
	private FileUploadValidator validatorFile;
	private IUsuariosService usuariosService;
	public IMediaService mediaService;
	
	@Inject
	public void setHomeService(IMediaService mediaService) {
		this.mediaService = mediaService;
	}
	
	@Inject
	public void setUsuariosService(IUsuariosService usuariosService) {
		this.usuariosService = usuariosService;
	}

	@Inject
	public void setValidatorFile(FileUploadValidator validatorFile) {
		this.validatorFile = validatorFile;
	}

	@RequestMapping(method = RequestMethod.GET)
	  public String getUploadForm(Model model)
	  {
		UploadItem uploadItem=new UploadItem();
		uploadItem.setFilename("user1500.jpg");
	    model.addAttribute(uploadItem);
	    return "userFoto";
	  }
	 
	  @SuppressWarnings("deprecation")
	@RequestMapping(method = RequestMethod.POST)
	  public String create(@ModelAttribute("uploadItem") UploadItem uploadItem, BindingResult result,
				HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {
		  try {
			  validatorFile.validate(uploadItem,result);
			  if (result.hasErrors()) {
					return "userFoto";
				}
				MultipartFile file = uploadItem.getFileData();
				String fileName = null;
				InputStream inputStream = null;
				OutputStream outputStream = null;
				if (file.getSize() > 0) {
					inputStream = file.getInputStream();
					if (file.getSize() > 10000) {
						System.out.println("File Size:::" + file.getSize());
						return "userFoto";
					}
					System.out.println("size::" + file.getSize());
					List<RutasImagenes> rutaUsuarios=mediaService.getAllByTipo("Usuarios");
					if(rutaUsuarios!=null){
						if(rutaUsuarios.size()>0){
							System.out.println("pagina: "  + request.getRealPath(""));
							HttpSession sesion=request.getSession(true);
							Usuarios user=(Usuarios)sesion.getAttribute("user");
							String realPath=request.getRealPath("");
							realPath=realPath.substring(0,realPath.indexOf("clickapuntos"))+rutaUsuarios.get(0).getRuta();
							System.out.println("Nueva URL: "  + realPath);
							String nombreArchivo="user" + user.getIdusuarios()
									+ file.getOriginalFilename().substring(file.getOriginalFilename().indexOf('.'), file.getOriginalFilename().length());
							System.out.println("Nombre del archivo: "  + nombreArchivo);
							fileName =realPath + nombreArchivo;
							outputStream = new FileOutputStream(fileName);
							System.out.println("fileName:" + file.getOriginalFilename());

							int readBytes = 0;
							byte[] buffer = new byte[10000];
							while ((readBytes = inputStream.read(buffer, 0, 10000)) != -1) {
								outputStream.write(buffer, 0, readBytes);
							}
							outputStream.close();
							inputStream.close();
							
							user.setUsrfoto("../"+rutaUsuarios.get(0).getRuta()+nombreArchivo);
							usuariosService.actualizaUsuario(user);
							sesion.setAttribute("user", user);
							request.setAttribute("mensajeExito", "Has modificado correctamente la foto");
						}
					}
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "userFoto";
		}

}
