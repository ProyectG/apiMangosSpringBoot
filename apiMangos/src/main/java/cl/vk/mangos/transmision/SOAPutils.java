package cl.vk.mangos.transmision;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Base64;

import cl.vk.api.mangos.conf.ServerParam;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SOAPutils extends ServerParam {

		private Logger logger = LoggerFactory.getLogger(SOAPutils.class);
		private SOAPMessage mensaje;
		
		public String sendMessage() {
			try {
				logger.info("URL [{}]",getUrl());
				URL endpoint = new URL(getUrl()+":"+getPort());
				SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
				SOAPConnection connection = soapConnectionFactory.createConnection();
				SOAPMessage response = connection.call(this.mensaje, endpoint);
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				response.writeTo(out);
				String strMsg = new String(out.toByteArray());
				logger.info("Respuesta soap {}",strMsg);
				return strMsg;
			} catch (UnsupportedOperationException e) {
				logger.error("Error operacion no soportada ", e);
			} catch (SOAPException e) {
				logger.error("SOAP Exception ", e);
			} catch (IOException e) {
				logger.error("IO Error ", e);
			}
			return null;
		}

		public SOAPMessage generateSoapMessage(String comando) throws IOException, SOAPException {
			try {
				InputStream is = new ByteArrayInputStream(getSoapmessage().replace("{comando}", comando).getBytes());
				SOAPMessage message = MessageFactory.newInstance().createMessage(null, is);
				MimeHeaders headers = message.getMimeHeaders();
				headers.addHeader("Authorization", "Basic " + base64Authorization());
				message.saveChanges();
				this.mensaje = message;
				logger.info("Mensaje a enviar {}", message);
			} catch (IOException e) {
				logger.error("IO Error ", e);
			} catch (SOAPException e) {
				logger.error("SOAP Exception ", e);
			}
			return null;
		}

		protected String base64Authorization() {
			String userAndPassword = String.format("%s:%s", getUser(), getPass());
			String basicAuth = Base64.getEncoder().encodeToString(userAndPassword.getBytes());
			logger.info("Autenticacion {}",basicAuth);
			return basicAuth;
		}

}
