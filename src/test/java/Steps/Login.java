package Steps;

import Utils.BaseTest;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login extends BaseTest {

    @Given("^I navigate to application$")
    public void iNavigateToApplication() {
        try {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.ottplay.com/");
            driver.manage().window().maximize();
        }catch (Throwable e) {

        }
    }
}
