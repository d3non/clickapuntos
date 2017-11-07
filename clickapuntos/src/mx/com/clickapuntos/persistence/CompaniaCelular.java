package mx.com.clickapuntos.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "companiacelular", catalog = "clickapuntos")
public class CompaniaCelular implements Serializable {
	private Integer id;
	private String descripcion;
	
	public CompaniaCelular(){
		
	}
	public CompaniaCelular(Integer id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}
	
	@Id
	@Column(name = "idusrcompaniacelular", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
