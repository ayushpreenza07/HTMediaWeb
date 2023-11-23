package Steps;

import PageObjects.SanityPageObject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.io.IOException;

public class SanitySteps extends SanityPageObject {

    @And("verify user able to logout")
    public void verify_user_able_to_logout() {
        clickLogoutBtn();
    }

    @Then("^click on \"([^\"]*)\" vendor")
    public void click_on_vendor(String platform) throws InterruptedException {
        System.out.println(platform);
        selectVendor(platform);
    }

    @Then("verify facing issues play here link")
    public void verify_facingIssues() throws IOException, InterruptedException {
        Thread.sleep(10000);
        facingIssuesLink();
    }

    @Then("^Search content \"([^\"]*)\"")
    public void click_on_search(String content) throws IOException, InterruptedException {
        searchContent(content);
    }

    @Then("click on see all result")
    public void click_on_seeAll() throws IOException, InterruptedException {
        clickSeeAllResult();
    }

    @Then("click on movies,shows,stories,live tv etc")
    public void click_on_moviesShowsEtc() throws IOException, InterruptedException {
        clickMoviesShows();
    }
}
