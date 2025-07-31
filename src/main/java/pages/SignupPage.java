package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.CommonLocators;


public class SignupPage extends BasePage {

    public SignupPage(WebDriver driver) {
        super(driver);
    }


    //Locators
    private final By newUserSignupText = By.xpath("//h2[text()='New User Signup!']");
    private final By enterAccountInfoText = By.xpath("//b[text()='Enter Account Information']");
    private final By initialNameField = By.cssSelector("input[type='text']");
    private final By emailAddressField = By.cssSelector("input[data-qa='signup-email']");
    private final By signupSubmitBtn = By.cssSelector("button[data-qa='signup-button']");


    // Locators (adjust these to match your application)
    private final By titleMrRadio = By.id("id_gender1"); // Example: 'Mr' radio button
    private final By titleMrsRadio = By.id("id_gender2"); // Example: 'Mrs' radio button
    private final By nameField = By.id("name");
    private final By passwordField = By.id("password");


    // Date of birth dropdown locators
    private final By dayDropdown = By.id("days");
    private final By monthDropdown = By.id("months");
    private final By yearDropdown = By.id("years");

    //more data
    private final By newsletterCheckBox = By.id("newsletter");
    private final By offersCheckBox = By.id("optin");

    //Address Information Locators
    private final By firstNameField = By.id("first_name");
    private final By lastNameField = By.id("last_name");
    private final By companyNameField = By.id("company");
    private final By address1Field = By.id("address1");
    private final By address2Field = By.id("address2");
    private final By countryDropDown = By.id("country");
    private final By stateField = By.id("state");
    private final By cityField = By.id("city");
    private final By zipcodeField = By.id("zipcode");
    private final By mobNumberField = By.id("mobile_number");
    private final By createAccBtn = By.cssSelector("button[data-qa='create-account']");
    private final By accountCreatedText = By.xpath("//b[text()='Account Created!']");
    private final By continueBtn = By.cssSelector("div[class='pull-right']");
    private final By deleteAccountLink = By.linkText("Delete Account");
    private final By accountDeletedText = By.xpath("//b[text()='Account Deleted!']");
    private final By emailAlreadyExistText = By.xpath("//p[text()='Email Address already exist!']"); //TC5


    //Methods

    public boolean isHomePageDisplayed() {
        return isElementDisplayed(CommonLocators.homePageText);
    }

    //Enter Account Information
    public void goToSignInPage() {
        click(CommonLocators.signInLoginLink);
    }

    public Boolean isNewUserSignupDisplayed() {
        return isElementDisplayed(newUserSignupText);
    }

    public void setUserNameAndEmailAddress(String userName, String userEmail) {
        type(initialNameField, userName);
        type(emailAddressField, userEmail);
    }

    public void clickSignupSubmitBtn() {
        click(signupSubmitBtn);
    }

    public Boolean isEnterAccountInfoTextDisplayed() {
        return isElementDisplayed(enterAccountInfoText);
    }

    public void fillAccountInformation(String title, String name, String password, int dayIndex, int monthIndex, int yearIndex) {

        // Select the title based on input value
        if (title.equalsIgnoreCase("Mr")) {
            click(titleMrRadio);
        } else if (title.equalsIgnoreCase("Mrs")) {
            click(titleMrsRadio);


        }

        // Fill in name and password
        type(nameField, name);
        type(passwordField, password);

        // Wait for day/month/year dropdown to be clickable, then select
        selectDropdownByIndex(dayDropdown, dayIndex);
        selectDropdownByIndex(monthDropdown, monthIndex);
        selectDropdownByIndex(yearDropdown, yearIndex);

    }

    public void scrollToNewsletterCheckBox() {
        scrollToElement(newsletterCheckBox);
    }

    public void clickNewsletterCheckBox() {
        click(newsletterCheckBox);
    }

    public void clickOffersCheckBox() {
        click(offersCheckBox);
    }

    //Address Information
    public void fillAccountAddressInformation(String fName, String lName, String companyName, String address1, String address2, int countryIndex, String stateName, String cityName, String zipCode, String ph) {
        // First name, Last name and Company.

        type(firstNameField, fName);
        type(lastNameField, lName);
        type(companyNameField, companyName);

        //Send Address, Address2, Country, State and City

        type(address1Field, address1);
        type(address2Field, address2);
        selectDropdownByIndex(countryDropDown, countryIndex);

        type(stateField, stateName);
        type(cityField, cityName);

        // Send Zipcode and Mobile Number.
        type(zipcodeField, zipCode);
        type(mobNumberField, ph);

    }

    public void submitCreateAccountBtn() {
        click(createAccBtn);
    }

    //Delete Account
    public Boolean isAccountCreated() {
        return isElementDisplayed(accountCreatedText);
    }

    public void clickContinueBtn() {
        click(continueBtn);
    }

    public String getLoggedAsActualName() {
        return getText(CommonLocators.loggedInAsText);
    }

    public void deleteAccount() {
        click(deleteAccountLink);
    }

    public Boolean isAccountDeleted() {

        return isElementDisplayed(accountDeletedText);


    }

    // Register User with existing email (TC_5)
    public Boolean isEmailAlreadyExistTextVisible() {
        return isElementDisplayed(emailAlreadyExistText);
    }


}
