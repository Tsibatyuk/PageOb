package tests.djini;


import org.testng.annotations.Test;
import pages.djini.User;
import pages.djini.WelcomePage;
import tests.BaseTest;

public class RegistrationTests extends BaseTest {

    @Test
    public void registrationTest2() {
        WelcomePage welcomePage = new WelcomePage();

        welcomePage
                .openDjini()
                .clickTheEnterBtn()
                .loginUser(User.builder().build())
                .clickTheEnterBtn()
                .checkTheUrl();
    }

}
