package Steps;

import PageObjects.RegressionObjects;
import io.cucumber.java.en.*;


public class RegressionSteps extends RegressionObjects {
    @And("verify user is logged in")
    public void verify_user_is_logged_in() {
        verifyHomePage();
    }

    @Then("verify no loader issue")
    public void verify_no_loader_issue(){
        verifyNoLoader();
    }

    @Then("verify streaming now filters")
    public void verify_streaming_now_filters(){
        streamingNowFilters();
    }

    @Then("verify no duplicate widgets")
    public void verify_no_duplicate_widgets(){
        noDuplicateWidgets();
    }

    @Then("^click sign in with \"([^\"]*)\"")
    public void sign_in_with_various_sites(String text){
        signInApple(text);
    }

    @Then("^verify redirected to \"([^\"]*)\"")
    public void verify_redirection(String platform) throws InterruptedException {
        redirection(platform);
    }
}
