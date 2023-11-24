package PageObjects;

import Utils.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class SanityPageObject extends BaseTest {
    public By logoutBtn = By.xpath("//span[contains(text(),'Logout')]");
    public By FacingIssuePlayHere = By.xpath("//A[@class='movieDescription_issuePlayHere__RMs5a'][text()='Play Here']");
    public By searchBar = By.xpath("//INPUT[@id='searchFeild']");
    public By seeAllResult = By.xpath("//SPAN[@class='searchDropdown_seeAllTitle__niBOx']");
    public By storiesPageFilters = By.xpath("//span[@class='MuiButton-label'][contains(text(),'All Type')]");
    public By filterOptions = By.xpath("//span[@class='MuiButton-label'][contains(text(),'All Languages')]");

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

    public void searchContent(String search) {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar));

        driver.findElement(searchBar).sendKeys(search);
    }

    public void clickSeeAllResult() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(seeAllResult));
        driver.findElement(seeAllResult).click();
        Thread.sleep(5000);
    }

    public void clickMoviesShows() throws InterruptedException {
        String[] arr = {"Movie", "Show", "Live TV", "Sport", "Cast & Crew", "Stories"};

        String buttons = "//SPAN[@class='MuiButton-label']";
        List<WebElement> rows = driver.findElements(By.xpath(buttons));
        System.out.println(rows.size());
        for (WebElement row : rows) {
            for (int i = 0; i <= arr.length - 1; i++) {
                if (row.getText().equals(arr[i])) {
                    row.click();
                    Thread.sleep(2000);
                }
            }
        }
    }

    public void verifyFilters() {
        try {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.findElement(filterOptions).isDisplayed();
        } catch (Throwable e) {
            Assert.fail("Filters not displayed");
        }
    }

    public void verifyFilterOnStoriesPage() {
        try {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.findElement(storiesPageFilters).isDisplayed();
        } catch (Throwable e) {
            Assert.fail("Filters not displayed");
        }
    }
}

