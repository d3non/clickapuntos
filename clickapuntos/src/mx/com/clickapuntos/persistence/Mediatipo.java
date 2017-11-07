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
 * Mediatipo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "mediatipo", catalog = "clickapuntos")
public class Mediatipo implements java.io.Serializable {

	// Fields

	private Integer idmediatipo;
	private String mediatipodescripcion;
	private Set<Media> medias = new HashSet<Media>(0);

	// Constructors

	/** default constructor */
	public Mediatipo() {
	}

	/** full constructor */
	public Mediatipo(String mediatipodescripcion, Set<Media> medias) {
		this.mediatipodescripcion = mediatipodescripcion;
		this.medias = medias;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idmediatipo", unique = true, nullable = false)
	public Integer getIdmediatipo() {
		return this.idmediatipo;
	}

	public void setIdmediatipo(Integer idmediatipo) {
		this.idmediatipo = idmediatipo;
	}

	@Column(name = "mediatipodescripcion", length = 45)
	public String getMediatipodescripcion() {
		return this.mediatipodescripcion;
	}

	public void setMediatipodescripcion(String mediatipodescripcion) {
		this.mediatipodescripcion = mediatipodescripcion;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "mediatipo")
	public Set<Media> getMedias() {
		return this.medias;
	}

	public void setMedias(Set<Media> medias) {
		this.medias = medias;
	}

}