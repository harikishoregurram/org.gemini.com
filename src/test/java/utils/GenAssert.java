package utils;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.actions.WaitUtil;

public class GenAssert {
    public static void assertContains(WebElement element, String... list) {
        WaitUtil.waitForVisible(element);
        for (String str : list) {
            Assert.assertTrue(element.getText().contains(str));
        }
    }

    public static void assertContains(WebElement element, String str) {
        WaitUtil.waitForVisible(element);
        Assert.assertTrue(element.getText().contains(str));
    }

    public static void assertContains(String source, String content) {
        Assert.assertTrue(source.contains(content));
    }
}
