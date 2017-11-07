package mx.com.clickapuntos.persistence;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Premios entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "premios", catalog = "clickapuntos")
public class Premios implements java.io.Serializable {

	// Fields

	private Integer idpremios;
	private Clientes clientes;
	private Timestamp premiofechacreacion;
	private Timestamp premiofechaautorizacion;
	private Integer premiocantidad;
	private String premiostatus;
	private String premionombre;
	private String premiodescripcion;
	private String premiourlimg;
	private Long premiopuntos;
	private Long idtipopremio;

	// Constructors

	/** default constructor */
	public Premios() {
	}

	/** minimal constructor */
	public Premios(Clientes clientes) {
		this.clientes = clientes;
	}

	/** full constructor */
	public Premios(Clientes clientes, Timestamp premiofechacreacion,
			Timestamp premiofechaautorizacion, Integer premiocantidad,
			String premiostatus, String premionombre, String premiodescripcion,
			String premiourlimg) {
		this.clientes = clientes;
		this.premiofechacreacion = premiofechacreacion;
		this.premiofechaautorizacion = premiofechaautorizacion;
		this.premiocantidad = premiocantidad;
		this.premiostatus = premiostatus;
		this.premionombre = premionombre;
		this.premiodescripcion = premiodescripcion;
		this.premiourlimg = premiourlimg;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idpremios", unique = true, nullable = false)
	public Integer getIdpremios() {
		return this.idpremios;
	}

	public void setIdpremios(Integer idpremios) {
		this.idpremios = idpremios;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "clientes_idcliente", nullable = false)
	public Clientes getClientes() {
		return this.clientes;
	}

	public void setClientes(Clientes clientes) {
		this.clientes = clientes;
	}

	@Column(name = "premiofechacreacion", length = 0)
	public Timestamp getPremiofechacreacion() {
		return this.premiofechacreacion;
	}

	public void setPremiofechacreacion(Timestamp premiofechacreacion) {
		this.premiofechacreacion = premiofechacreacion;
	}

	@Column(name = "premiofechaautorizacion", length = 0)
	public Timestamp getPremiofechaautorizacion() {
		return this.premiofechaautorizacion;
	}

	public void setPremiofechaautorizacion(Timestamp premiofechaautorizacion) {
		this.premiofechaautorizacion = premiofechaautorizacion;
	}

	@Column(name = "premiocantidad")
	public Integer getPremiocantidad() {
		return this.premiocantidad;
	}

	public void setPremiocantidad(Integer premiocantidad) {
		this.premiocantidad = premiocantidad;
	}

	@Column(name = "premiostatus", length = 1)
	public String getPremiostatus() {
		return this.premiostatus;
	}

	public void setPremiostatus(String premiostatus) {
		this.premiostatus = premiostatus;
	}

	@Column(name = "premionombre", length = 59)
	public String getPremionombre() {
		return this.premionombre;
	}

	public void setPremionombre(String premionombre) {
		this.premionombre = premionombre;
	}

	@Column(name = "premiodescripcion", length = 100)
	public String getPremiodescripcion() {
		return this.premiodescripcion;
	}

	public void setPremiodescripcion(String premiodescripcion) {
		this.premiodescripcion = premiodescripcion;
	}

	@Column(name = "premiourlimg", length = 50)
	public String getPremiourlimg() {
		return this.premiourlimg;
	}

	public void setPremiourlimg(String premiourlimg) {
		this.premiourlimg = premiourlimg;
	}

	@Column
	public Long getPremiopuntos() {
		return premiopuntos;
	}

	public void setPremiopuntos(Long premiopuntos) {
		this.premiopuntos = premiopuntos;
	}

	@Column(name="tipopremios_idtipopremios")
	public Long getIdtipopremio() {
		return idtipopremio;
	}

	public void setIdtipopremio(Long idtipopremio) {
		this.idtipopremio = idtipopremio;
	}
	
	
	
}