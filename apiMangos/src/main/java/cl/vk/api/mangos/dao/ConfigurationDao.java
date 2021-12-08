package cl.vk.api.mangos.dao;

import cl.vk.api.mangos.conf.ServerParam;
import cl.vk.api.mangos.dto.Configuration;
import cl.vk.api.mangos.dto.ConfigurationResponse;
import cl.vk.api.mangos.dto.GetConfiguration;
import cl.vk.api.mangos.parameter.ApiParameters;
import cl.vk.mangos.transmision.JWTutils;

public class ConfigurationDao extends JWTutils {

	public ConfigurationResponse setConfiguration(String jwt, Configuration input) {
		ConfigurationResponse response = new ConfigurationResponse();
		if (validarJWT(jwt)) {
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
		if (validarJWT(jwt)) {
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
