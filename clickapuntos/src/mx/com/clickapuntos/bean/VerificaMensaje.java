package mx.com.clickapuntos.bean;

import java.sql.Timestamp;

public class VerificaMensaje {
	private String mensaje;
	private String idMensaje;
	private long contador;
	private Timestamp tiempo;
	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getIdMensaje() {
		return idMensaje;
	}

	public void setIdMensaje(String idMensaje) {
		this.idMensaje = idMensaje;
	}

	public long getContador() {
		return contador;
	}

	public void setContador(long contador) {
		this.contador = contador;
	}

	public Timestamp getTiempo() {
		return tiempo;
	}

	public void setTiempo(Timestamp tiempo) {
		this.tiempo = tiempo;
	}
	
}
