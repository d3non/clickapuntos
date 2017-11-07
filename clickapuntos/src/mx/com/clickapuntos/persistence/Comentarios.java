package mx.com.clickapuntos.persistence;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Comentarios entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "comentarios", catalog = "clickapuntos")
public class Comentarios implements java.io.Serializable {

	// Fields
	private ComentarioPromoMediaUsuarioId id;
	private Mediapromo mediapromo;
	private Usuarios usuarios;
	private String comentariostexto;
	private String comentariostatus;
	private Integer comentarioreporte;
	private Integer comentariotono;
	private Timestamp fechacomentario;
	// Constructors

	/** default constructor */
	public Comentarios() {
	}

	/** full constructor */
	public Comentarios(Mediapromo mediapromo, Usuarios usuarios,String comentariostexto,
			String comentariostatus, Integer comentarioreporte,
			Integer comentariotono) {
		this.mediapromo = mediapromo;
		this.usuarios = usuarios;
		this.comentariostexto = comentariostexto;
		this.comentariostatus = comentariostatus;
		this.comentarioreporte = comentarioreporte;
		this.comentariotono = comentariotono;
	}

	// Property accessors

	@EmbeddedId
	@AttributeOverrides( {
			@AttributeOverride(name = "comentariosIdComentario", column = @Column(name = "idcomentarios", unique = true, nullable = false)),
			@AttributeOverride(name = "usuariosIdUsuarios", column = @Column(name = "usuarios_idusuarios", nullable = false)),
			@AttributeOverride(name = "mediaIdmedia", column = @Column(name = "mediapromo_media_idmedia", nullable = false)),
			@AttributeOverride(name = "promosIdpromo", column = @Column(name = "mediapromo_promos_idpromo", nullable = false)) })
	public ComentarioPromoMediaUsuarioId getId() {
		return id;
	}
	public void setId(ComentarioPromoMediaUsuarioId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns( {
			@JoinColumn(name = "mediapromo_media_idmedia", referencedColumnName = "media_idmedia",nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "mediapromo_promos_idpromo", referencedColumnName = "promos_idpromo",nullable = false, insertable = false, updatable = false) })
	public Mediapromo getMediapromo() {
		return this.mediapromo;
	}

	public void setMediapromo(Mediapromo mediapromo) {
		this.mediapromo = mediapromo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuarios_idusuarios", nullable = false, insertable = false, updatable = false)
	public Usuarios getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}
	
	@Column(name = "comentariostexto")
	public String getComentariostexto() {
		return this.comentariostexto;
	}

	public void setComentariostexto(String comentariostexto) {
		this.comentariostexto = comentariostexto;
	}

	@Column(name = "comentariostatus", length = 1)
	public String getComentariostatus() {
		return this.comentariostatus;
	}

	public void setComentariostatus(String comentariostatus) {
		this.comentariostatus = comentariostatus;
	}

	@Column(name = "comentarioreporte", length = 11)
	public Integer getComentarioreporte() {
		return this.comentarioreporte;
	}

	public void setComentarioreporte(Integer comentarioreporte) {
		this.comentarioreporte = comentarioreporte;
	}

	@Column(name = "comentariotono", length = 11)
	public Integer getComentariotono() {
		return this.comentariotono;
	}

	public void setComentariotono(Integer comentariotono) {
		this.comentariotono = comentariotono;
	}
	
	@Column
	public Timestamp getFechacomentario() {
		return fechacomentario;
	}
	public void setFechacomentario(Timestamp fechacomentario) {
		this.fechacomentario = fechacomentario;
	}

}