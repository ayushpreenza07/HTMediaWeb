package PageObjects;

import Utils.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class RegressionObjects extends BaseTest {

    By Loader = By.xpath("//IMG[@src='https://images.ottplay.com/static/newImages/new_spinner_mini.svg?format=webp']");
    By SonyLiv =By.xpath("//img[@alt='SonyLIV']");
    By StreaminNowFilters = By.xpath("//li[@role='menuitem']/a[contains(text(),'Releases')]");
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

}
