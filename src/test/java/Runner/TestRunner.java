package Runner;

import Utils.BaseTest;
import io.cucumber.java.After;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import static Utils.BaseTest.driver;

@CucumberOptions(features = {"src/test/java/Feature"}, plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        glue = "Steps", tags = "@Func1")
public class TestRunner extends AbstractTestNGCucumberTests {


}
