package cl.vk.mangos.transmision;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JWTutils {
	
	final Logger LOGGER = LoggerFactory.getLogger(JWTutils.class);
	
	public boolean validarJWT(String token)
	{
		return validateJWT(token);
	}
	
	private boolean validateJWT(String token) {
		try {
			DecodedJWT jwt = JWT.decode(token);
			LOGGER.info("Token desencriptado correctamente {}",jwt.getIssuer());;
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
