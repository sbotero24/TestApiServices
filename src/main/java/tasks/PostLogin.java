package tasks;

import io.restassured.http.ContentType;
import model.User;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static utils.GenericConstants.LOGE;
import static utils.GenericConstants.USER_DATA;

public class PostLogin implements Task {

    private final String passl;

    public PostLogin(String passl) {
        this.passl = passl;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
       String ema = actor.recall(USER_DATA.toString());
        System.out.println(ema);
        User createUser = User.builder()
                .password(passl)
                .email(ema)
                .build();
        actor.attemptsTo(
                Post.to("/api/login")
                        .with(requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(createUser))
        );
        actor.remember(LOGE.toString(), actor1 -> SerenityRest.lastResponse().body().asString());
    }
    public static Performable user(String passl) {
        return instrumented(PostLogin.class, passl);
    }
}
