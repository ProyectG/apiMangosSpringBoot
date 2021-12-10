package cl.vk.api.mangos.dao;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import cl.vk.api.mangos.dto.Token;
import cl.vk.api.mangos.dto.TokenResponse;
import cl.vk.mangos.transmision.ConfigurationUtils;

public class SecurityDao extends ConfigurationUtils{

	/**
	 * Datos locales Usados si no se configura por parte total.
	 */
	
	final Logger LOGGER = LoggerFactory.getLogger(SecurityDao.class);
	
	@Value("${mangos.user}")
	private String usuario;
	@Value("${mangos.pass}")
	private String password;
	@Value("${mangos.jwt.key}")
	private String jwtKey;

	final private long MINUTO_MILISEGUNDOS = 60000;

	public SecurityDao() {

	}

	public TokenResponse obtenerToken(Token input) {
		TokenResponse respuesta = new TokenResponse();
		if (!estadoConf) {
			if (this.usuario.equals(input.getUsername()) && this.password.equals(input.getPassword())) {
				respuesta.setCod("0");
				respuesta.setDsc("Token generado exitosamente");
				respuesta.setToken(generateJWT(this.jwtKey));

			} else {
				respuesta.setCod("-1");
				respuesta.setDsc("Credenciales invalidas");
				respuesta.setToken("-");
			}
		} else {
			if (user.equals(input.getUsername()) && pass.equals(input.getPassword())) {
				respuesta.setCod("0");
				respuesta.setDsc("Token generado exitosamente");
				respuesta.setToken(generateJWT(ConfigurationUtils.propiedades.getProperty("mangos.jwt.key")));

			} else {
				respuesta.setCod("-1");
				respuesta.setDsc("Credenciales invalidas");
				respuesta.setToken("-");
			}
		}
		return respuesta;
	}

	private String generateJWT(String key) {
		Date fecha = new Date(System.currentTimeMillis() + (4 * MINUTO_MILISEGUNDOS));
		Algorithm algoritmo = Algorithm.HMAC512(key);
		String token = JWT.create().withIssuer("mangosApi").withExpiresAt(fecha).sign(algoritmo);
		return token;
	}
	
	
}
