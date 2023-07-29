package tests.djini;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import pages.djini.User;
import pages.djini.WelcomePage;
import tests.BaseTest;

public class Registration extends BaseTest {

    @Test
    public void registrationTest2(ITestContext context) {
        WelcomePage welcomePage = new WelcomePage(driver);
        context.getAttribute("hi");

        welcomePage
                .openDjini()
                .clickTheEnterBtn()
                .loginUser(User.builder().build())
                .clickTheEnterBtn()
                .checkTheUrl();



    }

}
