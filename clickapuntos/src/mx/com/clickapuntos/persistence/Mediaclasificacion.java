package mx.com.clickapuntos.persistence;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Mediaclasificacion entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "mediaclasificacion", catalog = "clickapuntos")
public class Mediaclasificacion implements java.io.Serializable {

	// Fields

	private MediaclasificacionId id;
	private Mediapropiedades mediapropiedades;
	private Media media;

	// Constructors

	/** default constructor */
	public Mediaclasificacion() {
	}

	/** full constructor */
	public Mediaclasificacion(MediaclasificacionId id,
			Mediapropiedades mediapropiedades, Media media) {
		this.id = id;
		this.mediapropiedades = mediapropiedades;
		this.media = media;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides( {
			@AttributeOverride(name = "mediapropiedadesIdclasificacionads", column = @Column(name = "mediapropiedades_idclasificacionads", nullable = false)),
			@AttributeOverride(name = "mediaIdmedia", column = @Column(name = "media_idmedia", nullable = false)) })
	public MediaclasificacionId getId() {
		return this.id;
	}

	public void setId(MediaclasificacionId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mediapropiedades_idclasificacionads", nullable = false, insertable = false, updatable = false)
	public Mediapropiedades getMediapropiedades() {
		return this.mediapropiedades;
	}

	public void setMediapropiedades(Mediapropiedades mediapropiedades) {
		this.mediapropiedades = mediapropiedades;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "media_idmedia", nullable = false, insertable = false, updatable = false)
	public Media getMedia() {
		return this.media;
	}

	public void setMedia(Media media) {
		this.media = media;
	}

}