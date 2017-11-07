package mx.com.clickapuntos.persistence;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Timestamp;
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
 * Promos entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "promos", catalog = "clickapuntos")
public class Promos implements java.io.Serializable {

	// Fields

	private Integer idpromo;
	private Promotipomecanica promotipomecanica;
	private Clientes clientes;
	private Promotipocobro promotipocobro;
	private String promodescripcion;
	private String promomecanica;
	private String promomecanicaimagen;
	private Long promonumeropuntos;
	private Timestamp promofechacreacion;
	private Timestamp promofechainicio;
	private Timestamp promofechafin;
	private Timestamp promofechabaja;
	private String promostatus;
	private String promoimagen;
	private String promoimagenvideo;
	private String promoimagenwallpaper;
	private String promoimagenfeed;
	private String promonombreurl;
	private String promomecanicalargo;
	private Set<Mediapromo> mediapromos = new HashSet<Mediapromo>(0);
	private Long maxPuntos;
	private Long idPuntos;

	// Constructors

	

	/** default constructor */
	public Promos() {
	}

	/** minimal constructor */
	public Promos(Promotipomecanica promotipomecanica, Clientes clientes,
			Promotipocobro promotipocobro) {
		this.promotipomecanica = promotipomecanica;
		this.clientes = clientes;
		this.promotipocobro = promotipocobro;
	}

