package mx.com.clickapuntos.persistence;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import static javax.persistence.GenerationType.IDENTITY;
import  javax.persistence.GeneratedValue;

@SuppressWarnings("serial")
@Entity
@Table(name = "tipomensaje", catalog = "clickapuntos")
public class TipoMensaje implements Serializable {
	private Long id;
	private String descripcion;
	
	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="idtipomensaje",unique=true,nullable=false)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="tipomensajedescripcion")
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
