package uni;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "uni"
//    plugin = {"pretty", "com.epam.reportportal.cucumber.StepReporter"}
)
public class TestRunnerIT {

}
