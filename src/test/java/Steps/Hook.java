package Steps;

import Utils.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.FileOutputStream;
import java.io.IOException;

import static Utils.BaseTest.driver;

public class Hook {
    BaseTest baseTest = new BaseTest();

    @Before
    public void testStart() {
        System.out.println("------Test Started---------");
    }

    @After
    public void TearDownTest(Scenario scenario) throws IOException {
        String path = null;

        if (scenario.isFailed()) {
            System.out.println(scenario.getName());
            String scFileName = "ScreenShot_" + System.currentTimeMillis();
            path = System.getProperty("user.dir") + "\\report\\" + scFileName + ".png";
            byte[] screenshot = baseTest.TakeScreenShot(path);
            scenario.attach(screenshot, "image/png", "image");
            driver.close();
            driver.quit();
        }else{
            driver.close();
            driver.quit();
        }
    }
}
