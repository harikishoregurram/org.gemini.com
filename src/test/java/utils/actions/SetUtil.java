package utils.actions;

import org.openqa.selenium.WebElement;

public class SetUtil {
    public static void setElement(WebElement element, String str) {
        WaitUtil.waitForVisible(element);
        element.sendKeys(str);
    }
}
