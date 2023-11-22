package PageObjects;

import Utils.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.*;

public class SanityPageObject extends BaseTest {
    public By logoutBtn = By.xpath("//span[contains(text(),'Logout')]");
    public By FacingIssuePlayHere = By.xpath("//A[@class='movieDescription_issuePlayHere__RMs5a'][text()='Play Here']");

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
    public void facingIssuesLink() throws InterruptedException {
        String parent = driver.getWindowHandle();
        System.out.println(parent);
        System.out.println(driver.getTitle());
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(FacingIssuePlayHere));
        driver.findElement(FacingIssuePlayHere).click();
        Thread.sleep(10000);

        ArrayList<String> newTab = new ArrayList<>(driver.getWindowHandles());
        System.out.println(newTab.size());
        for (int i = 0; i <= newTab.size() - 1; i++) {
            System.out.println("windows - " + " " + i + " " + newTab.get(i));
        }
        // change focus to new tab
        driver.switchTo().window(newTab.get(1));
        Thread.sleep(5000);
        System.out.println("second tab - " + driver.getCurrentUrl());
        String newUrl = driver.getCurrentUrl();
        if (!newUrl.contains("sony")) {
            Assert.fail("Not redirected to sony liv page");
        }
        driver.close();
        // change focus back to old tab
        driver.switchTo().window(parent);
    }

}
