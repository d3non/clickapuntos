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
 * Promotipomecanica entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "promotipomecanica", catalog = "clickapuntos")
public class Promotipomecanica implements java.io.Serializable {

	// Fields

	private Integer idpromotipomecanica;
	private String promotipomecanicadescripcion;
	private Integer promomecanicavalor;
	private Set<Promos> promoses = new HashSet<Promos>(0);

	// Constructors

	/** default constructor */
	public Promotipomecanica() {
	}

	/** full constructor */
	public Promotipomecanica(String promotipomecanicadescripcion,
			Integer promomecanicavalor, Set<Promos> promoses) {
		this.promotipomecanicadescripcion = promotipomecanicadescripcion;
		this.promomecanicavalor = promomecanicavalor;
		this.promoses = promoses;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idpromotipomecanica", unique = true, nullable = false)
	public Integer getIdpromotipomecanica() {
		return this.idpromotipomecanica;
	}

	public void setIdpromotipomecanica(Integer idpromotipomecanica) {
		this.idpromotipomecanica = idpromotipomecanica;
	}

	@Column(name = "promotipomecanicadescripcion", length = 45)
	public String getPromotipomecanicadescripcion() {
		return this.promotipomecanicadescripcion;
	}

	public void setPromotipomecanicadescripcion(
			String promotipomecanicadescripcion) {
		this.promotipomecanicadescripcion = promotipomecanicadescripcion;
	}

	@Column(name = "promomecanicavalor")
	public Integer getPromomecanicavalor() {
		return this.promomecanicavalor;
	}

	public void setPromomecanicavalor(Integer promomecanicavalor) {
		this.promomecanicavalor = promomecanicavalor;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "promotipomecanica")
	public Set<Promos> getPromoses() {
		return this.promoses;
	}

	public void setPromoses(Set<Promos> promoses) {
		this.promoses = promoses;
	}

}