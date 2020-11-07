package tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PostRegister implements Task {

    private final Object createUser;

    public PostRegister(Object createUser) {
        this.createUser = createUser;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                Post.to("/api/register")
                .with(requestSpecification -> requestSpecification
                        .contentType(ContentType.JSON)
                        .body(createUser))
        );
    }
    public static Performable user(Object createUser) {
        return instrumented(PostRegister.class, createUser);
    }

}
