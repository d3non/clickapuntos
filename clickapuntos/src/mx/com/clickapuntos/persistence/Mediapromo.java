package mx.com.clickapuntos.persistence;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Mediapromo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "mediapromo", catalog = "clickapuntos")
public class Mediapromo implements java.io.Serializable {

	// Fields

	private MediapromoId id;
	private Promos promos;
	private Media media;
	private Set<Comentarios> comentarioses = new HashSet<Comentarios>(0);

	// Constructors

	/** default constructor */
	public Mediapromo() {
	}

	/** minimal constructor */
	public Mediapromo(MediapromoId id, Promos promos, Media media) {
		this.id = id;
		this.promos = promos;
		this.media = media;
	}

	/** full constructor */
	public Mediapromo(MediapromoId id, Promos promos, Media media,
			Set<Comentarios> comentarioses) {
		this.id = id;
		this.promos = promos;
		this.media = media;
		this.comentarioses = comentarioses;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides( {
			@AttributeOverride(name = "mediaIdmedia", column = @Column(name = "media_idmedia", nullable = false)),
			@AttributeOverride(name = "promosIdpromo", column = @Column(name = "promos_idpromo", nullable = false)) })
	public MediapromoId getId() {
		return this.id;
	}

	public void setId(MediapromoId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "promos_idpromo", nullable = false, insertable = false, updatable = false)
	public Promos getPromos() {
		return this.promos;
	}

	public void setPromos(Promos promos) {
		this.promos = promos;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "media_idmedia", nullable = false, insertable = false, updatable = false)
	public Media getMedia() {
		return this.media;
	}

	public void setMedia(Media media) {
		this.media = media;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "mediapromo")
	public Set<Comentarios> getComentarioses() {
		return this.comentarioses;
	}

	public void setComentarioses(Set<Comentarios> comentarioses) {
		this.comentarioses = comentarioses;
	}

}