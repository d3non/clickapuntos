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
 * Promotipocobro entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "promotipocobro", catalog = "clickapuntos")
public class Promotipocobro implements java.io.Serializable {

	// Fields

	private Integer idpromotipodescripcion;
	private String promotipocobrodescripcion;
	private Integer promotipocobrovalor;
	private Set<Promos> promoses = new HashSet<Promos>(0);

	// Constructors

	/** default constructor */
	public Promotipocobro() {
	}

	/** full constructor */
	public Promotipocobro(String promotipocobrodescripcion,
			Integer promotipocobrovalor, Set<Promos> promoses) {
		this.promotipocobrodescripcion = promotipocobrodescripcion;
		this.promotipocobrovalor = promotipocobrovalor;
		this.promoses = promoses;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idpromotipodescripcion", unique = true, nullable = false)
	public Integer getIdpromotipodescripcion() {
		return this.idpromotipodescripcion;
	}

	public void setIdpromotipodescripcion(Integer idpromotipodescripcion) {
		this.idpromotipodescripcion = idpromotipodescripcion;
	}

	@Column(name = "promotipocobrodescripcion", length = 45)
	public String getPromotipocobrodescripcion() {
		return this.promotipocobrodescripcion;
	}

	public void setPromotipocobrodescripcion(String promotipocobrodescripcion) {
		this.promotipocobrodescripcion = promotipocobrodescripcion;
	}

	@Column(name = "promotipocobrovalor")
	public Integer getPromotipocobrovalor() {
		return this.promotipocobrovalor;
	}

	public void setPromotipocobrovalor(Integer promotipocobrovalor) {
		this.promotipocobrovalor = promotipocobrovalor;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "promotipocobro")
	public Set<Promos> getPromoses() {
		return this.promoses;
	}

	public void setPromoses(Set<Promos> promoses) {
		this.promoses = promoses;
	}

}