package mx.com.clickapuntos.controller;




import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.transform.dom.DOMSource;

import mx.com.clickapuntos.persistence.Promos;
import mx.com.clickapuntos.persistence.Usuarios;
import mx.com.clickapuntos.persistence.Usuariosdatos;
import mx.com.clickapuntos.persistence.Usuariotipo;
import mx.com.clickapuntos.service.IMediaService;
import mx.com.clickapuntos.service.IUsuariosService;

import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.TwitterApi;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;
import org.springframework.integration.xml.source.DomSourceFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.w3c.dom.NodeList;

@Controller
public class TwitterController {
	private static OAuthService  service;
	private static Token requestToken;
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
	public static OAuthService getOAuthService(String apiKey,String apiSecret,String callbackURL) {
        OAuthService service = new ServiceBuilder()
        .provider(TwitterApi.class)
        .apiKey(apiKey)
        .apiSecret(apiSecret)
        .callback(callbackURL)
        .build();
        return service;
    }
	
	@RequestMapping("logginTwitter.htm")
	public String getUrl(@RequestParam(value="apiKey")String apiKey,
						 @RequestParam(value="apiSecret")String apiSecret,
						 @RequestParam(value="callbackURL")String callbackURL,HttpServletRequest req){
		HttpSession sesion=req.getSession(true);
		Usuarios user=(Usuarios) sesion.getAttribute("user");
		boolean activa=false;
		String urlAct="";
		if(user!=null){
			if(user.getUsridexterno()!=null)
			if(usuariosService.validaUsuarioP(user.getUsridexterno(), "loginTwitter")>-1){
				activa=true;
				urlAct=(String) sesion.getAttribute("urlAnt");
			}
		}
		if(activa==false){
			service = getOAuthService(apiKey,apiSecret,callbackURL);
	
		    System.out.println("=== Twitter's OAuth Workflow ===");
		    System.out.println();
	
		    // Obtain the Request Token
		    System.out.println("Fetching the Request Token...");
		    requestToken = service.getRequestToken();
		    System.out.println("Got the Request Token!");
		    System.out.println();
	
		    System.out.println("Now go and authorize Scribe here:");
		    urlAct=service.getAuthorizationUrl(requestToken);
		}
		    return "redirect:" + urlAct;
		  
	}
	
	@RequestMapping("/loginSuccessTwitter.htm")
	public String direccion(HttpServletRequest req){
		String code=req.getParameter("oauth_verifier");
		HttpSession sesion=req.getSession(true);
        String resp="redirect:/videos.htm";
	    if(code!=null){
	    	if(!code.equals("")){
				Verifier verifier = new Verifier(code);
			    System.out.println();
		
			    // Trade the Request Token and Verfier for the Access Token
			    System.out.println("Trading the Request Token for an Access Token...");
			    Token accessToken = service.getAccessToken(requestToken, verifier);
			    System.out.println("Got the Access Token!");
			    System.out.println("(if your curious it looks like this: " + accessToken + " )");
			    System.out.println();
			 // getting user profile
		 		OAuthRequest oauthRequest = new OAuthRequest(Verb.GET, "https://api.twitter.com/1/account/verify_credentials.xml");
		 		service.signRequest(accessToken, oauthRequest); // the access token from step 4
		 		Response oauthResponse = oauthRequest.send();
		 		String body=oauthResponse.getBody();
		 		System.out.println(body);
		 		DOMSource source = (DOMSource) new DomSourceFactory().createSource(body);
		 		NodeList nodelist = source.getNode().getChildNodes();
		 		Long idUser=new Long("1");
		 		String firstName="",foto="",nickname="";
		 		
		 		boolean exito=false;
		 		if(!accessToken.getToken().equals("")){
			        for (int i=0; i<nodelist.getLength(); i++) {
			        	if(nodelist.item(i).getNodeName().equals("id")){
			        		System.out.println("ID: " + nodelist.item(i).getTextContent());
			        		idUser=Long.parseLong(nodelist.item(i).getTextContent());
			        		exito=true;
			        	}
			        	if(nodelist.item(i).getNodeName().equals("name")){
			        		System.out.println("Nombre: " + nodelist.item(i).getTextContent());
			        		firstName=nodelist.item(i).getTextContent();
			        		exito=true;
			        	}
			        	if(nodelist.item(i).getNodeName().equals("screen_name")){
			        		System.out.println("Nickname: " + nodelist.item(i).getTextContent());
			        		nickname=nodelist.item(i).getTextContent();
			        		exito=true;
			        	}
			        	if(nodelist.item(i).getNodeName().equals("profile_image_url")){
			        		System.out.println("foto: " + nodelist.item(i).getTextContent());
			        		foto=nodelist.item(i).getTextContent();
			        		exito=true;
			        	}
			        }
			        if(exito==true){
			        	Usuarios users=new Usuarios();
		                users.setIdusuarios(idUser);
		                users.setUsridexterno(String.valueOf(idUser));
		                users.setUsrusername(nickname);
		                users.setUsrfoto(foto);
		                users.setProvider("loginTwitter");
		                users.setUsrstatus("1");
		                Usuariotipo ut=usuariosService.getUsuarioTipoById(1);
		               
		                if(ut!=null){
		                	users.setUsuariotipo(ut);
		                }
		                users=usuariosService.InsertaOActualiza(users);
		                users.setUsrfechaultimasesion(new java.sql.Date(new java.util.Date().getTime()));
		    			long numSesion=1;
		    			if(users.getUsrnumerosesion()!=null)
		    				numSesion+=(users.getUsrnumerosesion());
		    			users.setUsrnumerosesion(numSesion);
		    			Usuariosdatos ud=usuariosService.getUsuariosDatosByIdUser(Integer.parseInt(String.valueOf(users.getIdusuarios())));
						if(ud==null){
							ud=new Usuariosdatos();
			                ud.setIdusuarios(Integer.parseInt(String.valueOf(users.getIdusuarios())));
			                ud.setUsrnombres(firstName);
			                users.setUsuariosdatos(ud);
			                usuariosService.SaveOrUpdate(ud);
						}
		    			usuariosService.actualizaUsuario(users);
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
		    			if(numSesion>=1 && usuariosService.datosIncompletos(users)==true){
		    				String mensaje="Para que seas un usuario valido necesitas completar tu perfil!!";
		    				sesion.setAttribute("mensaje", mensaje);
		    				System.out.println("Entro: " + numSesion + mensaje);
		    			}
		                sesion.setAttribute("user", users);
			        }
		 		}
	    	}
	    }
	    return resp;
	  }
}
