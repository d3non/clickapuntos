package mx.com.clickapuntos.persistence;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "detallepromo", catalog = "clickapuntos")
public class DetallePromo implements Serializable{
	private Long idPromo;
	private Long cantidadPuntos;
	private Timestamp fecha;
	
	@Id
	@Column(name="idpromo",nullable=false)
	public Long getIdPromo() {
		return idPromo;
	}
	public void setIdPromo(Long idPromo) {
		this.idPromo = idPromo;
	}
	
	@Column(name="promonumeropuntos")
	public Long getCantidadPuntos() {
		return cantidadPuntos;
	}
	public void setCantidadPuntos(Long cantidadPuntos) {
		this.cantidadPuntos = cantidadPuntos;
	}
	
	@Column(name="fecha_modificacion")
	public Timestamp getFecha() {
		return fecha;
	}
	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}
	
}
