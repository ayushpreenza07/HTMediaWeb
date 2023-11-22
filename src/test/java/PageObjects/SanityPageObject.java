package PageObjects;

import Utils.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SanityPageObject extends BaseTest {
    public By logoutBtn = By.xpath("//span[contains(text(),'Logout')]");

    public void clickLogoutBtn() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 50);
            wait.until(ExpectedConditions.visibilityOfElementLocated(logoutBtn));
            driver.findElement(logoutBtn).click();
        } catch (Throwable e) {
            Assert.fail("User Icon not clicked");
        }
    }

    public void selectVendor(String asset) throws InterruptedException {
        try {
            String xpath = "//img[contains(@src, '" + asset + "')]";
            System.out.println(xpath);
            WebElement element = driver.findElement(By.xpath(xpath));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            Thread.sleep(5000);
            WebDriverWait wait = new WebDriverWait(driver, 50);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            driver.findElement(By.xpath(xpath)).click();
        } catch (Throwable e) {
            Assert.fail("Vendor not selected");
        }
    }
}
