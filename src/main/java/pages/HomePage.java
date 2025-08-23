package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

    //Locators =>TC_18: View Category Products



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


    //Test Case 18: View Category Products

    private final By categoryHeader=By.xpath("//h2[text()='Category']");
    private final By categoriesClass=By.xpath("//div[@class='panel-group category-products']");
    private By getCategoryTypeByIndex(int index) {
        return By.xpath("(//span[@class='badge pull-right'])["+index+"]");
    }
    public By getMainCategoryByIndex(int index) {
        return By.cssSelector("[href='/category_products/" + index + "']");
    }
    private final By womenDressProductsText=By.cssSelector("[class='title text-center']");
    private final By menJeansProductsText=By.cssSelector("[class='title text-center']");




    public void scrollToCategoryHeader(){
        scrollToElement(categoryHeader);
    }
    public Boolean areCategoriesDisplayed(){
        return isElementDisplayed(categoriesClass);
    }

    public void clickWomenCategory(){
        click(getCategoryTypeByIndex(1));

    }
    public void clickDressLink(){
        click(getMainCategoryByIndex(1));
    }

    public Boolean isWomenDressProductsHeaderVisible(){
        return isElementDisplayed(womenDressProductsText);
    }
    public void clickMenCategory(){
        click(getCategoryTypeByIndex(2));

    }
    public void clickJeansLink(){
       click( getMainCategoryByIndex(6));
    }
    public Boolean isMenJeansProductsTextVisible(){
        return isElementDisplayed(menJeansProductsText);
    }



}
