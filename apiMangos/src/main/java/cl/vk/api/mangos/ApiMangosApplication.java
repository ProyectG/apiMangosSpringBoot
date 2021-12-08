package cl.vk.api.mangos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cl.vk.mangos.transmision.ConfigurationUtils;

@SpringBootApplication
public class ApiMangosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiMangosApplication.class, args);
		
		@SuppressWarnings("unused")
		ConfigurationUtils conf = new ConfigurationUtils();
	}

}
