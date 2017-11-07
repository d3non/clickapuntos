package mx.com.clickapuntos.persistence;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "puntosusuario", catalog = "clickapuntos")
public class PuntosUsuarios implements Serializable {
	private Long idUsuarios;
	private Long totalPuntos;
	private Long puntosCanjeados;
	private Long puntosDisponibles;
	private Timestamp fechaActualCambio;
	
	public PuntosUsuarios(){
		
	}
	
	public PuntosUsuarios(Long idUsuarios, Long totalPuntos,
			Long puntosCanjeados, Long puntosDisponibles,
			Timestamp fechaActualCambio) {
		super();
		this.idUsuarios = idUsuarios;
		this.totalPuntos = totalPuntos;
		this.puntosCanjeados = puntosCanjeados;
		this.puntosDisponibles = puntosDisponibles;
		this.fechaActualCambio = fechaActualCambio;
	}
	
	@Id
	@Column(name = "idusuarios", nullable = false)
	public Long getIdUsuarios() {
		return idUsuarios;
	}
	public void setIdUsuarios(Long idUsuarios) {
		this.idUsuarios = idUsuarios;
	}
	
	@Column
	public Long getTotalPuntos() {
		return totalPuntos;
	}
	public void setTotalPuntos(Long totalPuntos) {
		this.totalPuntos = totalPuntos;
	}
	
	@Column
	public Long getPuntosCanjeados() {
		return puntosCanjeados;
	}
	public void setPuntosCanjeados(Long puntosCanjeados) {
		this.puntosCanjeados = puntosCanjeados;
	}
	
	@Column
	public Long getPuntosDisponibles() {
		return puntosDisponibles;
	}
	public void setPuntosDisponibles(Long puntosDisponibles) {
		this.puntosDisponibles = puntosDisponibles;
	}
	
	@Column
	public Timestamp getFechaActualCambio() {
		return fechaActualCambio;
	}
	public void setFechaActualCambio(Timestamp fechaActualCambio) {
		this.fechaActualCambio = fechaActualCambio;
	}
}
