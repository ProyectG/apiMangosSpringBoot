package cl.vk.api.mangos.controller;

import cl.vk.api.mangos.dao.ConfigurationDao;

import javax.ws.rs.HeaderParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.vk.api.mangos.dto.Configuration;
import cl.vk.api.mangos.dto.ConfigurationResponse;
import cl.vk.api.mangos.dto.GetConfiguration;

@RestController
@RequestMapping("/api/v1/mangos")
public class ConfigurationController extends ConfigurationDao{

	@GetMapping("/test")
	public String test()
	{return "Respondiendo del servicio de prueba.";}
	
	@PostMapping("/setconfig")
	public ConfigurationResponse config(@RequestBody Configuration input)
	{return  setConfiguration(input);}
	
	@GetMapping("/getconfig")
	public GetConfiguration getConfig(@HeaderParam("Authorization") String jwt) 
	{return getConf(jwt);}	
}
