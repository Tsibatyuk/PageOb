package pages.djini;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class WelcomePage extends BasePage {

    public WelcomePage(WebDriver driver) {
        super(driver);
    }


    public WelcomePage openDjini() {
        openPage("https://djinni.co/");
        return this;
    }

    @FindBy(xpath = "(//a[@class='jobs-push-login-link rounded-link js-analytics-event'])[1]")
    private WebElement enterBtn;

    public LoginPage clickTheEnterBtn() {
        click(enterBtn);
        return new LoginPage(driver);
    }
}
