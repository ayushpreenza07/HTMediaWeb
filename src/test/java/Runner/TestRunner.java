package Runner;

import Utils.BaseTest;
import io.cucumber.java.After;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import static Utils.BaseTest.driver;

@CucumberOptions(features = {"src/test/java/Feature"}, plugin = {"pretty", "html:target/cucumber"},
        glue = "Steps",tags = "@sonyliv")
public class TestRunner extends AbstractTestNGCucumberTests {


}
