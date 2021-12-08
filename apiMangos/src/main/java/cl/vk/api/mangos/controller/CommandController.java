package cl.vk.api.mangos.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.vk.api.mangos.dao.CommandDao;
import cl.vk.api.mangos.dto.Execute;
import cl.vk.api.mangos.dto.ExecuteResponse;

@RestController
@RequestMapping("/api/v1/server")
public class CommandController extends CommandDao {
	//@RequestHeader("Authorization") String jwt,
	@PostMapping("/execute")
	public ExecuteResponse executeCommand( @RequestBody Execute input) {
		return ejecutarComando(input);
		
	}
}
