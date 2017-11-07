package mx.com.clickapuntos.persistence;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;



@SuppressWarnings("serial")
@Embeddable
public class PuntosUsuariosPromosId implements Serializable{
	private Long idUsuarios;
	private Integer idPromo;
	private Integer idCliente;
	
	public PuntosUsuariosPromosId(Long idUsuarios,Integer idPromo,Integer idCliente){
		this.idUsuarios=idUsuarios;
		this.idPromo=idPromo;
		this.idCliente=idCliente;
	}
	public PuntosUsuariosPromosId(){}
	
	@Column(name = "usuarios_idusuarios", nullable = false)
	public Long getIdUsuarios() {
		return idUsuarios;
	}
	public void setIdUsuarios(Long idUsuarios) {
		this.idUsuarios = idUsuarios;
	}
	
	@Column(name = "promos_idpromo", nullable = false)
	public Integer getIdPromo() {
		return idPromo;
	}
	public void setIdPromo(Integer idPromo) {
		this.idPromo = idPromo;
	}
	
	@Column(name = "promos_clientes_idcliente", nullable = false)
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
}
