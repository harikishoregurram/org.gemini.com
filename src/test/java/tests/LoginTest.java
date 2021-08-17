package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import utils.GenAssert;
import utils.ReadQaProps;
import utils.actions.ClickUtil;
import utils.actions.WaitUtil;

import static utils.ReadQaProps.getValue;

public class LoginTest extends BaseClass {
    String url = getValue(ReadQaProps._init().config().get("url"));
    JSONObject validData = ReadQaProps._init().validInput();
    JSONObject invalidData = ReadQaProps._init().invalidInput();

    @Test(description = "Verify that the user able to sign-in successfully")
    public void validRegistration() {
        loginPage.createBusinessAccount();
        registrationPage.fillRegistrationForm(getValue(validData.get("businessName")), 2
                , 2, getValue(validData.get("firstName")), "",
                getValue(validData.get("lastName")), getValue(validData.get("email")));
        WaitUtil.waitForUrl(url + "register/institution/thanks");
        GenAssert.assertContains(driver.getPageSource(), "Thanks for Registering!");
    }

    @Test(description = "Register without entering values")
    public void emptyMandatoryFields() {
        loginPage.createBusinessAccount();
        registrationPage.fillRegistrationForm("", Integer.MAX_VALUE
                , Integer.MAX_VALUE, "", "", "", "");
        String[] list = new String[]{"Legal Business Name is required.", "Company type is required.", "First name is required",
                "Last name is required.", "Please enter a valid email address.", "Company state is required."};
        GenAssert.assertContains(registrationPage.alertBody, list);
    }

    @Test(description = "Enter more than 1000 characters for first name")
    public void invalidFirstName() {
        loginPage.createBusinessAccount();
        registrationPage.fillRegistrationForm(getValue(validData.get("businessName")), 2
                , 2, getValue(invalidData.get("invalidInput")), getValue(validData.get("middleName")),
                getValue(validData.get("lastName")), getValue(validData.get("email")));
        String[] list = new String[]{"your first name may not exceed 1000 characters."};
        GenAssert.assertContains(registrationPage.alertBody, list);
    }

    @Test(description = "Enter more than 1000 characters for middle name")
    public void invalidMiddleName() {
        loginPage.createBusinessAccount();
        registrationPage.fillRegistrationForm(getValue(validData.get("businessName")), 2
                , 2, getValue(validData.get("firstName")), getValue(invalidData.get("invalidInput")),
                getValue(validData.get("lastName")), getValue(validData.get("email")));
        String[] list = new String[]{"your middle name may not exceed 1000 characters."};
        GenAssert.assertContains(registrationPage.alertBody, list);
    }

    @Test(description = "Enter more than 1000 characters for last name")
    public void invalidLastName() {
        loginPage.createBusinessAccount();
        registrationPage.fillRegistrationForm(getValue(validData.get("businessName")), 2
                , 2, getValue(validData.get("firstName")), getValue(validData.get("middleName")),
                getValue(invalidData.get("invalidInput")), getValue(validData.get("email")));
        String[] list = new String[]{"your last name may not exceed 1000 characters."};
        GenAssert.assertContains(registrationPage.alertBody, list);
    }

    @Test(description = "Enter more than 255 characters for Email Id")
    public void invalidEmailId() {
        loginPage.createBusinessAccount();
        registrationPage.fillRegistrationForm(getValue(validData.get("businessName")), 2
                , 2, getValue(validData.get("firstName")), getValue(validData.get("middleName")),
                getValue(validData.get("lastName")), getValue(invalidData.get("invalidInput")));
        String[] list = new String[]{"Please use an email address with only latin characters. Please specify a valid email domain. Please enter an email address less than 255 characters."};
        GenAssert.assertContains(registrationPage.alertBody, list);
    }

    @Test(description = "Verify the tool tip")
    public void validateToolTip() throws InterruptedException {
        loginPage.createBusinessAccount();
        ClickUtil.moveToElement(registrationPage.toolTip);
        WaitUtil.waitForVisible(registrationPage.toolTipContent);
        GenAssert.assertContains(driver.getPageSource(), "We require the signers of an institutional account to submit personal identifying information so that they can be vetted through our compliance KYC protocol. Keeping your personal information secure is extremely important to us. We transmit over encrypted SSL directly to our compliance team.");
    }
}