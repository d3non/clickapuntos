package mx.com.clickapuntos.persistence;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "mensajesusuarios", catalog = "clickapuntos")
public class MensajeUsuarios implements Serializable {
	private MensajeTipoUsuarioId id;
	private Timestamp fechacreacion;
	private Timestamp fechaconfirmacion;
	private Timestamp fechavigencia;
	private Timestamp fechaenvio;
	private String mensaje;
	private Long contador;
	
	public MensajeUsuarios(){
		
	}
	
	public MensajeUsuarios(MensajeTipoUsuarioId id, Timestamp fechacreacion,
			Timestamp fechaconfirmacion, Timestamp fechaenvio, String mensaje,Timestamp fechavigencia,Long contador) {
		super();
		this.id = id;
		this.fechacreacion = fechacreacion;
		this.fechaconfirmacion = fechaconfirmacion;
		this.fechaenvio = fechaenvio;
		this.mensaje = mensaje;
		this.fechavigencia=fechavigencia;
		this.contador=contador;
	}
	
	@EmbeddedId
	public MensajeTipoUsuarioId getId() {
		return id;
	}
	public void setId(MensajeTipoUsuarioId id) {
		this.id = id;
	}
	
	@Column(name = "msjusrfechacreacion")
	public Timestamp getFechacreacion() {
		return fechacreacion;
	}
	public void setFechacreacion(Timestamp fechacreacion) {
		this.fechacreacion = fechacreacion;
	}
	
	@Column(name = "msjusrfechaconfirmacion")
	public Timestamp getFechaconfirmacion() {
		return fechaconfirmacion;
	}
	public void setFechaconfirmacion(Timestamp fechaconfirmacion) {
		this.fechaconfirmacion = fechaconfirmacion;
	}
	
	@Column(name = "msjusrfechaenvio")
	public Timestamp getFechaenvio() {
		return fechaenvio;
	}
	public void setFechaenvio(Timestamp fechaenvio) {
		this.fechaenvio = fechaenvio;
	}
	
	@Column(name = "msjusrmensaje")
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	@Column(name = "msjusrfechavigencia")
	public Timestamp getFechavigencia() {
		return fechavigencia;
	}

	public void setFechavigencia(Timestamp fechavigencia) {
		this.fechavigencia = fechavigencia;
	}

	@Column
	public Long getContador() {
		return contador;
	}

	public void setContador(Long contador) {
		this.contador = contador;
	}
	
}
