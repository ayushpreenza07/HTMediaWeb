package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/java/Feature"}, plugin = {"pretty", "html:target/cucumber"},
        glue = "Steps",tags = "@sonyliv")
public class TestRunner extends AbstractTestNGCucumberTests {

}
