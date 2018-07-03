import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import models.AppiumServer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import org.omg.CORBA.Environment;
import steps.SetupEnvi;
import utilities.Settings;

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

    @BeforeClass
    public static void beforeAll() {
//        System.out.print(Settings.getEnviProperty("deviceID"));
        SetupEnvi.initialize();
    }

    @AfterClass
    public static void afterAll() {
        SetupEnvi.tearDown();
    }
}
