package PageObjects;

import Utils.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.html5.RemoteWebStorage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static PageObjects.LoginPageObject.action;
import static Utils.BaseTest.driver;

public class ProdObjects {

    public By liveHindiNewsHeading = By.xpath("//h3[contains(text(),'Live Hindi News')]");
    public By liveSportsHeading = By.xpath("//h3[contains(text(),'Live Sports')]");
    public By regionalNewsHeading = By.xpath("//h3[contains(text(),'Regional News')]");

    public By SearchBar = By.xpath("(//input[@class='ottplay-47'])[1]");
    public By TamilShow = By.xpath("//div[contains(text(),'Zee Tamil HD')]");
    public By profileIcon = By.xpath("(//div[@class='ottplay-83'])[1]");
    public By settingOptions = By.xpath("//div[contains(text(),'Settings')]");

    public void verifyLiveShows() {
        try {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            WebDriverWait wait = new WebDriverWait(BaseTest.driver, 25);
            wait.until(ExpectedConditions.visibilityOfElementLocated(liveHindiNewsHeading));
            driver.findElement(liveHindiNewsHeading).isDisplayed();
            driver.findElement(liveSportsHeading).isDisplayed();
//            driver.findElement(regionalNewsHeading).isDisplayed();
        } catch (Throwable e) {
            Assert.fail("Live Shows not displayed");
        }
    }

    public void clickSearchAndEnter(String platform) {
        try {
            Thread.sleep(4000);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            WebDriverWait wait = new WebDriverWait(BaseTest.driver, 25);
            wait.until(ExpectedConditions.visibilityOfElementLocated(SearchBar));
            driver.findElement(SearchBar).sendKeys(platform);
            Actions action = new Actions(driver);
            action.sendKeys(Keys.ENTER).build().perform();
            Thread.sleep(5000);
        } catch (Throwable e) {
            Assert.fail("Search not working");
        }
    }

    public void clickPlatform(String platform) {
        try {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            WebDriverWait wait = new WebDriverWait(BaseTest.driver, 25);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + platform + "')]")));
            boolean displayed = driver.findElement(By.xpath("//span[contains(text(),'" + platform + "')]")).isDisplayed();
            if (displayed) {

                driver.findElement(By.xpath("//span[contains(text(),'" + platform + "')]")).click();
            }
        } catch (Throwable e) {
            Assert.fail("Platform not clicked");
        }
    }

    public void verifyTamilAndTeluguShows() {
        try {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.findElement(TamilShow).isDisplayed();
        } catch (Throwable e) {
            Assert.fail("Telugu and Tamil shows not verified");
        }
    }

    public void clickProfileIcon() {
        try {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            WebDriverWait wait = new WebDriverWait(BaseTest.driver, 25);
            wait.until(ExpectedConditions.visibilityOfElementLocated(profileIcon));
            boolean displayed = driver.findElement(profileIcon).isDisplayed();
            if (displayed) {
                driver.findElement(profileIcon).click();
            }
        } catch (Throwable e) {
            Assert.fail("Profile Icon not displayed");
        }
    }
    public void verifySettings(){
        try {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.findElement(settingOptions).isDisplayed();
        } catch (Throwable e) {
            Assert.fail("Setting options not available");
        }
    }
}