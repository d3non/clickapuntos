package mx.com.clickapuntos.persistence;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tracking entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tracking", catalog = "clickapuntos")
public class Tracking implements java.io.Serializable {

	// Fields

	private Integer idTracking;
	private Integer idUser;
	private Integer idCampania;
	private Integer idMedia;
	private Integer idOrigen;

	// Constructors

	/** default constructor */
	public Tracking() {
	}

	/** full constructor */
	public Tracking(Integer idUser, Integer idCampania, Integer idMedia,
			Integer idOrigen) {
		this.idUser = idUser;
		this.idCampania = idCampania;
		this.idMedia = idMedia;
		this.idOrigen = idOrigen;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "IdTracking", unique = true, nullable = false)
	public Integer getIdTracking() {
		return this.idTracking;
	}

	public void setIdTracking(Integer idTracking) {
		this.idTracking = idTracking;
	}

	@Column(name = "IdUser", nullable = false)
	public Integer getIdUser() {
		return this.idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	@Column(name = "IdCampania", nullable = false)
	public Integer getIdCampania() {
		return this.idCampania;
	}

	public void setIdCampania(Integer idCampania) {
		this.idCampania = idCampania;
	}

	@Column(name = "IdMedia", nullable = false)
	public Integer getIdMedia() {
		return this.idMedia;
	}

	public void setIdMedia(Integer idMedia) {
		this.idMedia = idMedia;
	}

	@Column(name = "IdOrigen", nullable = false)
	public Integer getIdOrigen() {
		return this.idOrigen;
	}

	public void setIdOrigen(Integer idOrigen) {
		this.idOrigen = idOrigen;
	}

}