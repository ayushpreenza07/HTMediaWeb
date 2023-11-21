package Steps;

import PageObjects.ProdObjects;
import io.cucumber.java.en.Then;

import java.io.IOException;

public class ProdSteps extends ProdObjects {

    @Then("I click on User icon")
    public void click_userIcon() throws IOException, InterruptedException {
        Thread.sleep(15000);
        clickUserIcon();
    }

    @Then("verify Parental control is present")
    public void verify_parentalControl() throws IOException, InterruptedException {
        verifyParentalControl();
    }

    @Then("verify Ott channels rail")
    public void verifyOttRail(){
        OttRail();
    }
}

