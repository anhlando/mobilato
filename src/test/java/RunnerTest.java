import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import models.Environment;
import utilities.Helper;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps"},
        tags = {"@test"},
        plugin = {"steps.Hook"},
        format = {"pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        })

@RunWith(Cucumber.class)
public class RunnerTest {
    private static Environment environment;

    @BeforeClass
    public static void beforeAll() {
        Helper.log("Start test...");
        environment = new Environment();
        environment.initialize();
    }

    @AfterClass
    public static void afterAll() {
        Helper.log("End test!!!");
        Environment.cleanup();
    }
}
