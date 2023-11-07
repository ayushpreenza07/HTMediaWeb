package Steps;

import PageObjects.FunctionalitiesObject;
import io.cucumber.java.en.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en_scouse.An;

public class Functionalities extends FunctionalitiesObject {
    String TitleName;

    @Then("play the show")
    public void play_the_show() {
        clickResume();
    }

    @Then("click on fullscreen")
    public void click_on_fullscreen() {
        clickFullscreen();
    }

    @Then("verify fast forward is working")
    public void verify_fast_forward() {
        verifyFastForward();
    }

    @Then("click on next episode")
    public void click_on_next_episode() {
        nextEpisode();
    }

    @And("verify ott play brand logo")
    public void verify_ott_play_brand_logo() {
        verifyottbrandLogo();
    }

    @And("verify user is on next page")
    public void verify_user_is_on_next_page() {
        verifyUserOnNextEpisode(TitleName);
    }

    @And("verify seek bar")
    public void verify_seek_bar() {
        verifySeekBar();
    }

    @And("verify back button")
    public void verify_back_button() {
        verifyBackButton();
    }

    @And("Get the title of show")
    public void Get_the_title_of_show() {
        String TitleName = getTitleName();
    }

}