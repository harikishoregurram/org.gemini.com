package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.actions.ClickUtil;
import utils.actions.SetUtil;
import utils.actions.WaitUtil;

import java.util.List;

public class RegistrationPage extends BasePage {

    @FindBy(css = "[name=\"company.legalName\"]")
    public WebElement legalBusinessName;
    @FindBy(css = "[class=\"companyTypeDropdown css-2b097c-container\"]")
    public WebElement companyTypeDropDown;
    @FindBy(css = "[id^=\"react-select-2-option-\"]")
    public List<WebElement> companyTypeOptions;
    @FindBy(css = "[id^=\"react-select-3-option\"]")
    public List<WebElement> countryOptions;
    @FindBy(css = "[id^=\"react-select-3-option\"]")
    public WebElement countryOption;
    @FindBy(css = "[id^=\"react-select-6-option\"]")
    public List<WebElement> stateOptions;
    @FindBy(css = "[class^=\"usStateDropdown__control\"]")
    public WebElement stateDropDown;
    @FindBy(css = "[data-testid=\"countryDropdown-label\"] [class$=\"container\"]")
    public WebElement countryDropDown;
    @FindBy(css = "[name=\"personal.legalName.firstName\"]")
    public WebElement legalFirstName;
    @FindBy(css = "[name=\"personal.legalName.middleName\"]")
    public WebElement legalMiddleName;
    @FindBy(css = "[name=\"personal.legalName.lastName\"]")
    public WebElement legalLastName;
    @FindBy(css = "[name=\"personal.email\"]")
    public WebElement email;
    @FindBy(css = "[data-testid=\"InstitutionSubmit\"]")
    public WebElement submit;
    @FindBy(css = "[class=\"AlertBody\"]")
    public WebElement alertBody;
    @FindBy(css = "[class=\"FieldSetToolTip Tooltip Style-Default\"] a")
    public WebElement toolTip;
    @FindBy(css = "[class=\"Content FreeWidth\"]")
    public WebElement toolTipContent;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void fillRegistrationForm(String businessName, int companyType, int country
            , String firstName, String middleName, String lastName, String _email) {
        SetUtil.setElement(legalBusinessName, businessName);
        if (companyType != Integer.MAX_VALUE) {
            ClickUtil.click(companyTypeDropDown);
            ClickUtil.click(companyTypeOptions.get(companyType));
        }
        if (country != Integer.MAX_VALUE) {
            countryDropDown.click();
            WaitUtil.waitForVisible(countryOption);
            countryOptions.get(country).click();
        }
        SetUtil.setElement(legalFirstName, firstName);
        SetUtil.setElement(legalMiddleName, middleName);
        SetUtil.setElement(legalLastName, lastName);
        SetUtil.setElement(email, _email);
        ClickUtil.clickUsingJS(submit);
    }

}