package mx.com.clickapuntos.persistence;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class PremiosUsuarioId  implements java.io.Serializable{
	private Long idTransaccion;
	private Long idUsuario;
	private Long idPremio;
	private Timestamp fechaCambioPuntos;
	
	public PremiosUsuarioId(){}
	
	public PremiosUsuarioId(Long idTransaccion, Long idUsuario, Long idPremio) {
		super();
		this.idTransaccion = idTransaccion;
		this.idUsuario = idUsuario;
		this.idPremio = idPremio;
	}
	
	@Column(name = "idtransaccion", nullable = false)
	public Long getIdTransaccion() {
		return idTransaccion;
	}
	public void setIdTransaccion(Long idTransaccion) {
		this.idTransaccion = idTransaccion;
	}

	@Column(name = "idusuarios", nullable = false)
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	@Column(name = "idpremio", nullable = false)
	public Long getIdPremio() {
		return idPremio;
	}
	public void setIdPremio(Long idPremio) {
		this.idPremio = idPremio;
	}
	
	@Column( nullable = false)
	public Timestamp getFechaCambioPuntos() {
		return fechaCambioPuntos;
	}

	public void setFechaCambioPuntos(Timestamp fechaCambioPuntos) {
		this.fechaCambioPuntos = fechaCambioPuntos;
	}
	
	
}
