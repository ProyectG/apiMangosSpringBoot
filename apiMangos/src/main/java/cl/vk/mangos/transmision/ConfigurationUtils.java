package cl.vk.mangos.transmision;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigurationUtils {
	
	final String ARCHIVO_CONFIGURACION="apiConf.properties";
	protected static String user;
	protected static String pass;
	final Logger LOGGER = LoggerFactory.getLogger(ConfigurationUtils.class);
	protected static Properties propiedades;
	protected static boolean estadoConf=false;
	
	public ConfigurationUtils(){
		if(!estadoConf)
			cargarPropiedades();
		else
			LOGGER.info("Propiedades ya cargadas");
	}
	
	protected void cargarPropiedades()
	{
		try(InputStream entrada = new FileInputStream("./"+ARCHIVO_CONFIGURACION)){
			propiedades = new Properties();
			propiedades.load(entrada);
			estadoConf = true;
		}catch(IOException e)
		{
			LOGGER.warn("El archivo no se encontro, se utilizara la configuracion local");
		}
	}
}
