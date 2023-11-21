package PageObjects;

import Utils.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProdObjects extends BaseTest {

    public By UserIcon = By.xpath("//IMG[@src='https://images.ottplay.com/static/profile2.svg?format=webp']");

    public By ParentalControl=By.xpath("//div/a[text()='Parental Control']");

    public By OttRailList = By.xpath("//div[@class='slick-list']");


    public void clickUserIcon(){
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(UserIcon));
        driver.findElement(UserIcon).click();
    }

    public void verifyParentalControl(){
        try{
            WebDriverWait wait = new WebDriverWait(driver, 25);
            wait.until(ExpectedConditions.visibilityOfElementLocated(ParentalControl));
            WebElement element = driver.findElement(ParentalControl);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            Thread.sleep(5000);
        }catch (Exception e){
            System.out.println(e.getMessage());
            Assert.fail("Parental control not present");
        }
    }

    public void OttRail(){
        boolean flag=false;
        WebDriverWait wait = new WebDriverWait(driver, 25);
        wait.until(ExpectedConditions.visibilityOfElementLocated(OttRailList));

        try {
            for (int i = 0; i <= 5; i++) {
                flag = driver.findElement(By.xpath("//div[@data-index='" + i + "']")).isDisplayed();
                System.out.println(flag);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
            Assert.fail("channels are not present on rail");
        }
        if(!flag){
            Assert.fail("Channels are missing from rail");
        }
    }
}
