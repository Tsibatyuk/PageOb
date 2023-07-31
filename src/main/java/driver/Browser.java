package driver;

public enum Browser {
    CHROME("chrome"), FIREFOX("firefox"), OPERA("opera"), EDGE("edge");
    private final String browser;

    Browser(String browser) {
        this.browser = browser;
    }

    public String getBrowser() {
        return browser;
    }
}
