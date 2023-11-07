package PageObjects;

import Utils.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class FunctionalitiesObject extends BaseTest {

    public By resumeButton = By.xpath("//span[contains(text(),'Resume')]");
    public By fullScreenButton = By.xpath("//i[@class='fullScreen']");
    public By nextEpisodeButton = By.xpath("//span[contains(text(),'Next Episode ')]");
    public By OttPlayBrandLogo = By.xpath("//img[@alt='ottplay logo']");
    public By playButton = By.xpath("//span[@class='movieDescription_playtext__U0wBf']");
    public By seekBar = By.xpath("//div[@class='playerslider']");
    public By backButton = By.xpath("//span[@class='videoBackBtn']");
    public By showTitle = By.xpath("//div[@class='topBarPlayer topbarplayerA']//h2");

    public void clickResume() {
        try {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            WebDriverWait wait = new WebDriverWait(BaseTest.driver, 25);
            wait.until(ExpectedConditions.visibilityOfElementLocated(playButton));
            boolean displayed = driver.findElement(playButton).isDisplayed();
            if (displayed)
                driver.findElement(playButton).click();
            else {
                wait.until(ExpectedConditions.visibilityOfElementLocated(resumeButton));
                boolean displayed1 = driver.findElement(resumeButton).isDisplayed();
                if (displayed1)
                    driver.findElement(resumeButton).click();
                driver.findElement(resumeButton).click();
            }
        } catch (Exception e) {
            Assert.fail("Play button not clicked");
        }
    }

    public void clickFullscreen() {
        try {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            WebDriverWait wait = new WebDriverWait(BaseTest.driver, 25);
            wait.until(ExpectedConditions.visibilityOfElementLocated(fullScreenButton));
            boolean displayed = driver.findElement(fullScreenButton).isDisplayed();
            if (displayed)
                driver.findElement(fullScreenButton).click();
        } catch (Throwable e) {
            Assert.fail("full screen button not displayed");
        }
    }

    public void verifyFastForward() {
        try {
            Actions builder = new Actions(driver);
            WebElement from = driver.findElement(By.id("column-a"));
            WebElement to = driver.findElement(By.id("column-b"));
//Perform drag and drop
            builder.dragAndDrop(from, to).perform();
        } catch (Throwable e) {
            Assert.fail("fast forward is not verified");
        }

    }

    public void nextEpisode() {
        try {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            WebDriverWait wait = new WebDriverWait(BaseTest.driver, 25);
            wait.until(ExpectedConditions.visibilityOfElementLocated(nextEpisodeButton));
            boolean displayed = driver.findElement(nextEpisodeButton).isDisplayed();
            if (displayed)
                driver.findElement(nextEpisodeButton).click();
        } catch (Throwable e) {
            Assert.fail("next episode button not displayed/working");
        }
    }

    public void verifyottbrandLogo() {
        try {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.findElement(OttPlayBrandLogo).isDisplayed();
        } catch (Throwable e) {
            Assert.fail("OTT Play brand logo not displayed");
        }
    }

    public void verifyUserOnNextEpisode(String titleName) {
        String TitleName1 = driver.findElement(showTitle).getText();
        System.out.println("Title Name - " + TitleName1);
        if ((Objects.equals(titleName, TitleName1))) {
            Assert.fail("User is not directed to next episode");
        }
    }

    public void verifySeekBar() {
        try {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.findElement(seekBar).isDisplayed();
        } catch (Throwable e) {
            Assert.fail("fSeek bar not displayed");
        }
    }

    public void verifyBackButton() {
        try {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            boolean displayed = driver.findElement(backButton).isDisplayed();
            if (displayed)
                driver.findElement(backButton).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("(//span[contains(text(),'Home')])[1]")).isDisplayed();

        } catch (Throwable e) {
            Assert.fail("Back button not displayed/working");
        }
    }

    public String getTitleName() {
        String TitleName = driver.findElement(showTitle).getText();
        System.out.println("Title Name - " + TitleName);
        return TitleName;
    }
}