package mx.com.clickapuntos.persistence;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "puntosusuariopremio", catalog = "clickapuntos")
public class PuntosUsuarioPremio implements Serializable{
	private PremiosUsuarioId id;
	private Timestamp fechaMaxEspera;
	private Timestamp fechaRecogioPremio;
	private Long mensajeId;
	private String statusCanje;
	
	public PuntosUsuarioPremio(){}
	
	public PuntosUsuarioPremio(PremiosUsuarioId id,
				Long mensajeId, Timestamp fechaMaxEspera, Timestamp fechaRecogioPremio, String statusCanje) {
		super();
		this.id = id;
		this.mensajeId = mensajeId;
		this.fechaMaxEspera = fechaMaxEspera;
		this.fechaRecogioPremio = fechaRecogioPremio;
		this.statusCanje=statusCanje;
	}
	
	@EmbeddedId
	public PremiosUsuarioId getId() {
		return id;
	}
	public void setId(PremiosUsuarioId id) {
		this.id = id;
	}

	@Column
	public Long getMensajeId() {
		return mensajeId;
	}
	public void setMensajeId(Long mensajeId) {
		this.mensajeId = mensajeId;
	}

	@Column
	public Timestamp getFechaMaxEspera() {
		return fechaMaxEspera;
	}
	public void setFechaMaxEspera(Timestamp fechaMaxEspera) {
		this.fechaMaxEspera = fechaMaxEspera;
	}
	
	@Column
	public Timestamp getFechaRecogioPremio() {
		return fechaRecogioPremio;
	}
	public void setFechaRecogioPremio(Timestamp fechaRecogioPremio) {
		this.fechaRecogioPremio = fechaRecogioPremio;
	}
	

	public String getStatusCanje() {
		return statusCanje;
	}

	public void setStatusCanje(String statusCanje) {
		this.statusCanje = statusCanje;
	}
	
	
}
