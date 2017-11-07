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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Usuarios entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "usuarios", catalog = "clickapuntos")
public class Usuarios implements java.io.Serializable {

	// Fields

	private Long idusuarios;
	private String usravatar;
	private String usrcelular;
	private String usrmensajeactivacion;
	private Date usrfechacambiocel;
	

	private Date usrfechaultimasesion;
	private String usridexterno;
	private Long usrnumerosesion;
	private Usuariotipo usuariotipo;
	private Clientes clientes;
	private Usuariosdirecciones usuariosdirecciones;
	private Usuariosdatos usuariosdatos;
	private Usuarioproperties usuarioproperties;
	private String usrusername;
	private String usrterceroid;
	private String usrstatus;
	private String usremail;
	private Set<Usuarioprefencias> usuarioprefenciases = new HashSet<Usuarioprefencias>(0);
	private Set<Comentarios> comentarioses = new HashSet<Comentarios>(0);
	private Set<Mediausuario> mediausuarios = new HashSet<Mediausuario>(0);
	private String password;
	private String usrfoto;
	private String provider;
	private String usrsexo;
	private Integer idcompaniacelular;
	private Integer tipoplan;
	
	@Column(name="provider", length=50)
	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	// Constructors
	@Column(name = "usrfoto", length = 100)
	public String getUsrfoto() {
		return usrfoto;
	}

	public void setUsrfoto(String usrfoto) {
		this.usrfoto = usrfoto;
	}

	@Column(name = "password", length = 50)
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/** default constructor */
	public Usuarios() {
	}

	/** full constructor */
	public Usuarios(Usuariotipo usuariotipo, Clientes clientes,
			Usuariosdirecciones usuariosdirecciones,
			Usuariosdatos usuariosdatos, Usuarioproperties usuarioproperties,
			String usrusername, String usrterceroid, String usrstatus,
			String usremail, Set<Usuarioprefencias> usuarioprefenciases,
			Set<Comentarios> comentarioses, Set<Mediausuario> mediausuarios) {
		this.usuariotipo = usuariotipo;
		this.clientes = clientes;
		this.usuariosdirecciones = usuariosdirecciones;
		this.usuariosdatos = usuariosdatos;
		this.usuarioproperties = usuarioproperties;
		this.usrusername = usrusername;
		this.usrterceroid = usrterceroid;
		this.usrstatus = usrstatus;
		this.usremail = usremail;
		this.usuarioprefenciases = usuarioprefenciases;
		this.comentarioses = comentarioses;
		this.mediausuarios = mediausuarios;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idusuarios", unique = true, nullable = false)
	public Long getIdusuarios() {
		return this.idusuarios;
	}

	public void setIdusuarios(Long idusuarios) {
		this.idusuarios = idusuarios;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuariotipo_idusuariotipo")
	public Usuariotipo getUsuariotipo() {
		return this.usuariotipo;
	}

	public void setUsuariotipo(Usuariotipo usuariotipo) {
		this.usuariotipo = usuariotipo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clientes_idcliente")
	public Clientes getClientes() {
		return this.clientes;
	}

	public void setClientes(Clientes clientes) {
		this.clientes = clientes;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuariosdirecciones_idusuariosdirecciones")
	public Usuariosdirecciones getUsuariosdirecciones() {
		return this.usuariosdirecciones;
	}

	public void setUsuariosdirecciones(Usuariosdirecciones usuariosdirecciones) {
		this.usuariosdirecciones = usuariosdirecciones;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuariosdatos_idusuarios")
	public Usuariosdatos getUsuariosdatos() {
		return this.usuariosdatos;
	}

	public void setUsuariosdatos(Usuariosdatos usuariosdatos) {
		this.usuariosdatos = usuariosdatos;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuarioproperties_idusuarioproperties")
	public Usuarioproperties getUsuarioproperties() {
		return this.usuarioproperties;
	}

	public void setUsuarioproperties(Usuarioproperties usuarioproperties) {
		this.usuarioproperties = usuarioproperties;
	}

	@Column(name = "usrusername", length = 45)
	public String getUsrusername() {
		return this.usrusername;
	}

	public void setUsrusername(String usrusername) {
		this.usrusername = usrusername;
	}

	@Column(name = "usrterceroid", length = 45)
	public String getUsrterceroid() {
		return this.usrterceroid;
	}

	public void setUsrterceroid(String usrterceroid) {
		this.usrterceroid = usrterceroid;
	}

	@Column(name = "usrstatus", length = 45)
	public String getUsrstatus() {
		return this.usrstatus;
	}

	public void setUsrstatus(String usrstatus) {
		this.usrstatus = usrstatus;
	}

	@Column(name = "usremail", length = 90)
	public String getUsremail() {
		return this.usremail;
	}

	public void setUsremail(String usremail) {
		this.usremail = usremail;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usuarios")
	public Set<Usuarioprefencias> getUsuarioprefenciases() {
		return this.usuarioprefenciases;
	}

	public void setUsuarioprefenciases(
			Set<Usuarioprefencias> usuarioprefenciases) {
		this.usuarioprefenciases = usuarioprefenciases;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usuarios")
	public Set<Comentarios> getComentarioses() {
		return this.comentarioses;
	}

	public void setComentarioses(Set<Comentarios> comentarioses) {
		this.comentarioses = comentarioses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usuarios")
	public Set<Mediausuario> getMediausuarios() {
		return this.mediausuarios;
	}

	public void setMediausuarios(Set<Mediausuario> mediausuarios) {
		this.mediausuarios = mediausuarios;
	}
	
	@Column
	public String getUsravatar() {
		return usravatar;
	}
	
	public void setUsravatar(String usravatar) {
		this.usravatar = usravatar;
	}
	
	@Column
	public String getUsrcelular() {
		return usrcelular;
	}

	public void setUsrcelular(String usrcelular) {
		this.usrcelular = usrcelular;
	}

	@Column
	public String getUsrmensajeactivacion() {
		return usrmensajeactivacion;
	}

	public void setUsrmensajeactivacion(String usrmensajeactivacion) {
		this.usrmensajeactivacion = usrmensajeactivacion;
	}

	@Column
	public Date getUsrfechacambiocel() {
		return usrfechacambiocel;
	}

	public void setUsrfechacambiocel(Date usrfechacambiocel) {
		this.usrfechacambiocel = usrfechacambiocel;
	}

	@Column
	public Date getUsrfechaultimasesion() {
		return usrfechaultimasesion;
	}

	public void setUsrfechaultimasesion(Date usrfechaultimasesion) {
		this.usrfechaultimasesion = usrfechaultimasesion;
	}

	@Column
	public String getUsridexterno() {
		return usridexterno;
	}

	public void setUsridexterno(String usridexterno) {
		this.usridexterno = usridexterno;
	}

	@Column
	public Long getUsrnumerosesion() {
		return usrnumerosesion;
	}

	public void setUsrnumerosesion(Long usrnumerosesion) {
		this.usrnumerosesion = usrnumerosesion;
	}
	
	@Column
	public String getUsrsexo() {
		return usrsexo;
	}

	public void setUsrsexo(String usrsexo) {
		this.usrsexo = usrsexo;
	}

	@Column
	public Integer getIdcompaniacelular() {
		return idcompaniacelular;
	}

	public void setIdcompaniacelular(Integer idcompaniacelular) {
		this.idcompaniacelular = idcompaniacelular;
	}

	@Column
	public Integer getTipoplan() {
		return tipoplan;
	}

	public void setTipoplan(Integer tipoplan) {
		this.tipoplan = tipoplan;
	}

}