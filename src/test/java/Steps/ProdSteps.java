package Steps;

import PageObjects.ProdObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ProdSteps extends ProdObjects {

    @And("Verify Live News, Sports, Entertainment channels, Live Music, Regional, Spiritual on Live Tv")
    public void Verify_live_News() {
        verifyLiveShows();
    }

    @And("^enter \"([^\"]*)\" in search box")
    public void enter_in_search_box(String searchText) {
        clickSearchAndEnter(searchText);
    }

    @And("^click on searchPage \"([^\"]*)\"")
    public void click_on_searchPage(String platform) {
        clickPlatform(platform);
    }

    @And("Verify Live TV Tamil and Telugu")
    public void Verify_Live_TV_Tamil_and_Telugu() {
        verifyTamilAndTeluguShows();
    }

    @Then("click on profile Icon")
    public void click_on_profile_Icon() {
        clickProfileIcon();
    }
    @And("verify Settings are present")
    public void verify_Settings_are_present(){
        verifySettings();
    }
}
