package pages;

import driver.DriverPoll;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

abstract public class BasePage {


    protected WebDriverWait wait;
    private int BASE_WAIT = 5;

    public BasePage() {
        wait = new WebDriverWait(DriverPoll.getDriver(), Duration.ofSeconds(15));
        PageFactory.initElements(DriverPoll.getDriver(), this);
    }

    protected WebElement waitUntilElementToBeVisibleByXpath(String locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    protected Boolean waitUntilElementToBeInvisibilityByXpath(String locator) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
    }

    protected WebElement waitUntilElementToBeClickableByXpath(String locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }

    protected WebElement waitUntilPresenceOfElementByXpath(String locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    protected List<WebElement> waitUntilPresenceOfAllElementsByXpath(String locator) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator)));
    }





//    public void goToNextTab(int tabNumber) {
//        waitUntilNumberOfTabToBe(tabNumber);
//        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(tabs.get(tabNumber - 1));
//    }

    public void waitUntilNumberOfTabToBe(int tabNumber) {
        wait.until(ExpectedConditions.numberOfWindowsToBe(tabNumber));
    }

    @SneakyThrows
    public void waitTillCircleLoaderDisappear(String locator) {
        waitUntilElementToBeInvisibilityByXpath(locator);
        Thread.sleep(100);
    }

    @SneakyThrows
    public void waitTillVehicleLoaderDisappear(String locator) {
        waitUntilElementToBeInvisibilityByXpath(locator);
        Thread.sleep(100);
    }

    @SneakyThrows
    public void waitTillButtonLoaderDisappear(String locator) {
        waitUntilElementToBeInvisibilityByXpath(locator);
        Thread.sleep(100);
    }

    protected void click(WebElement element) {
       wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void setValue(WebElement element, String value){
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(value);
    }

//    public String getURL() {
//        return driver.getCurrentUrl();
//    }
}
