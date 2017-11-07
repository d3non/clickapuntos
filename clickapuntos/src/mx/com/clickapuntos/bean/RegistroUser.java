package mx.com.clickapuntos.bean;

import net.tanesha.recaptcha.ReCaptchaResponse;

public class RegistroUser {
	private String nickname;
	private String email;
	private String password;
	private String passwordCheck;
	private boolean condiciones;
	private ReCaptchaResponse captcha;
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordCheck() {
		return passwordCheck;
	}
	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}
	public boolean getCondiciones() {
		return condiciones;
	}
	public void setCondiciones(boolean condiciones) {
		this.condiciones = condiciones;
	}
	public ReCaptchaResponse getCaptcha() {
		return captcha;
	}
	public void setCaptcha(ReCaptchaResponse captcha) {
		this.captcha = captcha;
	}

}
