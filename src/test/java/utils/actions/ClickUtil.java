package utils.actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static utils.driver.DriverManager.getDriver;

public class ClickUtil {
    public static void click(WebElement element) {
        WaitUtil.waitForVisible(element);
        element.click();
    }

    public static void clickUsingJS(WebElement element) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", element);
    }

    public static void moveToElement(WebElement element) throws InterruptedException {
        WaitUtil.waitForVisible(element);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", element);
        Thread.sleep(500);
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).build().perform();
    }
}
