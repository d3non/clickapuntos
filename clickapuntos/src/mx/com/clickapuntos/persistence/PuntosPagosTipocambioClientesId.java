package mx.com.clickapuntos.persistence;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;

@Embeddable
public class PuntosPagosTipocambioClientesId implements Serializable{
	private Long idPuntos;
	private Long idPagos;
	private Long idTipocambio;
	private Long idCliente;
	
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="idpuntos",unique=true,nullable=false)
	public Long getIdPuntos() {
		return idPuntos;
	}
	public void setIdPuntos(Long idPuntos) {
		this.idPuntos = idPuntos;
	}
	
	@Column(name="pagos_idpagos",nullable=false)
	public Long getIdPagos() {
		return idPagos;
	}
	public void setIdPagos(Long idPagos) {
		this.idPagos = idPagos;
	}
	
	@Column(name="tipocambiopuntospesos_idtipocambiopuntospesos",nullable=false)
	public Long getIdTipocambio() {
		return idTipocambio;
	}
	public void setIdTipocambio(Long idTipocambio) {
		this.idTipocambio = idTipocambio;
	}
	
	@Column(name="clientes_idcliente",nullable=false)
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
}
