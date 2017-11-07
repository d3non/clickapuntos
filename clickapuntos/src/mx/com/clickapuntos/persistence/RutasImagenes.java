package mx.com.clickapuntos.persistence;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table(name = "rutasimagenes", catalog = "clickapuntos")
public class RutasImagenes implements Serializable {
	private Long id;
	private String tipo;
	private String ruta;
	
	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="idruta_imagenes",nullable=false)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="tipo_imagenes")
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	@Column(name="ruta_imagenes")
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	
}
