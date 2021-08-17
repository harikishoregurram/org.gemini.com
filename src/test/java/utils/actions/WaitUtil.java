package utils.actions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utils.driver.DriverManager.getDriver;

public class WaitUtil {
    static WebDriverWait wait = new WebDriverWait(getDriver(), 10);

    public static void waitForVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForUrl(String str) {
        wait.until(ExpectedConditions.urlContains(str));
    }
}
