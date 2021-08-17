package utils.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ReadQaProps;

import static utils.ReadQaProps.getValue;

public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver init() {
        String _driver = getValue(ReadQaProps._init().config().get("driver"));
        if (_driver.equals(Drivers.chrome.name())) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (_driver.equals(Drivers.firefox.name())) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        return driver;
    }
}

enum Drivers {
    chrome,
    firefox
}
