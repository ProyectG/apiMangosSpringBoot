package cl.vk.api.mangos.conf;

public class ServerParam {
	
	final static String SOAPMESSAGE = "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:SOAP-ENC=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:xsi=\"http://www.w3.org/1999/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/1999/XMLSchema\" xmlns:ns1=\"urn:MaNGOS\"><SOAP-ENV:Body><ns1:executeCommand><command>{comando}</command></ns1:executeCommand></SOAP-ENV:Body></SOAP-ENV:Envelope>";
	public static String user;
	public static String pass;
	public static String url;
	public static String port;
	public static boolean status = false;
	
	public ServerParam() {
		super();
	}
		
	
	public static String getSoapmessage() {
		return SOAPMESSAGE;
	}

	public static String getUser() {
		return user;
	}
	public static void setUser(String user) {
		ServerParam.user = user;
	}
	public static String getPass() {
		return pass;
	}
	public static void setPass(String pass) {
		ServerParam.pass = pass;
	}
	public static String getUrl() {
		return url;
	}
	public static void setUrl(String url) {
		ServerParam.url = url;
	}
	public static String getPort() {
		return port;
	}
	public static void setPort(String port) {
		ServerParam.port = port;
	}
	public static boolean isStatus() {
		return status;
	}
	public static void setStatus(boolean status) {
		ServerParam.status = status;
	}
}
