package mx.com.clickapuntos.util;

import java.util.List;

import mx.com.clickapuntos.persistence.Mediausuario;

public class ComprobarLista {
	public void iteraListaMediaUs(List<Mediausuario> listaMedia){
		for(Mediausuario medUs : listaMedia){
			System.out.println(medUs.getId().getMediaIdmedia());
		}
	}
}
