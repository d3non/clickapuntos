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
 * Mediausuario entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "mediausuario", catalog = "clickapuntos")
public class Mediausuario implements java.io.Serializable {

	// Fields

	private MediausuarioId id;
	private Usuarios usuarios;
	private Media media;
	private Integer mediausuarionumreproduccion;
	private Integer mediausuarioclick;
	private String mediausuariolike;
	private String mediausuariofavoritos;

	// Constructors

	/** default constructor */
	public Mediausuario() {
	}

	/** minimal constructor */
	public Mediausuario(MediausuarioId id, Usuarios usuarios, Media media) {
		this.id = id;
		this.usuarios = usuarios;
		this.media = media;
	}

	/** full constructor */
	public Mediausuario(MediausuarioId id, Usuarios usuarios, Media media,
			Integer mediausuarionumreproduccion, Integer mediausuarioclick,
			String mediausuariolike, String mediausuariofavoritos) {
		this.id = id;
		this.usuarios = usuarios;
		this.media = media;
		this.mediausuarionumreproduccion = mediausuarionumreproduccion;
		this.mediausuarioclick = mediausuarioclick;
		this.mediausuariolike = mediausuariolike;
		this.mediausuariofavoritos = mediausuariofavoritos;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides( {
			@AttributeOverride(name = "usuariosIdusuarios", column = @Column(name = "usuarios_idusuarios", nullable = false)),
			@AttributeOverride(name = "mediaIdmedia", column = @Column(name = "media_idmedia", nullable = false)) })
	public MediausuarioId getId() {
		return this.id;
	}

	public void setId(MediausuarioId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuarios_idusuarios", nullable = false, insertable = false, updatable = false)
	public Usuarios getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "media_idmedia", nullable = false, insertable = false, updatable = false)
	public Media getMedia() {
		return this.media;
	}

	public void setMedia(Media media) {
		this.media = media;
	}

	@Column(name = "mediausuarionumreproduccion")
	public Integer getMediausuarionumreproduccion() {
		return this.mediausuarionumreproduccion;
	}

	public void setMediausuarionumreproduccion(
			Integer mediausuarionumreproduccion) {
		this.mediausuarionumreproduccion = mediausuarionumreproduccion;
	}

	@Column(name = "mediausuarioclick")
	public Integer getMediausuarioclick() {
		return this.mediausuarioclick;
	}

	public void setMediausuarioclick(Integer mediausuarioclick) {
		this.mediausuarioclick = mediausuarioclick;
	}

	@Column(name = "mediausuariolike", length = 1)
	public String getMediausuariolike() {
		return this.mediausuariolike;
	}

	public void setMediausuariolike(String mediausuariolike) {
		this.mediausuariolike = mediausuariolike;
	}

	@Column(name = "mediausuariofavoritos", length = 1)
	public String getMediausuariofavoritos() {
		return this.mediausuariofavoritos;
	}

	public void setMediausuariofavoritos(String mediausuariofavoritos) {
		this.mediausuariofavoritos = mediausuariofavoritos;
	}

}