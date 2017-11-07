package mx.com.clickapuntos.persistence;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "tipocambiopuntospesos", catalog = "clickapuntos")
public class TipoCambioPuntosPesos implements Serializable{
	private Long id;
	private Date fecha;
	private Double valor;
	
	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="idtipocambiopuntospesos",nullable=false)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="tipocambiofecha")
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	@Column(name="tipocambiovalor")
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
}
