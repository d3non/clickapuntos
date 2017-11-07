package mx.com.clickapuntos.persistence;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "detallepuntos", catalog = "clickapuntos")
public class DetallePuntos implements Serializable {
	private Long idPuntos;
	private Long cantidad;
	private Timestamp fechaAsignacion;
	
	@Id
	@Column(name="idpuntos",nullable=false)
	public Long getIdPuntos() {
		return idPuntos;
	}
	public void setIdPuntos(Long idPuntos) {
		this.idPuntos = idPuntos;
	}
	
	@Column(name="puntoscantidad") 	
	public Long getCantidad() {
		return cantidad;
	}
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}
	
	@Column(name="puntosfechaasignacion")
	public Timestamp getFechaAsignacion() {
		return fechaAsignacion;
	}
	public void setFechaAsignacion(Timestamp fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}
}
