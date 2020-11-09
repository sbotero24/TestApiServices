package stepDefinitions;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import model.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.annotations.Steps;
import questions.ResponseCode;
import tasks.PostLogin;
import tasks.PostRegister;
import utils.DataInfoUser;

import static io.restassured.path.json.JsonPath.from;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;
import static utils.GenericConstants.*;

public class LoginStep {

    @Steps(shared = true)
    private DataInfoUser dataInfoUser;

    Actor actor;

    @Dado("^que (.*) requiere registrarse por primera vez en la aplicacion$")
    public void queSantiagoRequiereRegistrarsePorPrimeraVezEnLaAplicacion(String usr) {
        actor = Actor.named(usr)
                .whoCan(CallAnApi.at(URL_BASE.toString()));
    }

    @Cuando("^ingrese sus credenciales (.*) y (.*) hacia el servicio de registro$")
    public void ingreseSusCredencialesEveHoltReqresInYPistolHaciaElServicioDeRegistro(String email, String pass) {
        User user = DataInfoUser.createUser(email, pass);
        actor.attemptsTo(
                PostRegister.user(user));
//        dataInfoUser.setProperty(USER_DATA.toString(), user);
        actor.remember(USER_DATA.toString(), user.getEmail());
        System.out.println(user.getEmail());
        System.out.println(user);
    }

    @Cuando("^el usuario se registra exitosamente con el codigo de respuesta (.*)$")
    public void elUsuarioSeRegistraExitosamenteConElCodigoDeRespuesta(int sc) {
        actor.should(
                seeThat("El codigo de respuesta fue exitoso",
                        ResponseCode.was(),
                        equalTo(sc))
        );
    }

    @Entonces("^el puede loguearse en la aplicacion con (.*)$")
    public void santiagoPuedeLoguearseEnLaAplicacionConEveHoltReqresInYContraseña(String passl) {
        actor.attemptsTo(
                PostLogin.user(passl)
        );
    }

    @Entonces("^obtiene un codigo de respuesta (.*) del logueo exitoso en la app$")
    public void obtieneUnCodigoDeRespuestaDelLogueoExitosoEnLaApp(int sc) {
        actor.should(
                seeThat("El codigo de respuesta fue exitoso",
                        ResponseCode.was(),
                        equalTo(sc))
        );
    }
    @Entonces("^el token que responde el logueo no puede estar vacio$")
    public void tokenNoPuedeSerVacio() throws Exception {

        String bodyResponse = actor.recall(LOGE.toString());
        System.out.println(bodyResponse);
//        String token = from(bodyResponse).get("token");
        String token = from(bodyResponse).get("token");

            if (!token.equals("")){
                System.out.println("el token no llego vacio");
            }else {
                throw new Exception("error no llego el token");
            }

    }
}