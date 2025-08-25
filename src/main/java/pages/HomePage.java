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
    private final By subscriptionText = By.xpath("//h2[text()='Subscription']");
    private final By subscriptionFiled = By.id("susbscribe_email");
    private final By subscriptionBtn = By.cssSelector("i[class='fa fa-arrow-circle-o-right']");
    private final By subscribedSuccessfulMsg = By.id("success-subscribe");

    //Locators =>TC_18: View Category Products


    //Methods =>TC_10: Verify Subscription in home page
    public Boolean isHomePageVisible() {

        return isElementDisplayed(CommonLocators.homePageText);
    }

    public void scrollDownToFooter() {
        scrollToBottomPage();
    }

    public Boolean isSubscriptionTextVisible() {
        return isElementDisplayed(subscriptionText);
    }

    public void subscribeToNewsletter(String email) {
        type(subscriptionFiled, email);
        click(subscriptionBtn);
    }

    public Boolean isSubscribedSuccessfulTextVisible() {
        return isElementDisplayed(subscribedSuccessfulMsg);
    }

    public String getSuccessSubscribeMessage() {
        return getText(subscribedSuccessfulMsg);
    }


    //Test Case 18: View Category Products

    private final By categoryHeader = By.xpath("//h2[text()='Category']");
    private final By categoriesClass = By.xpath("//div[@class='panel-group category-products']");

    private By getCategoryTypeByIndex(int index) {
        return By.xpath("(//span[@class='badge pull-right'])[" + index + "]");
    }

    public By getMainCategoryByIndex(int index) {
        return By.cssSelector("[href='/category_products/" + index + "']");
    }

    private final By womenDressProductsText = By.cssSelector("[class='title text-center']");
    private final By menJeansProductsText = By.cssSelector("[class='title text-center']");


    public void scrollToCategoryHeader() {
        scrollToElement(categoryHeader);
    }

    public Boolean areCategoriesDisplayed() {
        return isElementDisplayed(categoriesClass);
    }

    public void clickWomenCategory() {
        click(getCategoryTypeByIndex(1));

    }

    public void clickDressLink() {
        click(getMainCategoryByIndex(1));
    }

    public Boolean isWomenDressProductsHeaderVisible() {
        return isElementDisplayed(womenDressProductsText);
    }

    public void clickMenCategory() {
        click(getCategoryTypeByIndex(2));

    }

    public void clickJeansLink() {
        click(getMainCategoryByIndex(6));
    }

    public Boolean isMenJeansProductsTextVisible() {
        return isElementDisplayed(menJeansProductsText);
    }


    //Test Case 19: View & Cart Brand Products
    private final By brandHeader = By.xpath("//h2[text()='Brands']");

    private By getSubBrandByIndex(int index) {
        return By.xpath("(//*[@class=\"nav nav-pills nav-stacked\"])/li[" + index + "]");
    }

    private final By brandMadameProductsText = By.xpath("//h2[text()='Brand - Madame Products']");
    private final By brandPoloProductsText = By.cssSelector("h2[class='title text-center']");

    public void scrollToBrands() {
        scrollToElement(brandHeader);

    }

    public Boolean areBrandsVisible() {

        return isElementDisplayed(brandHeader);
    }

    public void clickMadameBrand() {
        click(getSubBrandByIndex(3));
    }

    public Boolean isBrandMadameProductsTextVisible() {

        return isElementDisplayed(brandMadameProductsText);
    }

    public void clickPoloBrand() {
        click(getSubBrandByIndex(1));
    }

    public Boolean isBrandPoloProductsTextVisible() {
        return isElementDisplayed(brandPoloProductsText);

    }

    //Test Case 22: Add to cart from Recommended items
    private final By recommendedItemHeader = By.xpath("//h2[text()='recommended items']");

    private By getRecommendedAddToCartBtnByIndex(int index) {
        return By.xpath("(//div[@id='recommended-item-carousel']//*[contains(text(),'Add to cart')])[" + index + "]");
    }

    private final By recommendedViewCartBtn = By.xpath("//*[text()='View Cart']");
    private final By recommendedProductsClass = By.className("cart_product");


    public void scrollToRecommendedItemHeader() {
        scrollToElement(recommendedItemHeader);


    }

    public Boolean isRecommendedItemsTextVisible() {
        try {
            driverWait.until(ExpectedConditions.visibilityOfElementLocated(recommendedItemHeader));
            return true;
        } catch (Exception e) {
            return false;

        }
    }

    public void clickAddToCartBtnFromRecommendationItemsByIndex(int index) {

        click(getRecommendedAddToCartBtnByIndex(index));
    }

    public void clickViewCartBtnFromRecommendationItems() {

        click(recommendedViewCartBtn);
    }

    public int getRecommendedProductsSize() {
        return driver.findElements(recommendedProductsClass).size();
    }


    //TC_25: Verify Scroll Up using 'Arrow' button and Scroll Down functionality &&
    //Test Case 26: Verify Scroll Up without 'Arrow' button and Scroll Down functionality

    private final By arrowBtn = By.cssSelector("[class=\"fa fa-angle-up\"]");

    public void clickArrowBtnToMoveUpward() {
        click(arrowBtn);
    }

    public void scrollUpPageToTop() {
        scrollToTopPage();


    }
}