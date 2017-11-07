 package mx.com.clickapuntos.bean;
 
 import java.util.Calendar;
 import org.tempuri.WebServOrdersTransactional.ServOrdersTransactional.*;
 
 public class XML_ServiceTAE {
	 
	
		public boolean taeWebService(int noTrans, String noSku, String noTelefono, int telefonica) {
			try{
				int cadena = 16514;
				int establecimiento = 18443;
				int terminal = 64599;
				String cajero = "ws_16514";
				String clave = "#ckpt*2011#";
				String cveEdo = "09";
				Cuenta cuenta = new Cuenta();
				InputRecarga recarga = new InputRecarga();
				cuenta.setCadena(cadena);
				cuenta.setEstablecimiento(establecimiento);
				cuenta.setTerminal(terminal);
				cuenta.setCajero(cajero);
				cuenta.setClave(clave);
				recarga.setCuenta(cuenta);
				

				java.text.SimpleDateFormat conv = new java.text.SimpleDateFormat ("dd/MM/yyyy HH:mm:ss");
				Calendar now = Calendar.getInstance ();
				String fecha = conv.format (now.getTime());

				recarga.setTelefono(noTelefono);
				recarga.setSku(noSku);
				recarga.setNo_transaccion(noTrans);
				recarga.setFecha_hora(fecha);
				recarga.setCve_estado(cveEdo);
				ServicetaeSoapProxy proxy = new ServicetaeSoapProxy();
				//System.out.println("PARAMETROS: " + recarga.getTelefono() + " " + recarga.getSku() + " " + recarga.getNo_transaccion() + " " + recarga.getFecha_hora() + " " + recarga.getCve_estado()); 
				if ( telefonica == 1 )//Telcel
					proxy.setEndpoint("https://www.mtcpos.com.mx/MTCenter.WS.TAE/servicetae.asmx");
				else//Movistar, Iusacell, Nextel, Unefon
					proxy.setEndpoint("http://201.144.219.231/OPE.WS.TAE/Servicetae.asmx");
				
				OutputRecarga response = proxy.recarga(recarga);
			    System.out.println("RESPUESTA WEB SERVICE: " + response.getCodigo_respuesta());
			    
			    if (response.getCodigo_respuesta() == 0)
			    	return true;
			}
			
			  catch(Exception e){
				  e.printStackTrace();
				  return false;
			  }

			return false;
			
		}
		
	}
