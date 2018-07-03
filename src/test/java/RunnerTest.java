import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@CucumberOptions(
        features = "src/test/features",
        glue = {"steps","."},
        tags = {"@test"},
        plugin = {"steps.SetupSteps"},
        format = {"pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        })

@RunWith(Cucumber.class)
public class RunnerTest {
}
