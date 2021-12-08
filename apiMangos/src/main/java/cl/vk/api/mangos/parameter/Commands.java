package cl.vk.api.mangos.parameter;

/**
 * Metodo que contendra los comandos a utilizar
 * podria contenerse en el mismo mensaje pero podria ser
 * peligroso para injectar comandos no permitidos.
 * 
 * @author vkey
 *
 */
public enum Commands {
	
	SERVER_INFO("server info"),
	CREATE_ACCOUNT("account create {arg0} {arg1}"),
	ADD_LEVEL("levelup {arg0} {arg1}"),
	ADD_ITEM(""),
	DELETE_ACCOUNT("account delete {arg0}")
	;
	
	private final String comando;
	
	Commands(String comando) {
		this.comando = comando;
	}
	
	@Override
	public String toString() {
		return comando;
	}

}
