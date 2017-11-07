package mx.com.clickapuntos.bean;

public class LogginUser {
	private String userEmail;
	private String userPassword;
	private String urlShow;
	private String urlFacebook;
	private String urlTwitter;
	/**
	 * @return the userEmail
	 */
	public String getUserEmail() {
		return userEmail;
	}
	/**
	 * @param userEmail the userEmail to set
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	/**
	 * @return the userPassword
	 */
	public String getUserPassword() {
		return userPassword;
	}
	/**
	 * @param userPassword the userPassword to set
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUrlShow() {
		return urlShow;
	}
	public void setUrlShow(String urlShow) {
		this.urlShow = urlShow;
	}
	public String getUrlFacebook() {
		return urlFacebook;
	}
	public void setUrlFacebook(String urlFacebook) {
		this.urlFacebook = urlFacebook;
	}
	public String getUrlTwitter() {
		return urlTwitter;
	}
	public void setUrlTwitter(String urlTwitter) {
		this.urlTwitter = urlTwitter;
	}
	
}
