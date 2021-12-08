package cl.vk.api.mangos.controller;

import cl.vk.api.mangos.dao.ConfigurationDao;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.core.MediaType;

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
	
	@GetMapping(value = "/test" , produces = MediaType.APPLICATION_XHTML_XML)
	public String test()
	{return "Respondiendo del servicio de prueba.";}
	
	@PostMapping(value="/setconfig", produces = MediaType.APPLICATION_JSON )
	public ConfigurationResponse config(@HeaderParam("Authorizatiuon") String jwt, @RequestBody Configuration input)
	{return  setConfiguration(jwt,input);}
	
	@GetMapping(value = "/getconfig", produces = MediaType.APPLICATION_JSON)
	public GetConfiguration getConfig(@HeaderParam("Authorization") String jwt) 
	{return getConf(jwt);}	
}
