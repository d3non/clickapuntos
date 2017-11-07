package mx.com.clickapuntos.bean;

import com.auronix.calixta.GatewayException;
import com.auronix.calixta.sms.SMSGateway;

public class SendSMSDemo {
	public static void main(String[] args) {
	    
    	//Para mensajes de texto
        SMSGateway smsGateway;
        smsGateway = new SMSGateway();
        try{
        
            //El primer parámetro puede ser una lista de celulares (a 10 dígitos) separados por comas y 
            //el segundo parámetro es el mensaje a enviar     
            int resp = smsGateway.sendMessage("5527601686","Mensaje enviado desde Java");
            System.out.println(resp);
                      
            //También se puede incluir la clave de larga distancia
            //smsGateway.sendMessage("+5215500000000,+5215500000021","Mensaje enviado desde Java");    

        }catch(GatewayException e){
            e.printStackTrace();
        }
    }
}
