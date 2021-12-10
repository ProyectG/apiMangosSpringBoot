package cl.vk.api.mangos.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import cl.vk.api.mangos.conf.ServerParam;
import cl.vk.api.mangos.dto.Configuration;
import cl.vk.api.mangos.dto.ConfigurationResponse;
import cl.vk.api.mangos.dto.GetConfiguration;
import cl.vk.api.mangos.parameter.ApiParameters;
import cl.vk.mangos.transmision.ConfigurationUtils;
import cl.vk.mangos.transmision.JWTutils;

public class ConfigurationDao extends JWTutils {

	final Logger LOGGER = LoggerFactory.getLogger(ConfigurationDao.class);
	
	@Value("${mangos.security}")
	protected Boolean seguridad;
	
	public ConfigurationDao() {
		if(ConfigurationUtils.getPropiedades().get("mangos.security") != null)
			this.seguridad = (Boolean) ConfigurationUtils.getPropiedades().get("mangos.security");
	}
	
	public ConfigurationResponse setConfiguration(String jwt, Configuration input) {
		ConfigurationResponse response = new ConfigurationResponse();
		if (!this.seguridad || validarJWT(jwt)) {
			try {
				ServerParam.setPass(input.getPass());
				ServerParam.setPort(input.getPort());
				ServerParam.setStatus(true);
				ServerParam.setUrl(input.getUrl());
				ServerParam.setUser(input.getUser());

				response.setCod("0");
				response.setDsc("Configuracion exitosa");
			} catch (Exception e) {
				response.setCod("1");
				response.setDsc("Error al setear las configuraciones");
				LOGGER.error("Error al setear los parametros ", e);
			}
		} else
		{
			response.setCod("1");
			response.setDsc("Acceso no autorizado");
		}
		return response;
	}

	public GetConfiguration getConf(String jwt) {
		GetConfiguration response = new GetConfiguration();
		if (!this.seguridad || validarJWT(jwt)) {
			ApiParameters parametros = new ApiParameters();
			parametros.setPass(ServerParam.getPass());
			parametros.setPort(ServerParam.getPort());
			parametros.setUrl(ServerParam.getUrl());
			parametros.setUser(ServerParam.getUser());

			response.setParametros(parametros);
		}
		return response;
	}

}
