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
 * Clientes entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "clientes", catalog = "clickapuntos")
public class Clientes implements java.io.Serializable {

	// Fields

	private Integer idcliente;
	private String clientenombre;
	private String clientestatus;
	private String clienterazonsocial;
	private String clienterfc;
	private String clienteimagen;
	private Set<Usuarios> usuarioses = new HashSet<Usuarios>(0);
	private Set<Promos> promoses = new HashSet<Promos>(0);
	private Set<Premios> premioses = new HashSet<Premios>(0);
	private Set<Clientesdirecciones> clientesdireccioneses = new HashSet<Clientesdirecciones>(
			0);

	// Constructors

	/** default constructor */
	public Clientes() {
	}

	/** full constructor */
	public Clientes(String clientenombre, String clientestatus,
			String clienterazonsocial, String clienterfc, String clienteimagen,
			Set<Usuarios> usuarioses, Set<Promos> promoses,
			Set<Premios> premioses,
			Set<Clientesdirecciones> clientesdireccioneses) {
		this.clientenombre = clientenombre;
		this.clientestatus = clientestatus;
		this.clienterazonsocial = clienterazonsocial;
		this.clienterfc = clienterfc;
		this.clienteimagen = clienteimagen;
		this.usuarioses = usuarioses;
		this.promoses = promoses;
		this.premioses = premioses;
		this.clientesdireccioneses = clientesdireccioneses;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idcliente", unique = true, nullable = false)
	public Integer getIdcliente() {
		return this.idcliente;
	}

	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
	}

	@Column(name = "clientenombre", length = 90)
	public String getClientenombre() {
		return this.clientenombre;
	}

	public void setClientenombre(String clientenombre) {
		this.clientenombre = clientenombre;
	}

	@Column(name = "clientestatus", length = 1)
	public String getClientestatus() {
		return this.clientestatus;
	}

	public void setClientestatus(String clientestatus) {
		this.clientestatus = clientestatus;
	}

	@Column(name = "clienterazonsocial", length = 200)
	public String getClienterazonsocial() {
		return this.clienterazonsocial;
	}

	public void setClienterazonsocial(String clienterazonsocial) {
		this.clienterazonsocial = clienterazonsocial;
	}

	@Column(name = "clienterfc", length = 45)
	public String getClienterfc() {
		return this.clienterfc;
	}

	public void setClienterfc(String clienterfc) {
		this.clienterfc = clienterfc;
	}

	@Column(name = "clienteimagen", length = 90)
	public String getClienteimagen() {
		return this.clienteimagen;
	}

	public void setClienteimagen(String clienteimagen) {
		this.clienteimagen = clienteimagen;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "clientes")
	public Set<Usuarios> getUsuarioses() {
		return this.usuarioses;
	}

	public void setUsuarioses(Set<Usuarios> usuarioses) {
		this.usuarioses = usuarioses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "clientes")
	public Set<Promos> getPromoses() {
		return this.promoses;
	}

	public void setPromoses(Set<Promos> promoses) {
		this.promoses = promoses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "clientes")
	public Set<Premios> getPremioses() {
		return this.premioses;
	}

	public void setPremioses(Set<Premios> premioses) {
		this.premioses = premioses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "clientes")
	public Set<Clientesdirecciones> getClientesdireccioneses() {
		return this.clientesdireccioneses;
	}

	public void setClientesdireccioneses(
			Set<Clientesdirecciones> clientesdireccioneses) {
		this.clientesdireccioneses = clientesdireccioneses;
	}

}