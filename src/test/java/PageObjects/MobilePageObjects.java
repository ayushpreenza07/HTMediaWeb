package PageObjects;

import Utils.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Dimension;

import java.net.MalformedURLException;
import java.net.URL;

public class MobilePageObjects extends BaseTest {

    public By userButton = By.xpath("//android.widget.Button[@text='user']");
    public By loginButton = By.xpath("//android.view.MenuItem[@text='dropdown icon Login']");
    public By userName = By.xpath("//android.widget.EditText[@text='']");
    public By Continue = By.xpath("//android.widget.Button[@text='Continue']");
    public By password = By.xpath("//android.widget.EditText[@text='']");
    public By loginContinue = By.xpath("//android.widget.Button[@text='Continue']");
    public By sideBar = By.xpath("//android.widget.Button[@text='menu']");
    public By userProfile = By.xpath("//android.widget.Image[@text='profile']");
    public By logoutBtn = By.xpath("//android.view.View[@text='Logout']");

    public void clickUser() {
        WebDriverWait wait = new WebDriverWait(androidDriver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(userButton));
        androidDriver.findElement(userButton).click();
    }

    public void clickLogin() {
        WebDriverWait wait = new WebDriverWait(androidDriver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        androidDriver.findElement(loginButton).click();
    }

    public void enterUserName(String user) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(androidDriver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(userName));
        androidDriver.findElement(userName).click();
        Thread.sleep(3000);
        Actions actions = new Actions(androidDriver);

        actions.sendKeys(androidDriver.findElement(userName), user).build().perform();

    }

    public void enterPassword(String pass) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(androidDriver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(password));
        Dimension sizeBefore = androidDriver.manage().window().getSize();
        androidDriver.findElement(password).click();
        Actions actions = new Actions(androidDriver);

        actions.sendKeys(androidDriver.findElement(password), pass).build().perform();
        androidDriver.navigate().back();
//        Dimension sizeAfter = androidDriver.manage().window().getSize();
//
//        // Compare the sizes to determine if the keyboard is open
//        boolean isKeyboardOpen = sizeBefore.getHeight() > sizeAfter.getHeight();
//
//        System.out.println("Is keyboard open: " + isKeyboardOpen);
//        if(isKeyboardOpen){
//            androidDriver.navigate().back();
//        }
    }

    public void clickContinue() throws InterruptedException {
        Thread.sleep(5000);
//        WebDriverWait wait = new WebDriverWait(androidDriver, 30);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(Continue));
//        androidDriver.findElement(Continue).click();

        MobileElement element = androidDriver.findElement(Continue);
        AndroidTouchAction touch = new AndroidTouchAction(androidDriver);
        touch.tap(TapOptions.tapOptions()
                        .withElement(ElementOption.element(element)))
                .perform();
    }

    public void clickLoginContinue() throws InterruptedException {
        Thread.sleep(5000);
//        WebDriverWait wait = new WebDriverWait(androidDriver, 30);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(loginContinue));
//        androidDriver.findElement(loginContinue).click();

        MobileElement element = androidDriver.findElement(Continue);
        AndroidTouchAction touch = new AndroidTouchAction(androidDriver);
        touch.tap(TapOptions.tapOptions()
                        .withElement(ElementOption.element(element)))
                .perform();
    }

    public void clickSidebar() {
        WebDriverWait wait = new WebDriverWait(androidDriver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(sideBar));
        androidDriver.findElement(sideBar).click();
    }

    public void clickUserProfile() {
        WebDriverWait wait = new WebDriverWait(androidDriver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(userProfile));
        androidDriver.findElement(userProfile).click();
    }

    public void clickLogout() {
        WebDriverWait wait = new WebDriverWait(androidDriver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutBtn));
        androidDriver.findElement(logoutBtn).click();
    }


}

