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
 * Usuariotipo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "usuariotipo", catalog = "clickapuntos")
public class Usuariotipo implements java.io.Serializable {

	// Fields

	private Integer idusuariotipo;
	private String utdescripcion;
	private Set<Usuarios> usuarioses = new HashSet<Usuarios>(0);

	// Constructors

	/** default constructor */
	public Usuariotipo() {
	}

	/** full constructor */
	public Usuariotipo(String utdescripcion, Set<Usuarios> usuarioses) {
		this.utdescripcion = utdescripcion;
		this.usuarioses = usuarioses;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idusuariotipo", unique = true, nullable = false)
	public Integer getIdusuariotipo() {
		return this.idusuariotipo;
	}

	public void setIdusuariotipo(Integer idusuariotipo) {
		this.idusuariotipo = idusuariotipo;
	}

	@Column(name = "utdescripcion", length = 50)
	public String getUtdescripcion() {
		return this.utdescripcion;
	}

	public void setUtdescripcion(String utdescripcion) {
		this.utdescripcion = utdescripcion;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usuariotipo")
	public Set<Usuarios> getUsuarioses() {
		return this.usuarioses;
	}

	public void setUsuarioses(Set<Usuarios> usuarioses) {
		this.usuarioses = usuarioses;
	}

}