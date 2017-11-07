package mx.com.clickapuntos.persistence;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * UsuarioprefenciasId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class UsuarioprefenciasId implements java.io.Serializable {

	// Fields

	private Integer usuariosIdusuarios;
	private Integer mediapropiedadesIdclasificacionads;

	// Constructors

	/** default constructor */
	public UsuarioprefenciasId() {
	}

	/** full constructor */
	public UsuarioprefenciasId(Integer usuariosIdusuarios,
			Integer mediapropiedadesIdclasificacionads) {
		this.usuariosIdusuarios = usuariosIdusuarios;
		this.mediapropiedadesIdclasificacionads = mediapropiedadesIdclasificacionads;
	}

	// Property accessors

	@Column(name = "usuarios_idusuarios", nullable = false)
	public Integer getUsuariosIdusuarios() {
		return this.usuariosIdusuarios;
	}

	public void setUsuariosIdusuarios(Integer usuariosIdusuarios) {
		this.usuariosIdusuarios = usuariosIdusuarios;
	}

	@Column(name = "mediapropiedades_idclasificacionads", nullable = false)
	public Integer getMediapropiedadesIdclasificacionads() {
		return this.mediapropiedadesIdclasificacionads;
	}

	public void setMediapropiedadesIdclasificacionads(
			Integer mediapropiedadesIdclasificacionads) {
		this.mediapropiedadesIdclasificacionads = mediapropiedadesIdclasificacionads;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UsuarioprefenciasId))
			return false;
		UsuarioprefenciasId castOther = (UsuarioprefenciasId) other;

		return ((this.getUsuariosIdusuarios() == castOther
				.getUsuariosIdusuarios()) || (this.getUsuariosIdusuarios() != null
				&& castOther.getUsuariosIdusuarios() != null && this
				.getUsuariosIdusuarios().equals(
						castOther.getUsuariosIdusuarios())))
				&& ((this.getMediapropiedadesIdclasificacionads() == castOther
						.getMediapropiedadesIdclasificacionads()) || (this
						.getMediapropiedadesIdclasificacionads() != null
						&& castOther.getMediapropiedadesIdclasificacionads() != null && this
						.getMediapropiedadesIdclasificacionads()
						.equals(
								castOther
										.getMediapropiedadesIdclasificacionads())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getUsuariosIdusuarios() == null ? 0 : this
						.getUsuariosIdusuarios().hashCode());
		result = 37
				* result
				+ (getMediapropiedadesIdclasificacionads() == null ? 0 : this
						.getMediapropiedadesIdclasificacionads().hashCode());
		return result;
	}

}