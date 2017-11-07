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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Media entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "media", catalog = "clickapuntos")
public class Media implements java.io.Serializable {

	// Fields

	private Integer idmedia;
	private Mediatipo mediatipo;
	private String mediaurl;
	private Integer mediaidpadre;
	private Set<Mediapromo> mediapromos = new HashSet<Mediapromo>(0);
	private Set<Mediaclasificacion> mediaclasificacions = new HashSet<Mediaclasificacion>(
			0);
	private Set<Mediausuario> mediausuarios = new HashSet<Mediausuario>(0);

	// Constructors

	/** default constructor */
	public Media() {
	}

	/** minimal constructor */
	public Media(Mediatipo mediatipo) {
		this.mediatipo = mediatipo;
	}

	/** full constructor */
	public Media(Mediatipo mediatipo, String mediaurl, Integer mediaidpadre,
			Set<Mediapromo> mediapromos,
			Set<Mediaclasificacion> mediaclasificacions) {
		this.mediatipo = mediatipo;
		this.mediaurl = mediaurl;
		this.mediaidpadre = mediaidpadre;
		this.mediapromos = mediapromos;
		this.mediaclasificacions = mediaclasificacions;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idmedia", unique = true, nullable = false)
	public Integer getIdmedia() {
		return this.idmedia;
	}

	public void setIdmedia(Integer idmedia) {
		this.idmedia = idmedia;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mediatipo_idmediatipo", nullable = false)
	public Mediatipo getMediatipo() {
		return this.mediatipo;
	}

	public void setMediatipo(Mediatipo mediatipo) {
		this.mediatipo = mediatipo;
	}

	@Column(name = "mediaurl", length = 150)
	public String getMediaurl() {
		return this.mediaurl;
	}

	public void setMediaurl(String mediaurl) {
		this.mediaurl = mediaurl;
	}

	@Column(name = "mediaidpadre")
	public Integer getMediaidpadre() {
		return this.mediaidpadre;
	}

	public void setMediaidpadre(Integer mediaidpadre) {
		this.mediaidpadre = mediaidpadre;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "media")
	public Set<Mediapromo> getMediapromos() {
		return this.mediapromos;
	}

	public void setMediapromos(Set<Mediapromo> mediapromos) {
		this.mediapromos = mediapromos;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "media")
	public Set<Mediaclasificacion> getMediaclasificacions() {
		return this.mediaclasificacions;
	}

	public void setMediaclasificacions(
			Set<Mediaclasificacion> mediaclasificacions) {
		this.mediaclasificacions = mediaclasificacions;
	}

	

}