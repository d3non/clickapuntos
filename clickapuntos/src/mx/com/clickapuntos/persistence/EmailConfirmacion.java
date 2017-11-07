package mx.com.clickapuntos.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emailconfirmacion", catalog = "clickapuntos")
public class EmailConfirmacion {
	private String emailEnvio;
	private String password;
	private String servidorsmtp;
	private String puerto;
	private String pagina;
	
	@Id
	@Column
	public String getEmailEnvio() {
		return emailEnvio;
	}
	public void setEmailEnvio(String emailEnvio) {
		this.emailEnvio = emailEnvio;
	}
	
	@Column
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column
	public String getServidorsmtp() {
		return servidorsmtp;
	}
	public void setServidorsmtp(String servidorsmtp) {
		this.servidorsmtp = servidorsmtp;
	}
	
	@Column
	public String getPuerto() {
		return puerto;
	}
	public void setPuerto(String puerto) {
		this.puerto = puerto;
	}
	
	@Column
	public String getPagina() {
		return pagina;
	}
	public void setPagina(String pagina) {
		this.pagina = pagina;
	}
	
}
