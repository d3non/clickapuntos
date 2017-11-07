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
 * Usuariosdirecciones entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "usuariosdirecciones", catalog = "clickapuntos")
public class Usuariosdirecciones implements java.io.Serializable {

	// Fields

	private Integer idusuariosdirecciones;
	private String udcalle;
	private String udnumero;
	private String udcolonia;
	private String uddelmpio;
	private String udciudad;
	private String udcodigopostal;
	private String udnumerocontacto;
	private String udnumerocel;
	private String udpais;
	private String udestado;
	private Set<Usuarios> usuarioses = new HashSet<Usuarios>(0);

	// Constructors

	/** default constructor */
	public Usuariosdirecciones() {
	}

	/** full constructor */
	public Usuariosdirecciones(String udcalle, String udnumero,
			String udcolonia, String uddelmpio, String udciudad,
			String udcodigopostal, String udnumerocontacto, String udnumerocel,
			Set<Usuarios> usuarioses) {
		this.udcalle = udcalle;
		this.udnumero = udnumero;
		this.udcolonia = udcolonia;
		this.uddelmpio = uddelmpio;
		this.udciudad = udciudad;
		this.udcodigopostal = udcodigopostal;
		this.udnumerocontacto = udnumerocontacto;
		this.udnumerocel = udnumerocel;
		this.usuarioses = usuarioses;
	}

	// Property accessors
	@Id
	@Column(name = "idusuariosdirecciones", unique = true, nullable = false)
	public Integer getIdusuariosdirecciones() {
		return this.idusuariosdirecciones;
	}

	public void setIdusuariosdirecciones(Integer idusuariosdirecciones) {
		this.idusuariosdirecciones = idusuariosdirecciones;
	}

	@Column(name = "udcalle", length = 90)
	public String getUdcalle() {
		return this.udcalle;
	}

	public void setUdcalle(String udcalle) {
		this.udcalle = udcalle;
	}

	@Column(name = "udnumero", length = 5)
	public String getUdnumero() {
		return this.udnumero;
	}

	public void setUdnumero(String udnumero) {
		this.udnumero = udnumero;
	}

	@Column(name = "udcolonia", length = 150)
	public String getUdcolonia() {
		return this.udcolonia;
	}

	public void setUdcolonia(String udcolonia) {
		this.udcolonia = udcolonia;
	}

	@Column(name = "uddelmpio", length = 90)
	public String getUddelmpio() {
		return this.uddelmpio;
	}

	public void setUddelmpio(String uddelmpio) {
		this.uddelmpio = uddelmpio;
	}

	@Column(name = "udciudad", length = 90)
	public String getUdciudad() {
		return this.udciudad;
	}

	public void setUdciudad(String udciudad) {
		this.udciudad = udciudad;
	}

	@Column(name = "udcodigopostal", length = 10)
	public String getUdcodigopostal() {
		return this.udcodigopostal;
	}

	public void setUdcodigopostal(String udcodigopostal) {
		this.udcodigopostal = udcodigopostal;
	}

	@Column(name = "udnumerocontacto", length = 15)
	public String getUdnumerocontacto() {
		return this.udnumerocontacto;
	}

	public void setUdnumerocontacto(String udnumerocontacto) {
		this.udnumerocontacto = udnumerocontacto;
	}

	@Column(name = "udnumerocel", length = 15)
	public String getUdnumerocel() {
		return this.udnumerocel;
	}

	public void setUdnumerocel(String udnumerocel) {
		this.udnumerocel = udnumerocel;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usuariosdirecciones")
	public Set<Usuarios> getUsuarioses() {
		return this.usuarioses;
	}

	public void setUsuarioses(Set<Usuarios> usuarioses) {
		this.usuarioses = usuarioses;
	}
	
	@Column
	public String getUdpais() {
		return udpais;
	}

	public void setUdpais(String udpais) {
		this.udpais = udpais;
	}
	
	@Column
	public String getUdestado() {
		return udestado;
	}

	public void setUdestado(String udestado) {
		this.udestado = udestado;
	}
	
}