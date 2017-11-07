package mx.com.clickapuntos.bean;

import java.io.Serializable;
import java.util.List;

import mx.com.clickapuntos.persistence.CompaniaCelular;

@SuppressWarnings("serial")
public class UserBean implements Serializable {
	private String idUser;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String nickname;
	private String celular;
	private String celularcheck;
	private String correo;
	private String sexo;
	private String anio;
	private String mes;
	private String dia;
	private String calle;
	private String cp;
	private String bloqueoCelular;
	private String compania;
	private String tipoplan;
	private List<CompaniaCelular> companias;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getAnio() {
		return anio;
	}
	public void setAnio(String anio) {
		this.anio = anio;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getBloqueoCelular() {
		return bloqueoCelular;
	}
	public void setBloqueoCelular(String bloqueoCelular) {
		this.bloqueoCelular = bloqueoCelular;
	}
	public String getCompania() {
		return compania;
	}
	public void setCompania(String compania) {
		this.compania = compania;
	}
	public String getCelularcheck() {
		return celularcheck;
	}
	public void setCelularcheck(String celularcheck) {
		this.celularcheck = celularcheck;
	}
	public List<CompaniaCelular> getCompanias() {
		return companias;
	}
	public void setCompanias(List<CompaniaCelular> companias) {
		this.companias = companias;
	}
	public String getTipoplan() {
		return this.tipoplan;
	}
	public void setTipoplan(String tipoplan) {
		this.tipoplan = tipoplan;
	}
	
}
