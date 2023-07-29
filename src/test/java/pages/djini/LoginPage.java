package pages.djini;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath ="//input[@id='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-lg']")
    private WebElement enterBtn;

    public MainPage clickTheEnterBtn(){
        click(enterBtn);
        return new MainPage(driver);
    }


    public LoginPage loginUser(User user) {
        setValue(emailField, user.getEmail());
        setValue(passwordField, user.getPass());
        return this;
    }
}
