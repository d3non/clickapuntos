package mx.com.clickapuntos.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "autentificacion", catalog = "clickapuntos")
public class Autentificacion implements Serializable {
	private Long id;
	private String apikey;
	private String apisecret;
	private String provider;
	private String callbackurl;
	
	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="idautentificacion",nullable=false,unique=true)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column
	public String getApikey() {
		return apikey;
	}
	public void setApikey(String apikey) {
		this.apikey = apikey;
	}
	
	@Column
	public String getApisecret() {
		return apisecret;
	}
	public void setApisecret(String apisecret) {
		this.apisecret = apisecret;
	}
	
	@Column
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	
	@Column
	public String getCallbackurl() {
		return callbackurl;
	}
	public void setCallbackurl(String callbackurl) {
		this.callbackurl = callbackurl;
	}
	
	
}
