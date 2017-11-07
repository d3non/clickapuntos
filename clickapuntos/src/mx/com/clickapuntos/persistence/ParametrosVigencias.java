package mx.com.clickapuntos.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "parametrosvigencias", catalog = "clickapuntos")
public class ParametrosVigencias implements Serializable {
	private Long idParametro;
	private Long idTipoParametro;
	private Long numDias;
	
	@Id
	@Column(name = "idparametro", unique = true, nullable = false)
	public Long getIdParametro() {
		return idParametro;
	}
	public void setIdParametro(Long idParametro) {
		this.idParametro = idParametro;
	}
	
	@Column
	public Long getIdTipoParametro() {
		return idTipoParametro;
	}
	public void setIdTipoParametro(Long idTipoParametro) {
		this.idTipoParametro = idTipoParametro;
	}
	
	@Column
	public Long getNumDias() {
		return numDias;
	}
	public void setNumDias(Long numDias) {
		this.numDias = numDias;
	}
	
}
