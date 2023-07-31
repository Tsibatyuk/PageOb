package tests;

import abstractpages.Listener;
import driver.Browser;
import driver.DriverFactory;
import driver.DriverPoll;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import utiles.Config;
import utiles.PropertiesUtil;


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



//
//    protected static String env;
//    protected static String grid;
//    protected static String headless;
//    protected static Capabilities capabilities;
//    protected static List<String> options;
//    protected static WebDriverPool driverPool = new LooseWebDriverPool();
//    protected Logger logger = LoggerFactory.getLogger(this.getClass());
//    protected WebDriver driver;
//    protected LoginPage loginPage;
//    protected String deployedAppVersion = "";
//
//
//
//
//
//
//    protected static String grid;
//    protected static String headless;
//    protected static Capabilities capabilities;
//    protected static List<String> options;
//    protected static WebDriverPool driverPool = new LooseWebDriverPool();
//    protected Logger logger = LoggerFactory.getLogger(this.getClass());
//    protected org.openqa.selenium.WebDriver driver;
//
//
//    @BeforeSuite(alwaysRun = true)
//    @SneakyThrows
//    public void initTestSuite() {
//        SuiteConfiguration config = new SuiteConfiguration();
//        env = config.getProperty("site.url");
//        grid = config.getProperty("grid.url");
//        headless = config.getProperty("headless");
//        capabilities = config.getCapabilities();
//        options = config.getOptions();
//        setupWebDriver(config);
//    }
//
//
//
//
//    @BeforeMethod(alwaysRun = true)
//    public void prepareForTestMethod(Method method) {
//        initWebDriver(method);
//        logger.info("----- Method name: " + method.getName() + " -----");
//        loginPage = new LoginPage(driver).open(env);
//
//        if (method.getAnnotation(FinancialDateDependency.class) != null) {
//            LockingDateHelper.initDates(env);
//            logger.info("Financial date: " + LockingDateHelper.getAvailableFinancialDate());
//            logger.info("Executive date: " + LockingDateHelper.getAvailableExecutiveDate());
//        }
//    }
//
//    @SneakyThrows
//    private void initWebDriver(Method method) {
//        if (headless.equals("--headless")) {
//            options.add(headless);
//        }
//
//        DriverOptions driverOptions = new DriverOptions(capabilities, options);
//        if (grid.isEmpty()) {
//            driver = driverPool.getDriver(driverOptions.getOptions());
//        } else {
//            driver = driverPool.getDriver(new URL(grid), driverOptions.getOptions());
//        }
//        driver.manage().window().maximize();
//        logger.info("----- WebDriver initialized -----" + method.getName());
//    }

    //type name of the browser you're using in this variable (chrome or firefox)
//    private static final String BROWSER_NAME = "firefox";
//    //put false here if you want to see browser or true to headless mode
//    private final boolean headless = false;
//
//    @BeforeMethod
//    public void setUp() throws Exception {
//        switch (BROWSER_NAME) {
//            case ("chrome") -> {
//                ChromeOptions chromeOptions = new ChromeOptions();
//                chromeOptions.setHeadless(headless);
//                WebDriverManager.chromedriver().setup();
//                driver = new ChromeDriver(chromeOptions);
//                if (!headless) {
//                    driver.manage().window().maximize();
//                }
//            }
//            case ("firefox") -> {
//                FirefoxOptions firefoxOptions = new FirefoxOptions();
//                firefoxOptions.setHeadless(headless);
//                WebDriverManager.firefoxdriver().setup();
//                driver = new FirefoxDriver(firefoxOptions);
//                driver.manage().window().maximize();
//                if (!headless) {
//                    driver.manage().window().maximize();
//                }
//            }
//            default -> throw new Exception("You chose not valid browser!");
//        }
//    }
//    public void sleep(int seconds) {
//        try {
//            Thread.sleep(seconds * 1000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void scroll(int pixels) {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0," + pixels + ")", "");
//    }
//
//    public void switchToTab(int tabNumber) {
//        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(tab.get(tabNumber - 1));
//    }
//
//    public void goBack() {
//        driver.navigate().back();
//    }
//
//    public void switchToNextTab() {
//        driver.getWindowHandles().forEach(tab -> driver.switchTo().window(tab));
//    }
//
//    @AfterMethod
//    public void closeWindow() {
//        driver.quit();
//    }
//
//    public WebDriver getDriver() {
//        return driver;
//    }
//
//
//
//
//
//    public boolean urlContains(String urlPath) {
//        return driver.getCurrentUrl().contains(urlPath);
//    }

//    @BeforeMethod
//    public void setUpDriver() {
//        WebDriver driver = DriverFactory.getDriver(Browser.CHROME);
//        DriverPoll.setWebDriver(driver);
//        Config.setBaseUrl(PropertiesUtil.getProperty("url"));
//    }
//
//    @AfterMethod
//    public void quiteDriver() {
//        DriverPoll.quitDriver();
//    }

}
