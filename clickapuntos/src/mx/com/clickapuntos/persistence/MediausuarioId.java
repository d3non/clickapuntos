package mx.com.clickapuntos.persistence;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * MediausuarioId entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Embeddable
public class MediausuarioId implements java.io.Serializable {

	// Fields

	private Integer usuariosIdusuarios;
	private Integer mediaIdmedia;

	// Constructors

	/** default constructor */
	public MediausuarioId() {
	}

	/** full constructor */
	public MediausuarioId(Integer usuariosIdusuarios, Integer mediaIdmedia) {
		this.usuariosIdusuarios = usuariosIdusuarios;
		this.mediaIdmedia = mediaIdmedia;
	}

	// Property accessors

	@Column(name = "usuarios_idusuarios", nullable = false)
	public Integer getUsuariosIdusuarios() {
		return this.usuariosIdusuarios;
	}

	public void setUsuariosIdusuarios(Integer usuariosIdusuarios) {
		this.usuariosIdusuarios = usuariosIdusuarios;
	}

	@Column(name = "media_idmedia", nullable = false)
	public Integer getMediaIdmedia() {
		return this.mediaIdmedia;
	}

	public void setMediaIdmedia(Integer mediaIdmedia) {
		this.mediaIdmedia = mediaIdmedia;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof MediausuarioId))
			return false;
		MediausuarioId castOther = (MediausuarioId) other;

		return ((this.getUsuariosIdusuarios() == castOther
				.getUsuariosIdusuarios()) || (this.getUsuariosIdusuarios() != null
				&& castOther.getUsuariosIdusuarios() != null && this
				.getUsuariosIdusuarios().equals(
						castOther.getUsuariosIdusuarios())))
				&& ((this.getMediaIdmedia() == castOther.getMediaIdmedia()) || (this
						.getMediaIdmedia() != null
						&& castOther.getMediaIdmedia() != null && this
						.getMediaIdmedia().equals(castOther.getMediaIdmedia())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getUsuariosIdusuarios() == null ? 0 : this
						.getUsuariosIdusuarios().hashCode());
		result = 37
				* result
				+ (getMediaIdmedia() == null ? 0 : this.getMediaIdmedia()
						.hashCode());
		return result;
	}

}