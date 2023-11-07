package Steps;

import PageObjects.LoginPageObject;
import Utils.BaseTest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;

public class Login extends LoginPageObject {

    @Given("^I navigate to application$")
    public void iNavigateToApplication() {
        try {
            BaseTest.setUp();
            BaseTest.driver.get("https://www.ottplay.com/");
            BaseTest.driver.manage().window().maximize();
        }catch (Throwable e){

        }
    }

    @And("^I click on Sign In button$")
    public void iClickOnSignInButton() {
        try {
            ClickSignIn();
        }catch (Throwable e) {

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
    public void i_Click_on_Premium(){
        clickPremium();
    }

    @Then("^Select \"([^\"]*)\"")
    public void select_platform(String platform) throws InterruptedException {
        System.out.println(platform);
        selectChannel(platform);
        Thread.sleep(5000);
    }

    @Then("^select first show$")
    public void select_first_show(){
        clickFirstShow();
    }
}
