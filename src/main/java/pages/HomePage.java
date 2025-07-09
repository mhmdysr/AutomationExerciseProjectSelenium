package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.CommonLocators;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Locators =>TC_10: Verify Subscription in home page
    private final By subscriptionText=By.xpath("//h2[text()='Subscription']");
    private final By subscriptionFiled=By.id("susbscribe_email");
    private final By subscriptionBtn=By.cssSelector("i[class='fa fa-arrow-circle-o-right']");
    private final By subscribedSuccessfulMsg=By.id("success-subscribe");



    //Methods =>TC_10: Verify Subscription in home page
    public Boolean isHomePageVisible(){

        return isElementDisplayed(CommonLocators.homePageText);
    }
    public void scrollDownToFooter(){
        scrollToBottomPage();
    }
    public Boolean isSubscriptionTextVisible(){
        return isElementDisplayed(subscriptionText);
    }
    public void subscribeToNewsletter(String email){
        type(subscriptionFiled,email);
        click(subscriptionBtn);
    }
    public Boolean isSubscribedSuccessfulTextVisible(){
        return isElementDisplayed(subscribedSuccessfulMsg);
    }
    public String getSuccessSubscribeMessage(){
        return getText(subscribedSuccessfulMsg);
    }


}
