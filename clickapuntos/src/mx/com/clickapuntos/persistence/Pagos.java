package mx.com.clickapuntos.persistence;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "pagos", catalog = "clickapuntos")
public class Pagos implements Serializable {
	private PagosTipoId id;
	private Long cantidad;
	private String comprobantes;
	private String revision;
	private Integer autorizacion;
	
	
	@EmbeddedId
	@AttributeOverrides( {
			@AttributeOverride(name = "idPagos", column = @Column(name = "idpagos", unique = true, nullable = false)),
			@AttributeOverride(name = "idTipoPago", column = @Column(name = "tipopago_idtipopago", nullable = false)) })
	public PagosTipoId getId() {
		return id;
	}
	public void setId(PagosTipoId id) {
		this.id = id;
	}
	
	@Column(name="pagoscantidad")
	public Long getCantidad() {
		return cantidad;
	}
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}
	
	@Column(name="pagoscomprobante")
	public String getComprobantes() {
		return comprobantes;
	}
	public void setComprobantes(String comprobantes) {
		this.comprobantes = comprobantes;
	}
	
	@Column(name="pagosusrrevision")
	public String getRevision() {
		return revision;
	}
	public void setRevision(String revision) {
		this.revision = revision;
	}
	
	@Column(name="pagosusrautorizacion")
	public Integer getAutorizacion() {
		return autorizacion;
	}
	public void setAutorizacion(Integer autorizacion) {
		this.autorizacion = autorizacion;
	}
	
}
