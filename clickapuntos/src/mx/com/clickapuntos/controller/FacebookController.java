package mx.com.clickapuntos.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import mx.com.clickapuntos.bean.Facebook;
import mx.com.clickapuntos.persistence.Autentificacion;
import mx.com.clickapuntos.persistence.Promos;
import mx.com.clickapuntos.persistence.Usuarios;
import mx.com.clickapuntos.service.IMediaService;
import mx.com.clickapuntos.service.IUsuariosService;
import mx.com.clickapuntos.service.impl.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.visural.common.StringUtil;

/**
 * Handles requests for the application home page.
 */
@Controller
public class FacebookController {
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
        
        @RequestMapping(value="/logginFacebook.htm")
        public String authenticate(HttpServletRequest req)throws IOException, ServletException{
                System.out.println("Entro Facebook Register-----");
                String code = req.getParameter("code");
                HttpSession sesion=req.getSession(true);
                String resp="redirect:/videos.htm" ;
                
                if (StringUtil.isNotBlankStr(code)) {
                	List<Autentificacion> las=usuariosService.getAutentificacionAll();
                	String authURL="";
                	if(las!=null){
            			if(las.size()>0){
            				for(Autentificacion aut:las){
            					if(aut.getProvider().equals("facebook"))
            						authURL = Facebook.getAuthURL(code,aut.getApikey(),aut.getApisecret(),aut.getCallbackurl());
            				}
            			}
                	}
                	System.out.println("AUTHURL----- : " + authURL);
                    URL url = new URL(authURL);
                    try {
                        String result = readURL(url);
                        String accessToken = null;
                        Integer expires = null;
                        String[] pairs = result.split("&");
                        for (String pair : pairs) {
                            String[] kv = pair.split("=");
                            if (kv.length != 2) {
                                throw new RuntimeException("Unexpected auth response");
                            } else {
                                if (kv[0].equals("access_token")) {
                                    accessToken = kv[1];
                                }
                                if (kv[0].equals("expires")) {
                                    expires = Integer.valueOf(kv[1]);
                                }
                            }
                        }
                        if (accessToken != null && expires != null) {
                            UserService us = new UserService();
                            us.authFacebookLogin(accessToken, expires,req);
                            System.out.println(result);
                            Usuarios users=new Usuarios();
                            users.setIdusuarios(Long.parseLong(String.valueOf(req.getAttribute("idUser"))));
                            users.setUsridexterno(String.valueOf(req.getAttribute("idUser")));
                            users.setUsrusername(String.valueOf(req.getAttribute("firstName")));
                            users.setUsremail(String.valueOf(req.getAttribute("userEmail")));
                            users.setUsrfoto(String.valueOf(req.getAttribute("userFoto")));
                            users.setProvider("loginFacebook");
                            users.setUsrstatus("1");
                            users=usuariosService.InsertaOActualiza(users);
                            users.setUsrfechaultimasesion(new java.sql.Date(new java.util.Date().getTime()));
                			long numSesion=1;
                			if(users.getUsrnumerosesion()!=null)
                				numSesion+=(users.getUsrnumerosesion());
                			users.setUsrnumerosesion(numSesion);
                			usuariosService.actualizaUsuario(users);
                			if(numSesion>=2 && usuariosService.datosIncompletos(users)==true){
                				String mensaje="Para que seas un usuario valido necesitas completar tu perfil!!";
                				sesion.setAttribute("mensaje", mensaje);
                				System.out.println("Entro: " + numSesion + mensaje);
                			}
                			Integer banPromo=(Integer)sesion.getAttribute("banPromo");
    		    			if(banPromo!=null){
    		    				if(banPromo>0){
    		    					if(mediaService.getPuntosUsrByUserPromoId(users.getIdusuarios(), Long.parseLong(String.valueOf(banPromo)))==null){
    		    						Promos promos=mediaService.getPromosById(banPromo);
    		    						mediaService.insPuntosUsr(users.getIdusuarios(), banPromo, promos.getClientes().getIdcliente(), promos.getMaxPuntos());
    		    						
    		    					}
    		    					banPromo=null;
		    						sesion.setAttribute("banPromo",banPromo);
    		    				}
    		    			}
                            sesion.setAttribute("user", users);
                            
                        } else {
                            throw new RuntimeException("Access token and expires not found");
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                return resp;
        }
        private String readURL(URL url) throws IOException {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            InputStream is = url.openStream();
            int r;
            while ((r = is.read()) != -1) {
                baos.write(r);
            }
            return new String(baos.toByteArray());
        }
}

