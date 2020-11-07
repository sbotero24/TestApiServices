package questions;

import io.restassured.path.json.JsonPath;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ResponseBody implements Question<JsonPath> {

    @Override
    public JsonPath answeredBy(Actor actor) {
        return SerenityRest.lastResponse().jsonPath();
    }
}
