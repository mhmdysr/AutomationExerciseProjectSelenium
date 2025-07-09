package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ManageAccPage extends BasePage {
    //logout
    //Logout Page
    private final By logoutBtn = By.xpath("//*[contains(text(), 'Logout')]");
    private final By loginToYourAccVisibleText = By.xpath("//h2[text()='Login to your account']");


    public ManageAccPage(WebDriver driver) {
        super(driver);
    }

    //Methods
    public void clickLogoutBtn() {
        click(logoutBtn);
    }
    public Boolean isUserLogoutSuccessfully(){
        return isElementDisplayed(loginToYourAccVisibleText);
    }

    //Delete
}
