package pages.djini;

import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }
    public MainPage checkTheUrl(){

       return this;
    }
}
