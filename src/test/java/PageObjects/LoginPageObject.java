package PageObjects;

import Utils.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginPageObject extends BaseTest {

    public By SignInButton=By.xpath("//div[@class='ottplay-83'][text()='Login/Register']");
    public By UserNameButton=By.xpath("//INPUT[@id='phoneEmail']");
    public By Continue = By.xpath("//INPUT[@id='btSubmit']");
    public By PasswordButton=By.xpath("//INPUT[@id='upass']");
    public By Login = By.xpath("//INPUT[@id='btnLogin']");
    public By Premium = By.xpath("(//SPAN[@class='ottplay-108 false false'])[2]");

    public By firstShow = By.xpath("(//DIV[@class='subscriptionBanner_landscapeCard__grid__actionDetails__EIps_'])[1]");
    public void ClickSignIn()
    {
        try {
            refreshPage();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            WebDriverWait wait = new WebDriverWait(BaseTest.driver, 25);
            wait.until(ExpectedConditions.visibilityOfElementLocated(SignInButton));
            boolean displayed = driver.findElement(SignInButton).isDisplayed();
            if(displayed)
                driver.findElement(SignInButton).click();
        }catch(Exception e) {
            Assert.fail("failed on signin");
        }
    }

    public void refreshPage(){
        try {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            boolean displayed = driver.findElement(SignInButton).isDisplayed();
            if(!displayed)
                driver.navigate().refresh();
        }catch(Exception e) {

        }
    }

    public void enterUserName(String userName){
        driver.findElement(UserNameButton).sendKeys(userName);
    }

    public void clickContinue(){
        driver.findElement(Continue).click();
    }

    public void enterPassword(String password){
        driver.findElement(PasswordButton).sendKeys(password);
    }

    public void clickLogin(){
        driver.findElement(Login).click();
    }

    public void clickPremium(){
        WebDriverWait wait = new WebDriverWait(driver, 25);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Premium));
        driver.findElement(Premium).click();
    }

    public void selectChannel(String asset) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String xpath = "//img[contains(@src, 'https://images.ottplay.com/images/"+asset+"logohoz')]";
        System.out.println(xpath);
        JavascriptExecutor jsx = (JavascriptExecutor)driver;
        jsx.executeScript("window.scrollBy(0,450)", "");
        Thread.sleep(5000);
//        jsx.executeScript("arguments[0].click();", xpath);
        driver.findElement(By.xpath(xpath)).click();
    }

    public void clickFirstShow(){
        WebDriverWait wait = new WebDriverWait(driver, 25);
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstShow));
        driver.findElement(firstShow).click();
    }
}
