package mx.com.clickapuntos.persistence;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "tarjetaspremios", catalog = "clickapuntos")
public class TarjetasPremios implements Serializable{
	private Long idTarjeta;
	private String codigo;
	private int tipotarjeta;
	private int monto;
	private int status;
	private Timestamp fechaalta;
	private Timestamp fechaasignacion;
	private Long idtransaccion;
	
	public TarjetasPremios(){}
	
	public TarjetasPremios(Long idTarjeta, String codigo,
				int tipotarjeta, int monto, int status, Timestamp fechaalta, Timestamp fechaasignacion, Long idtransaccion) {
		super();
		this.idTarjeta = idTarjeta;
		this.codigo = codigo;
		this.tipotarjeta = tipotarjeta;
		this.monto = monto;
		this.status = status;
		this.fechaalta = fechaalta;
		this.fechaasignacion = fechaasignacion;
		this.idtransaccion = idtransaccion;
	}
	
	@Id
	@Column(name = "idtarjeta", unique = true, nullable = false)
	public Long getId() {
		return idTarjeta;
	}
	public void setId(Long idTarjeta) {
		this.idTarjeta = idTarjeta;
	}

	@Column
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	
	@Column
	public int getTipoTarjeta() {
		return tipotarjeta;
	}
	public void setTipoTarjeta(int tipotarjeta) {
		this.tipotarjeta = tipotarjeta;
	}

	@Column
	public int getMonto() {
		return monto;
	}
	public void setMonto(int monto) {
		this.monto = monto;
	}

	@Column
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	@Column
	public Timestamp getFechaAlta() {
		return fechaalta;
	}
	public void setFechaAlta(Timestamp fechaalta) {
		this.fechaalta = fechaalta;
	}
	
	@Column
	public Timestamp getFechaAsignacion() {
		return fechaasignacion;
	}
	public void setFechaAsignacion(Timestamp fechaasignacion) {
		this.fechaasignacion = fechaasignacion;
	}
	
	@Column
	public Long getIdTransaccion() {
		return idtransaccion;
	}
	public void setIdTransaccion(Long idtransaccion) {
		this.idtransaccion = idtransaccion;
	}

}
