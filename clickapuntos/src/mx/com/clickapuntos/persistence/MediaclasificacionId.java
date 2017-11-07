package mx.com.clickapuntos.persistence;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * MediaclasificacionId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class MediaclasificacionId implements java.io.Serializable {

	// Fields

	private Integer mediapropiedadesIdclasificacionads;
	private Integer mediaIdmedia;

	// Constructors

	/** default constructor */
	public MediaclasificacionId() {
	}

	/** full constructor */
	public MediaclasificacionId(Integer mediapropiedadesIdclasificacionads,
			Integer mediaIdmedia) {
		this.mediapropiedadesIdclasificacionads = mediapropiedadesIdclasificacionads;
		this.mediaIdmedia = mediaIdmedia;
	}

	// Property accessors

	@Column(name = "mediapropiedades_idclasificacionads", nullable = false)
	public Integer getMediapropiedadesIdclasificacionads() {
		return this.mediapropiedadesIdclasificacionads;
	}

	public void setMediapropiedadesIdclasificacionads(
			Integer mediapropiedadesIdclasificacionads) {
		this.mediapropiedadesIdclasificacionads = mediapropiedadesIdclasificacionads;
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
		if (!(other instanceof MediaclasificacionId))
			return false;
		MediaclasificacionId castOther = (MediaclasificacionId) other;

		return ((this.getMediapropiedadesIdclasificacionads() == castOther
				.getMediapropiedadesIdclasificacionads()) || (this
				.getMediapropiedadesIdclasificacionads() != null
				&& castOther.getMediapropiedadesIdclasificacionads() != null && this
				.getMediapropiedadesIdclasificacionads().equals(
						castOther.getMediapropiedadesIdclasificacionads())))
				&& ((this.getMediaIdmedia() == castOther.getMediaIdmedia()) || (this
						.getMediaIdmedia() != null
						&& castOther.getMediaIdmedia() != null && this
						.getMediaIdmedia().equals(castOther.getMediaIdmedia())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getMediapropiedadesIdclasificacionads() == null ? 0 : this
						.getMediapropiedadesIdclasificacionads().hashCode());
		result = 37
				* result
				+ (getMediaIdmedia() == null ? 0 : this.getMediaIdmedia()
						.hashCode());
		return result;
	}

}