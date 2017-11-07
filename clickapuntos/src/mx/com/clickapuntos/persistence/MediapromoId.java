package mx.com.clickapuntos.persistence;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * MediapromoId entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Embeddable
public class MediapromoId implements java.io.Serializable {

	// Fields

	private Integer mediaIdmedia;
	private Integer promosIdpromo;

	// Constructors

	/** default constructor */
	public MediapromoId() {
	}

	/** full constructor */
	public MediapromoId(Integer mediaIdmedia, Integer promosIdpromo) {
		this.mediaIdmedia = mediaIdmedia;
		this.promosIdpromo = promosIdpromo;
	}

	// Property accessors

	@Column(name = "media_idmedia", nullable = false)
	public Integer getMediaIdmedia() {
		return this.mediaIdmedia;
	}

	public void setMediaIdmedia(Integer mediaIdmedia) {
		this.mediaIdmedia = mediaIdmedia;
	}

	@Column(name = "promos_idpromo", nullable = false)
	public Integer getPromosIdpromo() {
		return this.promosIdpromo;
	}

	public void setPromosIdpromo(Integer promosIdpromo) {
		this.promosIdpromo = promosIdpromo;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof MediapromoId))
			return false;
		MediapromoId castOther = (MediapromoId) other;

		return ((this.getMediaIdmedia() == castOther.getMediaIdmedia()) || (this
				.getMediaIdmedia() != null
				&& castOther.getMediaIdmedia() != null && this
				.getMediaIdmedia().equals(castOther.getMediaIdmedia())))
				&& ((this.getPromosIdpromo() == castOther.getPromosIdpromo()) || (this
						.getPromosIdpromo() != null
						&& castOther.getPromosIdpromo() != null && this
						.getPromosIdpromo()
						.equals(castOther.getPromosIdpromo())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getMediaIdmedia() == null ? 0 : this.getMediaIdmedia()
						.hashCode());
		result = 37
				* result
				+ (getPromosIdpromo() == null ? 0 : this.getPromosIdpromo()
						.hashCode());
		return result;
	}

}