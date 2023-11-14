package Utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    public static WebDriver driver;
    public static void setUp() {
        ChromeOptions options=new ChromeOptions();
        Map<String, Object> prefs=new HashMap<String,Object>();
        prefs.put("profile.default_content_setting_values.notifications", 1);
        //1-Allow, 2-Block, 0-default
        options.setExperimentalOption("prefs",prefs);

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//        WebDriverManager.chromedriver().setup();
        options.setHeadless(false);
        driver = new ChromeDriver(options);
    }

    public byte[] TakeScreenShot(String path) throws IOException {
        System.out.println("Screenshot Path: " + path);
        try {
            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            fileOutputStream.write(screenshot);
            fileOutputStream.close();
            return screenshot;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}