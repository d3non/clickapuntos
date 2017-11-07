package mx.com.clickapuntos.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "recargasku", catalog = "clickapuntos")
public class Recargasku implements Serializable {
	private Integer id;
	private Integer monto;
	private Integer idTipo;
	private String sku;
	
	public Recargasku(){
		
	}
	public Recargasku(Integer id, Integer monto, Integer idTipo, String sku) {
		super();
		this.id = id;
		this.monto = monto;
		this.idTipo = idTipo;
		this.sku = sku;
	}
	
	@Id
	@Column(name = "idtelefonia", unique = false, nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "monto", unique = false, nullable = false)
	public Integer getMonto() {
		return monto;
	}
	public void setMonto(Integer monto) {
		this.monto = monto;
	}

	@Column(name = "idtipo", unique = false, nullable = false)
	public Integer getIdtipo() {
		return idTipo;
	}
	public void setIdtipo(Integer idtipo) {
		this.idTipo = idtipo;
	}

	@Column(name = "sku", unique = true, nullable = false, length = 13)
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}

}
