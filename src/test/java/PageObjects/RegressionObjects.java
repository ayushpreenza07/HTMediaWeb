package PageObjects;

import Utils.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;

public class RegressionObjects extends BaseTest {

    public void verifyHomePage() {
        try {
            driver.findElement(By.xpath("(//span[contains(text(),'Home')])[1]")).isDisplayed();
        } catch (Throwable e) {
            Assert.fail("User is not on home page");
        }
    }
}
