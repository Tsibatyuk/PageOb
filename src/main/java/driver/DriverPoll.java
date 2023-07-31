package driver;

import org.openqa.selenium.WebDriver;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DriverPoll {

    private static final Map<Long, WebDriver> WEB_DRIVER_MAP = new ConcurrentHashMap<>();

    public static void setWebDriver(WebDriver driver) {
        WEB_DRIVER_MAP.put(Thread.currentThread().getId(), driver);
    }

    public static WebDriver getDriver() {
        return WEB_DRIVER_MAP.get(Thread.currentThread().getId());
    }

    public static void quitDriver() {
        getDriver().quit();
        WEB_DRIVER_MAP.remove(Thread.currentThread().getId());
    }
}
