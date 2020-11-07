#language: es
@microservicios:pruebasApi
Característica: Dada la necesidad del negocio para usar su aplicacion de forma segura
  se requieren probar los servicios del backend para validar su correcto funcionamiento
  con esto tener seguridad de que el software que se esta probando saldra con una estabilidad
  adecuada para su uso.

  @registro_nuevo_user
  Esquema del escenario: Registro de un usuario nuevo
    Dado que <user> requiere registrarse por primera vez en la aplicacion
    Cuando ingrese sus credenciales <email> y <pass> hacia el servicio de registro
    Y el usuario se registra exitosamente con el codigo de respuesta <sc>
    Entonces el puede loguearse en la aplicacion con <passl>
    Y obtiene un codigo de respuesta <sc> del logueo exitoso en la app
    Y el token que responde el logueo no puede estar vacio

    Ejemplos:

      | user     | email              | pass   | sc  | passl      |
      | Santiago | eve.holt@reqres.in | pistol | 200 | cityslicka |

