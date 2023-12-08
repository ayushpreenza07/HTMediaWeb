package Steps;

import PageObjects.MobilePageObjects;
import Utils.BaseTest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import Utils.BaseTest;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class MobileSteps extends MobilePageObjects {

    @And("launch in mobile browser")
    public void launch_in_mobileBrowser() {
            BaseTest.launchApplicationInMobileBrowser("https://www.ottplay.com/");
    }

    @And("click on user button")
    public void click_on_user() {
        clickUser();
    }

    @And("click login")
    public void click_on_login() {
        clickLogin();
    }

    @And("^I enter username and password in mobile$")
    public void enterUserNamePassword(DataTable dataTable) {
        try {

            System.out.println(dataTable);
            List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

            enterUserName(data.get(0).get("username"));
            clickContinue();
            Thread.sleep(2000);
            enterPassword(data.get(0).get("password"));
            clickLoginContinue();
            Thread.sleep(4000);
        } catch (Throwable e) {
            Assert.fail(e.getMessage());
        }
    }

}
