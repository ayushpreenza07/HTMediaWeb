package Steps;

import PageObjects.LoginPageObject;
import Utils.BaseTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Login extends LoginPageObject {

    @Given("^I navigate to application$")
    public void iNavigateToApplication() {
        try {
            BaseTest.setUp();
            BaseTest.driver.get("https://www.ottplay.com/");
            BaseTest.driver.manage().window().maximize();
        } catch (Throwable e) {

        }
    }

    @And("^I click on Sign In button$")
    public void iClickOnSignInButton() {
        try {
            ClickSignIn();
        } catch (Throwable e) {

        }
    }

    @And("^I enter username and password$")
    public void enterUserNamePassword(DataTable dataTable) {
        try {

            System.out.println(dataTable);
            List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

            System.out.println(data.get(0).get("username"));

            enterUserName(data.get(0).get("username"));
            clickContinue();
            enterPassword(data.get(0).get("password"));
            clickLogin();
            Thread.sleep(4000);
        } catch (Throwable e) {

        }
    }

    @Then("^I click on Premium$")
    public void i_Click_on_Premium() throws InterruptedException {
//        scrolltoTopOfPage();
        clickPremium();
    }

    @Then("^Select \"([^\"]*)\"")
    public void select_platform(String platform) throws InterruptedException {
        System.out.println(platform);
        selectChannel(platform);
        Thread.sleep(5000);
    }

    @Then("^select first show$")
    public void select_first_show() {
        clickFirstShow();
    }

    @Then("^Play show$")
    public void play_show() {
        playShow();
    }

    @Then("^Pause episode$")
    public void pause_episode() {
        pauseEpisode();
    }

    @Then("verify whether the episode is playing or not")
    public void verifyWhetherTheEpisodeIsPlayingOrNot() throws IOException, InterruptedException {
        try {
            Thread.sleep(2000);
            Assert.assertTrue(testImageComparison(8000), "Episode is Playing");
        } catch (Throwable e) {
            Assert.fail(e.getMessage());
        }

    }

    @Then("Verify whether the episode is paused on pausing it")
    public void verifyWhetherTheEpisodeIsPausedOrNot() throws IOException, InterruptedException {
        episodeIsPausedOnPausingIt();
    }

    @Then("verify fast forward is working")
    public void verify_fast_forward_is_working() throws IOException, InterruptedException {
        verifyFastForwardIsWorking();
    }

    @Then("Go full screen")
    public void go_full_screen() throws IOException, InterruptedException {
        fullScreen();
    }

    @Then("verify backward functionality")
    public void backward_functionality() throws IOException, InterruptedException {
        verifyBackwardIsWorking();
    }
}
