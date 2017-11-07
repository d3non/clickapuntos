package mx.com.clickapuntos.persistence;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Date;
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
 * Usuariosdatos entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "usuariosdatos", catalog = "clickapuntos")
public class Usuariosdatos implements java.io.Serializable {

	// Fields

	private Integer idusuarios;
	private String usrnombres;
	private String usrapaterno;
	private String usramaterno;
	private Set<Usuarios> usuarioses = new HashSet<Usuarios>(0);
	private Date fechaNacimiento;

	// Constructors

	/** default constructor */
	public Usuariosdatos() {
	}

	/** full constructor */
	public Usuariosdatos(String usrnombres, String usrapaterno,
			String usramaterno, Set<Usuarios> usuarioses) {
		this.usrnombres = usrnombres;
		this.usrapaterno = usrapaterno;
		this.usramaterno = usramaterno;
		this.usuarioses = usuarioses;
	}

	// Property accessors
	@Id
	@Column(name = "idusuarios", unique = true, nullable = false)
	public Integer getIdusuarios() {
		return this.idusuarios;
	}

	public void setIdusuarios(Integer idusuarios) {
		this.idusuarios = idusuarios;
	}

	@Column(name = "usrnombres", length = 50)
	public String getUsrnombres() {
		return this.usrnombres;
	}

	public void setUsrnombres(String usrnombres) {
		this.usrnombres = usrnombres;
	}

	@Column(name = "usrapaterno", length = 50)
	public String getUsrapaterno() {
		return this.usrapaterno;
	}

	public void setUsrapaterno(String usrapaterno) {
		this.usrapaterno = usrapaterno;
	}

	@Column(name = "usramaterno", length = 50)
	public String getUsramaterno() {
		return this.usramaterno;
	}

	public void setUsramaterno(String usramaterno) {
		this.usramaterno = usramaterno;
	}
	
	@Column(name="usrfechanacimiento")
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usuariosdatos")
	public Set<Usuarios> getUsuarioses() {
		return this.usuarioses;
	}

	public void setUsuarioses(Set<Usuarios> usuarioses) {
		this.usuarioses = usuarioses;
	}

}