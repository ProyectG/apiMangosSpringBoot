package cl.vk.api.mangos.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.vk.api.mangos.conf.ServerParam;
import cl.vk.api.mangos.dto.Execute;
import cl.vk.api.mangos.dto.ExecuteResponse;
import cl.vk.api.mangos.parameter.Commands;
import cl.vk.mangos.transmision.JWTutils;
import cl.vk.mangos.transmision.SOAPutils;
import cl.vk.mangos.transmision.XMLutils;

public class CommandDao extends ServerParam {

	private SOAPutils soapUtils = new SOAPutils();
	private XMLutils xmlUtils = new XMLutils();
	private Logger logger = LoggerFactory.getLogger(CommandDao.class);	
	protected static JWTutils jwtUtils = new JWTutils();

	public ExecuteResponse ejecutarComando(String token,Execute input) {
		ExecuteResponse respuesta = new ExecuteResponse();
		if (isStatus()) {
			if(jwtUtils.validarJWT(token)) {
			try {
				soapUtils.generateSoapMessage(input.getComando());
				String soapResponse = soapUtils.sendMessage();
				if (soapResponse != null) {
					String salidaSoap = xmlUtils.parseXML(soapResponse);
					logger.info("Mensaje de salida {}", salidaSoap);
					respuesta.setCod("0");
					respuesta.setDsc(salidaSoap);
				} else {
					respuesta.setCod("1");
					respuesta.setDsc("Error al ejecutar el comando [" + soapResponse + "]");
				}
			} catch (Exception e) {
				respuesta.setCod("1");
				respuesta.setDsc("Error al ejecutar el comando");
			}
			}else
			{
				respuesta.setCod("1");
				respuesta.setDsc("Acceso no autorizado");
			}
		} else {
			respuesta.setCod("1");
			respuesta.setDsc("Api no configurada");
		}

		return respuesta;
	}

	protected boolean validateCommand(String comando) {

		if (Commands.CREATE_ACCOUNT.toString().equalsIgnoreCase(comando)) {
			return false;
		}
		return true;
	}

}
