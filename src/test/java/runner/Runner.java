package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        snippets = SnippetType.CAMELCASE,
        glue = {"stepDefinitions"}
)
public class Runner {
    private Runner() {
    }


}
