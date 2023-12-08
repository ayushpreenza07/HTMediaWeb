package Steps;

import PageObjects.MobilePageObjects;
import Utils.BaseTest;
import io.cucumber.java.en.And;
import Utils.BaseTest;

public class MobileSteps extends MobilePageObjects {

    @And("launch in mobile browser")
    public void launch_in_mobileBrowser() {
            BaseTest.launchApplicationInMobileBrowser("https://www.ottplay.com/");
    }

}
