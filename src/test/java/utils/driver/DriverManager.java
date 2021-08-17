package utils.driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    static WebDriver driver;

    private DriverManager() {

    }

    public static void init() {
        if (driver == null) {
            driver = DriverFactory.init();
        }
    }

    public static WebDriver getDriver() {
        init();
        return driver;
    }
}
