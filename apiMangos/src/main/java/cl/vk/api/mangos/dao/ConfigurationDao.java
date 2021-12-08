package cl.vk.api.mangos.dao;

import cl.vk.api.mangos.conf.ServerParam;
import cl.vk.api.mangos.dto.Configuration;
import cl.vk.api.mangos.dto.ConfigurationResponse;
import cl.vk.api.mangos.dto.GetConfiguration;
import cl.vk.api.mangos.parameter.ApiParameters;

public class ConfigurationDao {
		
	public ConfigurationResponse setConfiguration(Configuration input) {
		ConfigurationResponse response = new ConfigurationResponse();
		try {
		ServerParam.setPass(input.getPass());
		ServerParam.setPort(input.getPort());
		ServerParam.setStatus(true);
		ServerParam.setUrl(input.getUrl());
		ServerParam.setUser(input.getUser());
	
		response.setCod("0");
		response.setDsc("Configuracion exitosa");
		}catch(Exception e)
		{
			response.setCod("1");
			response.setDsc("Error al setear las configuraciones");
		}
		return response;
	}
	
	public GetConfiguration getConf(String jwt) {
		GetConfiguration response = new GetConfiguration();
		ApiParameters parametros = new ApiParameters();
		parametros.setPass(ServerParam.getPass());
		parametros.setPort(ServerParam.getPort());
		parametros.setUrl(ServerParam.getUrl());
		parametros.setUser(ServerParam.getUser());
		
		response.setParametros(parametros);
		return response;
	}

}
