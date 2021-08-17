package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.LoginPage;
import pages.RegistrationPage;
import utils.actions.ClickUtil;
import utils.driver.DriverManager;
import utils.ReadQaProps;

import java.util.concurrent.TimeUnit;

import static utils.ReadQaProps.getValue;

public class BaseClass {
    WebDriver driver;
    LoginPage loginPage;
    RegistrationPage registrationPage;

    @BeforeClass
    public void setUp() {
        driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        driver.get(getValue(ReadQaProps._init().config().get("url")));
        ClickUtil.click(loginPage.createNewAccount);
        loginPage.cookiePolicyAgreement.click();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}