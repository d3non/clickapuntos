package mx.com.clickapuntos.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.GeneratedValue;

@Entity
@Table(name = "tipopago", catalog = "clickapuntos")
public class TipoPago implements Serializable{
	private Long id;
	private String descripcion;
	
	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name = "idtipopago", nullable = false)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "tipopagodescripcion", nullable = false)
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
