package mx.com.clickapuntos.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Premiotipo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "premiotipo", catalog = "clickapuntos")
public class Premiotipo implements java.io.Serializable {

	// Fields

	private Integer idpremiotipo;
	private String premionombre;
	private String premiodescripcion;
	private String premiourlimage;

	// Constructors

	/** default constructor */
	public Premiotipo() {
	}

	/** minimal constructor */
	public Premiotipo(Integer idpremiotipo) {
		this.idpremiotipo = idpremiotipo;
	}

	/** full constructor */
	public Premiotipo(Integer idpremiotipo, String premionombre,
			String premiodescripcion, String premiourlimage) {
		this.idpremiotipo = idpremiotipo;
		this.premionombre = premionombre;
		this.premiodescripcion = premiodescripcion;
		this.premiourlimage = premiourlimage;
	}

	// Property accessors
	@Id
	@Column(name = "idpremiotipo", unique = true, nullable = false)
	public Integer getIdpremiotipo() {
		return this.idpremiotipo;
	}

	public void setIdpremiotipo(Integer idpremiotipo) {
		this.idpremiotipo = idpremiotipo;
	}

	@Column(name = "premionombre", length = 45)
	public String getPremionombre() {
		return this.premionombre;
	}

	public void setPremionombre(String premionombre) {
		this.premionombre = premionombre;
	}

	@Column(name = "premiodescripcion", length = 200)
	public String getPremiodescripcion() {
		return this.premiodescripcion;
	}

	public void setPremiodescripcion(String premiodescripcion) {
		this.premiodescripcion = premiodescripcion;
	}

	@Column(name = "premiourlimage", length = 45)
	public String getPremiourlimage() {
		return this.premiourlimage;
	}

	public void setPremiourlimage(String premiourlimage) {
		this.premiourlimage = premiourlimage;
	}

}