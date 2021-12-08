package cl.vk.api.mangos.parameter;

public class ApiParameters {
	
	public  String user ="";
	public  String pass ="";
	public  String url ="";
	public  String port ="";
	public  boolean status = false;

	public ApiParameters() {}

	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	


	
}
