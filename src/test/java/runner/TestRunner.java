package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        // --- INI YANG KITA KEMBALIKAN ---
        features = "src/test/resources/features",
        // --------------------------------

        glue = {"steps.web", "steps.api"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber-reports.json"
        },
        monochrome = true
)
public class TestRunner {
}