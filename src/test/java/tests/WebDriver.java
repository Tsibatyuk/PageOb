package tests;


import abstractpages.BrowserName;
import abstractpages.SuiteConfiguration;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.EdgeDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import io.github.bonigarcia.wdm.managers.OperaDriverManager;
import lombok.SneakyThrows;
import org.openqa.selenium.Capabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.stqa.selenium.factory.LooseWebDriverPool;
import ru.stqa.selenium.factory.WebDriverPool;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.List;

public class WebDriver extends SuiteConfiguration {

    public WebDriver() throws IOException {
    }

    public static void setupWebDriver(SuiteConfiguration suiteConfiguration) {
        String s = suiteConfiguration.getCapabilities().getBrowserName();
        switch (s) {
            case BrowserName.CHROME:
                ChromeDriverManager.chromedriver()
                        .setup();
                break;
            case BrowserName.FIREFOX:
                FirefoxDriverManager
                        .firefoxdriver()
                        .setup();
                break;
            case BrowserName.OPERA:
                OperaDriverManager
                        .operadriver()
                        .setup();
                break;
            case BrowserName.EDGE:
                EdgeDriverManager
                        .edgedriver()
                        .setup();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + s);
        }
    }

}
