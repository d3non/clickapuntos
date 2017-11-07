package mx.com.clickapuntos.persistence;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Column;

@Embeddable
public class PagosTipoId implements Serializable {
	private Long idPagos;
	private Long idTipoPago;
	
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="idpagos",nullable=false)
	public Long getIdPagos() {
		return idPagos;
	}
	public void setIdPagos(Long idPagos) {
		this.idPagos = idPagos;
	}
	
	@Column(name="tipopago_idtipopago",nullable=false)
	public Long getIdTipoPago() {
		return idTipoPago;
	}
	public void setIdTipoPago(Long idTipoPago) {
		this.idTipoPago = idTipoPago;
	}
}
