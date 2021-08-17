package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.actions.ClickUtil;
import utils.ReadQaProps;

import static utils.ReadQaProps.getValue;

public class LoginPage extends BasePage {
    WebDriver driver;
    @FindBy(css = "[data-testid=\"goToRegister\"]")
    public WebElement createNewAccount;
    @FindBy(css = "[data-testid=\"cookiePolicyAgreement-close\"]")
    public WebElement cookiePolicyAgreement;
    @FindBy(css = "[data-testid=\"register-go-to-institution-register\"]")
    public WebElement createBusinessAccount;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void createBusinessAccount() {
        String url = getValue(ReadQaProps._init().config().get("url"));
        driver.get(url);
        ClickUtil.click(createNewAccount);
        ClickUtil.clickUsingJS(createBusinessAccount);
        Assert.assertEquals(driver.getCurrentUrl(), url + "register/institution");
    }


}