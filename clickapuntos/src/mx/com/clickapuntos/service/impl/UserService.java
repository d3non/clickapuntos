package mx.com.clickapuntos.service.impl;

import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;

import com.visural.common.IOUtil;

public class UserService {
	public void authFacebookLogin(String accessToken, int expires,HttpServletRequest req) {
        try {
            JSONObject resp = new JSONObject(
                IOUtil.urlToString(new URL("https://graph.facebook.com/me?access_token=" + accessToken)));
            String id = resp.getString("id");
            String firstName = resp.getString("first_name");
            String lastName = resp.getString("last_name");
           
            String link = resp.getString("link");
            String gender = resp.getString("gender");
            String locale = resp.getString("locale");
            String foto="https://graph.facebook.com/"+id+"/picture/?type=small";
            req.setAttribute("firstName", firstName);
            req.setAttribute("idUser", id);
            req.setAttribute("lastName", lastName);
            
            req.setAttribute("userFoto", foto);
            System.out.println("ID: " + id);
            System.out.println("Nombre: " + firstName);
            System.out.println("Apellido: " + lastName);
            
            System.out.println("Sexo: " + gender);
            System.out.println("Localizacion: " + locale);
            String email = resp.getString("email");
            System.out.println("email: " + email);
            req.setAttribute("userEmail", email);

        } catch (Throwable ex) {
            
        }
        finally{
        	System.out.println("Exit");
        }
    }

}
