package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.CommonLocators;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    private final By loginToYourAccVisibleText = By.xpath("//h2[text()='Login to your account']");
    private final By emailAddressField = By.cssSelector("input[data-qa='login-email']");
    private final By passwordField = By.cssSelector("input[data-qa='login-password']");
    private final By loginBtn = By.cssSelector("button[data-qa='login-button']");
    private final By yourEmailOrPasswordIncorrectVisibleText = By.xpath("//p[text()='Your email or password is incorrect!']");

    //Methods
    public Boolean isHomePageVisible() {
        return isElementDisplayed(CommonLocators.homePageText);
    }
    public void goToSignInPage() {
        click(CommonLocators.signInLoginLink);
    }

    public Boolean isLoginToYourAccTextVisible() {
       return isElementDisplayed(loginToYourAccVisibleText);
    }
    public void enterLoginData(String email, String password) {
        type(emailAddressField, email);
        type(passwordField, password);
    }

    public void clickLoginBtn() {
        click(loginBtn);
    }

    public String getLoggedAsActualName() {
        return getText(CommonLocators.loggedInAsText);
    }


    //TC_3
    public Boolean isYourEmailOrPasswordIncorrectTextVisible() {
        return isElementDisplayed(yourEmailOrPasswordIncorrectVisibleText);
    }

}
