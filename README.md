# apiMangosSpringBoot
Api para enviar mensajes SOAP al servicio de mangosd 

# Requerimientos
Compilar el servidor mangosd con el servicio SOAP y habilitarlo.

# Ejecucion de la APi.

- Compilar la solucion / Bajar el war compilado
- Ejecutar el compilado con java -jar apiMangos-${version}-SNAPSHOT.war

# Documentacion API

- al ejecutar el war compilado ingresar a la siguiente url en tu navegador localhost:8080/apidoc.html

## Endpoints.

### POST
- /api/v1/server/execute
- /api/v1/security/token
- /api/v1/mangos/setconfig
### GET
- /api/v1/mangos/test
- /api/v1/mangos/getconfig

## USO


#### Token
El servicio de token debera ser utilizado antes de ejecutar cada accion permitiendo que solo el equipo dueño del servidor tenga acceso a utilizar los metodos, este servicio es **/api/v1/security/token** donde solicitara usuario y password los cuales si no se configura en el **Archivo de configuracion** vendran los por defecto. *Ver Archivo de configuracion para configurar credenciales propias*

Credenciales por defecto.
- user : admin
- pass : admingm

### Configuracion

Para utilizar la api se debe primero ejecutar el war compilado, esta api no viene con una configuracion predeterminada por lo que permite al usuario configurar los parametros necesarios para la comunicacion con el servidor de *WOW* (mangosd). Para ello se configura el servicio con el metodo **/api/v1/mangos/setconfig** los servicios de configuracion y ejecucion solicitaran el uso de un token enviado en el header de la peticion en el campo **Authorization** *Ver Token*

El servicio solicitara:

* port = puerto a utilizar
* user = usuario con privilegios para utilizar el servicio SOAP
* pass = password con privilegios para utilizar el servicio SOAP
* url = direccion del servidor debe venir con http://, *Ejemplo : http://192.168.1.10*

El servicio respondera con codigo 0 para la configuracion exitosa.

### Ver Configuracion

*En Construccion*

### Ejecutar Comando

*En Construccion*


## Archivo de configuracion

*En construccion*


