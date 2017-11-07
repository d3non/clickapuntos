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
 * Usuarioproperties entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "usuarioproperties", catalog = "clickapuntos")
public class Usuarioproperties implements java.io.Serializable {

	// Fields

	private Integer idusuarioproperties;
	private String upcampo;
	private String upvalor;
	private String upfuente;
	private Set<Usuarios> usuarioses = new HashSet<Usuarios>(0);

	// Constructors

	/** default constructor */
	public Usuarioproperties() {
	}

	/** full constructor */
	public Usuarioproperties(String upcampo, String upvalor, String upfuente,
			Set<Usuarios> usuarioses) {
		this.upcampo = upcampo;
		this.upvalor = upvalor;
		this.upfuente = upfuente;
		this.usuarioses = usuarioses;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idusuarioproperties", unique = true, nullable = false)
	public Integer getIdusuarioproperties() {
		return this.idusuarioproperties;
	}

	public void setIdusuarioproperties(Integer idusuarioproperties) {
		this.idusuarioproperties = idusuarioproperties;
	}

	@Column(name = "upcampo", length = 90)
	public String getUpcampo() {
		return this.upcampo;
	}

	public void setUpcampo(String upcampo) {
		this.upcampo = upcampo;
	}

	@Column(name = "upvalor", length = 90)
	public String getUpvalor() {
		return this.upvalor;
	}

	public void setUpvalor(String upvalor) {
		this.upvalor = upvalor;
	}

	@Column(name = "upfuente", length = 45)
	public String getUpfuente() {
		return this.upfuente;
	}

	public void setUpfuente(String upfuente) {
		this.upfuente = upfuente;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usuarioproperties")
	public Set<Usuarios> getUsuarioses() {
		return this.usuarioses;
	}

	public void setUsuarioses(Set<Usuarios> usuarioses) {
		this.usuarioses = usuarioses;
	}

}