package mx.com.clickapuntos.persistence;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class MensajeTipoUsuarioId  implements java.io.Serializable{
	private Long idMensaje;
	private Long idTipoMensaje;
	private Long idUusarios;
	
	public MensajeTipoUsuarioId(){
		
	}
	
	public MensajeTipoUsuarioId(Long idMensaje, Long idTipoMensaje,
			Long idUusarios) {
		super();
		this.idMensaje = idMensaje;
		this.idTipoMensaje = idTipoMensaje;
		this.idUusarios = idUusarios;
	}
	
	@GeneratedValue(strategy=IDENTITY)
	@Column(name = "idmensajesusuarios", nullable = false)
	public Long getIdMensaje() {
		return idMensaje;
	}
	public void setIdMensaje(Long idMensaje) {
		this.idMensaje = idMensaje;
	}
	
	@Column(name = "tipomensaje_idtipomensaje", nullable = false)
	public Long getIdTipoMensaje() {
		return idTipoMensaje;
	}
	public void setIdTipoMensaje(Long idTipoMensaje) {
		this.idTipoMensaje = idTipoMensaje;
	}
	
	@Column(name = "usuarios_idusuarios", nullable = false)
	public Long getIdUusarios() {
		return idUusarios;
	}
	public void setIdUusarios(Long idUusarios) {
		this.idUusarios = idUusarios;
	}
	
	
}
