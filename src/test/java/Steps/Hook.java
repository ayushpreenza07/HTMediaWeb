package Steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import static Utils.BaseTest.driver;

public class Hook {

    @Before
    public void testStart(){
        System.out.println("------Test Started---------");
    }
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
