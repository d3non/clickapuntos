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
 * Usuarioprefencias entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "usuarioprefencias", catalog = "clickapuntos")
public class Usuarioprefencias implements java.io.Serializable {

	// Fields

	private UsuarioprefenciasId id;
	private Mediapropiedades mediapropiedades;
	private Usuarios usuarios;

	// Constructors

	/** default constructor */
	public Usuarioprefencias() {
	}

	/** full constructor */
	public Usuarioprefencias(UsuarioprefenciasId id,
			Mediapropiedades mediapropiedades, Usuarios usuarios) {
		this.id = id;
		this.mediapropiedades = mediapropiedades;
		this.usuarios = usuarios;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides( {
			@AttributeOverride(name = "usuariosIdusuarios", column = @Column(name = "usuarios_idusuarios", nullable = false)),
			@AttributeOverride(name = "mediapropiedadesIdclasificacionads", column = @Column(name = "mediapropiedades_idclasificacionads", nullable = false)) })
	public UsuarioprefenciasId getId() {
		return this.id;
	}

	public void setId(UsuarioprefenciasId id) {
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
	@JoinColumn(name = "usuarios_idusuarios", nullable = false, insertable = false, updatable = false)
	public Usuarios getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}

}