package cl.vk.api.mangos.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.vk.api.mangos.dao.SecurityDao;
import cl.vk.api.mangos.dto.Token;
import cl.vk.api.mangos.dto.TokenResponse;

@RestController
@RequestMapping("/api/v1/security")
public class SecurityController extends SecurityDao{

	@PostMapping("/token")
	public TokenResponse getToken(@RequestBody Token token)
	{
		return obtenerToken(token);
	}
}
