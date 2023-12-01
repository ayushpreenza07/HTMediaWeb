package PageObjects;

import Utils.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RegressionObjects extends BaseTest {

    By Loader = By.xpath("//IMG[@src='https://images.ottplay.com/static/newImages/new_spinner_mini.svg?format=webp']");
    By SonyLiv =By.xpath("//img[@alt='SonyLIV']");
    By StreaminNowFilters = By.xpath("//li[@role='menuitem']/a[contains(text(),'Releases')]");
    By SignInApple = By.xpath("//a[@class='icap']");
    public void verifyHomePage() {
        try {
            driver.findElement(By.xpath("(//span[contains(text(),'Home')])[1]")).isDisplayed();
        } catch (Throwable e) {
            Assert.fail("User is not on home page");
        }
    }

    public void verifyNoLoader(){
        boolean verify=false;
        try {
            verify = driver.findElement(Loader).isDisplayed();
        }catch(Exception e){

        }
        if(verify){
            Assert.fail("Loader issue");
        }
    }

    public void streamingNowFilters(){
        try{
            driver.findElement(StreaminNowFilters);
        }catch(Exception e){
            Assert.fail(e.getMessage());
        }
    }

    public void noDuplicateWidgets(){
        List<WebElement> element= driver.findElements((SonyLiv));

        if(element.size()>1){
            Assert.fail("duplicate data available");
        }
    }

    public void signInApple(String flag){
        WebDriverWait wait = new WebDriverWait(driver, 25);
        wait.until(ExpectedConditions.visibilityOfElementLocated(SignInApple));
        driver.findElement(By.xpath("//a[contains(text(),'"+flag+"')]")).click();
    }

    public void redirection(String site) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        String url = driver.getCurrentUrl();
        site = site.toLowerCase();
        System.out.println(site);

        switch (site){
            case "google":{
                if(!url.contains(site)){
                    Assert.fail("not redirected to "+site);
                }
            }
            break;

            case "apple":{
                if(!url.contains(site)){
                    Assert.fail("not redirected to "+site);
                }
            }
            break;

            case "facebook":{
                String parent = driver.getWindowHandle();
                ArrayList<String> newTab = new ArrayList<>(driver.getWindowHandles());

                // change focus to new tab
                driver.switchTo().window(newTab.get(1));
                Thread.sleep(5000);
                System.out.println("second tab - " + driver.getCurrentUrl());
                String newUrl = driver.getCurrentUrl();
                if (!newUrl.contains(site)) {
                    Assert.fail("Not redirected to "+ site);
                }
                driver.close();
                // change focus back to old tab
                driver.switchTo().window(parent);
            }
            break;

        }

        driver.navigate().back();
    }

}
