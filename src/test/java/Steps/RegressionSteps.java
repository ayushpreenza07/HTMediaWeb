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
}
