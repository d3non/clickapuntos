package mx.com.clickapuntos.persistence;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Mediapropiedades entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "mediapropiedades", catalog = "clickapuntos")
public class Mediapropiedades implements java.io.Serializable {

	// Fields

	private Integer idclasificacionads;
	private String mpdescripcion;
	private Set<Mediaclasificacion> mediaclasificacions = new HashSet<Mediaclasificacion>(
			0);
	private Set<Usuarioprefencias> usuarioprefenciases = new HashSet<Usuarioprefencias>(
			0);

	// Constructors

	/** default constructor */
	public Mediapropiedades() {
	}

	/** full constructor */
	public Mediapropiedades(String mpdescripcion,
			Set<Mediaclasificacion> mediaclasificacions,
			Set<Usuarioprefencias> usuarioprefenciases) {
		this.mpdescripcion = mpdescripcion;
		this.mediaclasificacions = mediaclasificacions;
		this.usuarioprefenciases = usuarioprefenciases;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idclasificacionads", unique = true, nullable = false)
	public Integer getIdclasificacionads() {
		return this.idclasificacionads;
	}

	public void setIdclasificacionads(Integer idclasificacionads) {
		this.idclasificacionads = idclasificacionads;
	}

	@Column(name = "mpdescripcion", length = 300)
	public String getMpdescripcion() {
		return this.mpdescripcion;
	}

	public void setMpdescripcion(String mpdescripcion) {
		this.mpdescripcion = mpdescripcion;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "mediapropiedades")
	public Set<Mediaclasificacion> getMediaclasificacions() {
		return this.mediaclasificacions;
	}

	public void setMediaclasificacions(
			Set<Mediaclasificacion> mediaclasificacions) {
		this.mediaclasificacions = mediaclasificacions;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "mediapropiedades")
	public Set<Usuarioprefencias> getUsuarioprefenciases() {
		return this.usuarioprefenciases;
	}

	public void setUsuarioprefenciases(
			Set<Usuarioprefencias> usuarioprefenciases) {
		this.usuarioprefenciases = usuarioprefenciases;
	}

}