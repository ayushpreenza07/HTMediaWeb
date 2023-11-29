package Steps;

import PageObjects.RegressionObjects;
import io.cucumber.java.en_scouse.An;

public class RegressionSteps extends RegressionObjects {
    @An("verify user is logged in")
    public void verify_user_is_logged_in() {
        verifyHomePage();
    }
}
