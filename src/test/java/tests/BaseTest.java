package tests;

import abstractpages.Listener;
import driver.Browser;
import driver.DriverFactory;
import driver.DriverPoll;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import utiles.Config;
import utiles.PropertiesUtil;

import java.util.ArrayList;


@Listeners(Listener.class)
abstract public class BaseTest{


    @BeforeMethod
    public void setUpDriver() {
        WebDriver driver = DriverFactory.getDriver(Browser.FIREFOX);
        DriverPoll.setWebDriver(driver);
        Config.setBaseUrl(PropertiesUtil.getProperty("url"));
    }

    @AfterMethod
    public void quiteDriver() {
        DriverPoll.quitDriver();
    }

    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void scroll(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) DriverPoll.getDriver();
        js.executeScript("window.scrollBy(0," + pixels + ")", "");
    }

    public void switchToTab(int tabNumber) {
        ArrayList<String> tab = new ArrayList<>(DriverPoll.getDriver().getWindowHandles());
        DriverPoll.getDriver().switchTo().window(tab.get(tabNumber - 1));
    }

    public void goBack() {
        DriverPoll.getDriver().navigate().back();
    }

    public void switchToNextTab() {
        DriverPoll.getDriver().getWindowHandles().forEach(tab -> DriverPoll.getDriver().switchTo().window(tab));
    }


    public boolean urlContains(String urlPath) {
        return DriverPoll.getDriver().getCurrentUrl().contains(urlPath);
    }



}
