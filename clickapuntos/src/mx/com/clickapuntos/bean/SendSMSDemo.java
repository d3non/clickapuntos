package mx.com.clickapuntos.bean;

import com.auronix.calixta.GatewayException;
import com.auronix.calixta.sms.SMSGateway;

public class SendSMSDemo {
	public static void main(String[] args) {
	    
    	//Para mensajes de texto
        SMSGateway smsGateway;
        smsGateway = new SMSGateway();
        try{
        
            //El primer par�metro puede ser una lista de celulares (a 10 d�gitos) separados por comas y 
            //el segundo par�metro es el mensaje a enviar     
            int resp = smsGateway.sendMessage("5527601686","Mensaje enviado desde Java");
            System.out.println(resp);
                      
            //Tambi�n se puede incluir la clave de larga distancia
            //smsGateway.sendMessage("+5215500000000,+5215500000021","Mensaje enviado desde Java");    

        }catch(GatewayException e){
            e.printStackTrace();
        }
    }
}
