package mx.com.clickapuntos.persistence;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clientesdirecciones entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "clientesdirecciones", catalog = "clickapuntos")
public class Clientesdirecciones implements java.io.Serializable {

	// Fields

	private Integer idclientesdirecciones;
	private Clientes clientes;
	private String cdcalle;
	private String cdnumero;
	private String cdcolonia;
	private String cddelmpio;
	private String cdciudad;
	private String cdcodigopostal;
	private String cdnumerocontacto;
	private String cdnumerocel;

	// Constructors

	/** default constructor */
	public Clientesdirecciones() {
	}

	/** minimal constructor */
	public Clientesdirecciones(Clientes clientes) {
		this.clientes = clientes;
	}

	/** full constructor */
	public Clientesdirecciones(Clientes clientes, String cdcalle,
			String cdnumero, String cdcolonia, String cddelmpio,
			String cdciudad, String cdcodigopostal, String cdnumerocontacto,
			String cdnumerocel) {
		this.clientes = clientes;
		this.cdcalle = cdcalle;
		this.cdnumero = cdnumero;
		this.cdcolonia = cdcolonia;
		this.cddelmpio = cddelmpio;
		this.cdciudad = cdciudad;
		this.cdcodigopostal = cdcodigopostal;
		this.cdnumerocontacto = cdnumerocontacto;
		this.cdnumerocel = cdnumerocel;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idclientesdirecciones", unique = true, nullable = false)
	public Integer getIdclientesdirecciones() {
		return this.idclientesdirecciones;
	}

	public void setIdclientesdirecciones(Integer idclientesdirecciones) {
		this.idclientesdirecciones = idclientesdirecciones;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clientes_idcliente", nullable = false)
	public Clientes getClientes() {
		return this.clientes;
	}

	public void setClientes(Clientes clientes) {
		this.clientes = clientes;
	}

	@Column(name = "cdcalle", length = 90)
	public String getCdcalle() {
		return this.cdcalle;
	}

	public void setCdcalle(String cdcalle) {
		this.cdcalle = cdcalle;
	}

	@Column(name = "cdnumero", length = 5)
	public String getCdnumero() {
		return this.cdnumero;
	}

	public void setCdnumero(String cdnumero) {
		this.cdnumero = cdnumero;
	}

	@Column(name = "cdcolonia", length = 150)
	public String getCdcolonia() {
		return this.cdcolonia;
	}

	public void setCdcolonia(String cdcolonia) {
		this.cdcolonia = cdcolonia;
	}

	@Column(name = "cddelmpio", length = 90)
	public String getCddelmpio() {
		return this.cddelmpio;
	}

	public void setCddelmpio(String cddelmpio) {
		this.cddelmpio = cddelmpio;
	}

	@Column(name = "cdciudad", length = 90)
	public String getCdciudad() {
		return this.cdciudad;
	}

	public void setCdciudad(String cdciudad) {
		this.cdciudad = cdciudad;
	}

	@Column(name = "cdcodigopostal", length = 10)
	public String getCdcodigopostal() {
		return this.cdcodigopostal;
	}

	public void setCdcodigopostal(String cdcodigopostal) {
		this.cdcodigopostal = cdcodigopostal;
	}

	@Column(name = "cdnumerocontacto", length = 15)
	public String getCdnumerocontacto() {
		return this.cdnumerocontacto;
	}

	public void setCdnumerocontacto(String cdnumerocontacto) {
		this.cdnumerocontacto = cdnumerocontacto;
	}

	@Column(name = "cdnumerocel", length = 15)
	public String getCdnumerocel() {
		return this.cdnumerocel;
	}

	public void setCdnumerocel(String cdnumerocel) {
		this.cdnumerocel = cdnumerocel;
	}

}