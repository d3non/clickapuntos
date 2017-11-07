package mx.com.clickapuntos.persistence;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "puntosusr", catalog = "clickapuntos")
public class PuntosUsr implements Serializable{
	private PuntosUsuariosPromosId id;
	private Timestamp fechacreacion;
	private Long valor;
	private String status;
	private Date vigencia;
	
	@EmbeddedId
	@AttributeOverrides( {
			@AttributeOverride(name = "idUsuarios", column = @Column(name = "usuarios_idusuarios", nullable = false)),
			@AttributeOverride(name = "idPromo", column = @Column(name = "promos_idpromo", nullable = false)),
			@AttributeOverride(name = "idCliente", column = @Column(name = "promos_clientes_idcliente", nullable = false)) })
	public PuntosUsuariosPromosId getId() {
		return id;
	}
	public void setId(PuntosUsuariosPromosId id) {
		this.id = id;
	}
	
	@Column(name="puntosusrfechacreacion")
	public Timestamp getFechacreacion() {
		return fechacreacion;
	}
	public void setFechacreacion(Timestamp fechacreacion) {
		this.fechacreacion = fechacreacion;
	}
	
	@Column(name="puntosusrvalor")
	public Long getValor() {
		return valor;
	}
	public void setValor(Long valor) {
		this.valor = valor;
	}
	
	@Column(name="puntosusrtatus")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name="puntosusrvigencia")
	public Date getVigencia() {
		return vigencia;
	}
	public void setVigencia(Date vigencia) {
		this.vigencia = vigencia;
	}
}
