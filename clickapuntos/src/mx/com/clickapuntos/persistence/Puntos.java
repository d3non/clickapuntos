package mx.com.clickapuntos.persistence;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "puntos", catalog = "clickapuntos")
public class Puntos implements Serializable {
	private PuntosPagosTipocambioClientesId id;
	private Long cantidad;
	private Timestamp fechaCreacion;
	private Timestamp fechaValidez;
	
	@EmbeddedId
	public PuntosPagosTipocambioClientesId getId() {
		return id;
	}
	public void setId(PuntosPagosTipocambioClientesId id) {
		this.id = id;
	}
	
	@Column(name="puntoscantidad")
	public Long getCantidad() {
		return cantidad;
	}
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}
	
	@Column(name="puntosfechacreacion")
	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	@Column(name="puntosfechavalidez")
	public Timestamp getFechaValidez() {
		return fechaValidez;
	}
	public void setFechaValidez(Timestamp fechaValidez) {
		this.fechaValidez = fechaValidez;
	}
}
