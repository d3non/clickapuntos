package mx.com.clickapuntos.service.impl;

import mx.com.clickapuntos.service.IHomeService;

import org.springframework.stereotype.Service;

@Service 
public class HomeService implements IHomeService{
		
	public void imprime(){
		System.out.println("Inyeccion exitosa");
	}
	
}