	/** full constructor */
	public Promos(Promotipomecanica promotipomecanica, Clientes clientes,
			Promotipocobro promotipocobro, String promodescripcion,
			String promomecanica, String promomecanicaimagen,
			Long promonumeropuntos, Timestamp promofechacreacion,
			Timestamp promofechainicio, Timestamp promofechafin,
			Timestamp promofechabaja, String promostatus, String promoimagen,
			String promoimagenvideo, String promoimagenwallpaper, String promoimagenfeed, String promonombreurl,
			Set<Mediapromo> mediapromos) {
		this.promotipomecanica = promotipomecanica;
		this.clientes = clientes;
		this.promotipocobro = promotipocobro;
		this.promodescripcion = promodescripcion;
		this.promomecanica = promomecanica;
		this.promomecanicaimagen = promomecanicaimagen;
		this.promonumeropuntos = promonumeropuntos;
		this.promofechacreacion = promofechacreacion;
		this.promofechainicio = promofechainicio;
		this.promofechafin = promofechafin;
		this.promofechabaja = promofechabaja;
		this.promostatus = promostatus;
		this.promoimagen = promoimagen;
		this.promoimagenvideo = promoimagenvideo;
		this.promoimagenwallpaper = promoimagenwallpaper;
		this.promoimagenfeed = promoimagenfeed;
		this.promonombreurl = promonombreurl;
		this.mediapromos = mediapromos;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idpromo", unique = true, nullable = false)
	public Integer getIdpromo() {
		return this.idpromo;
	}

	public void setIdpromo(Integer idpromo) {
		this.idpromo = idpromo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "promotipomecanica_idpromotipomecanica", nullable = false)
	public Promotipomecanica getPromotipomecanica() {
		return this.promotipomecanica;
	}

	public void setPromotipomecanica(Promotipomecanica promotipomecanica) {
		this.promotipomecanica = promotipomecanica;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clientes_idcliente", nullable = false)
	public Clientes getClientes() {
		return this.clientes;
	}

	public void setClientes(Clientes clientes) {
		this.clientes = clientes;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "promotipocobro_idpromotipodescripcion", nullable = false)
	public Promotipocobro getPromotipocobro() {
		return this.promotipocobro;
	}

	public void setPromotipocobro(Promotipocobro promotipocobro) {
		this.promotipocobro = promotipocobro;
	}

	@Column(name = "promodescripcion")
	public String getPromodescripcion() {
		return this.promodescripcion;
	}

	public void setPromodescripcion(String promodescripcion) {
		this.promodescripcion = promodescripcion;
	}

	@Column(name = "promomecanica")
	public String getPromomecanica() {
		return this.promomecanica;
	}

	public void setPromomecanica(String promomecanica) {
		this.promomecanica = promomecanica;
	}

	@Column(name = "promomecanicaimagen")
	public String getPromomecanicaimagen() {
		return this.promomecanicaimagen;
	}

	public void setPromomecanicaimagen(String promomecanicaimagen) {
		this.promomecanicaimagen = promomecanicaimagen;
	}

	@Column(name = "promonumeropuntos")
	public Long getPromonumeropuntos() {
		return this.promonumeropuntos;
	}

	public void setPromonumeropuntos(Long promonumeropuntos) {
		this.promonumeropuntos = promonumeropuntos;
	}

	@Column(name = "promofechacreacion", length = 0)
	public Timestamp getPromofechacreacion() {
		return this.promofechacreacion;
	}

	public void setPromofechacreacion(Timestamp promofechacreacion) {
		this.promofechacreacion = promofechacreacion;
	}

	@Column(name = "promofechainicio", length = 0)
	public Timestamp getPromofechainicio() {
		return this.promofechainicio;
	}

	public void setPromofechainicio(Timestamp promofechainicio) {
		this.promofechainicio = promofechainicio;
	}

	@Column(name = "promofechafin", length = 0)
	public Timestamp getPromofechafin() {
		return this.promofechafin;
	}

	public void setPromofechafin(Timestamp promofechafin) {
		this.promofechafin = promofechafin;
	}

	@Column(name = "promofechabaja", length = 0)
	public Timestamp getPromofechabaja() {
		return this.promofechabaja;
	}

	public void setPromofechabaja(Timestamp promofechabaja) {
		this.promofechabaja = promofechabaja;
	}

	@Column(name = "promostatus", length = 1)
	public String getPromostatus() {
		return this.promostatus;
	}

	public void setPromostatus(String promostatus) {
		this.promostatus = promostatus;
	}

	@Column(name = "promoimagen", nullable = false)
	public String getPromoimagen() {
		return this.promoimagen;
	}

	public void setPromoimagen(String promoimagen) {
		this.promoimagen = promoimagen;
	}

	@Column(name = "promoimagenvideo", nullable = false)
	public String getPromoimagenvideo() {
		return this.promoimagenvideo;
	}

	public void setPromoimagenvideo(String promoimagenvideo) {
		this.promoimagenvideo = promoimagenvideo;
	}

	@Column(name = "promoimagenwallpaper")
	public String getPromoimagenwallpaper() {
		return this.promoimagenwallpaper;
	}

	public void setPromoimagenwallpaper(String promoimagenwallpaper) {
		this.promoimagenwallpaper = promoimagenwallpaper;
	}

	@Column(name = "promoimagenfeed", nullable = false)
	public String getPromoimagenfeed() {
		return this.promoimagenfeed;
	}

	public void setPromoimagenfeed(String promoimagenfeed) {
		this.promoimagenfeed = promoimagenfeed;
	}

	@Column(name = "promonombreurl", length = 90)
	public String getPromonombreurl() {
		return this.promonombreurl;
	}

	public void setPromonombreurl(String promonombreurl) {
		this.promonombreurl = promonombreurl;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "promos")
	public Set<Mediapromo> getMediapromos() {
		return this.mediapromos;
	}

	public void setMediapromos(Set<Mediapromo> mediapromos) {
		this.mediapromos = mediapromos;
	}
	
	@Column(name="promomecanicalargo")
	public String getPromomecanicalargo() {
		return promomecanicalargo;
	}
	public void setPromomecanicalargo(String promomecanicalargo) {
		this.promomecanicalargo = promomecanicalargo;
	}
	
	@Column(name="promomaxpuntoscliente")
	public Long getMaxPuntos() {
		return maxPuntos;
	}
	public void setMaxPuntos(Long maxPuntos) {
		this.maxPuntos = maxPuntos;
	}

	@Column(name="puntos_idpuntos",nullable=false)
	public Long getIdPuntos() {
		return idPuntos;
	}

	public void setIdPuntos(Long idPuntos) {
		this.idPuntos = idPuntos;
	}
	
}