package pages.djini;

import driver.DriverPoll;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class WelcomePage extends BasePage {

    @FindBy(xpath = "(//a[@class='jobs-push-login-link rounded-link js-analytics-event'])[1]")
    private WebElement enterBtn;

    public LoginPage clickTheEnterBtn() {
        click(enterBtn);
        return new LoginPage();
    }

    public WelcomePage openDjini(){
        DriverPoll.getDriver().get("");
        return this;
    }
}
