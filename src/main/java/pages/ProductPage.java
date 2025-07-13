package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.CommonLocators;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    //Locators=>TC_8 :Verify All Products and product detail page(product page)
    private final By allProductsHeader=By.xpath("//h2[text()='All Products']");
    private final By productsList=By.className("features_items");
    private final By brandsHeader=By.xpath("//h2[text()='Brands']");

    private By getViewProductByIndex(int index) {
        return By.xpath("(//*[text()='View Product'])[" + index + "]");
    }
    private By getViewCartByIndex(int index) {
        return By.xpath("(//*[text()='View Cart'])[" + index + "]");
    }


    //Locators TC_9 =>Search Product
    private final By searchInputField=By.cssSelector("input[id='search_product']");
    private final By searchBtn=By.cssSelector("button[id='submit_search']");
    private final By searchedProductsHeader=By.xpath("//h2[text()='Searched Products']");



    //Methods =>TC_8:Verify All Products and product detail page
    public Boolean isHomePageVisible(){

        return isElementDisplayed(CommonLocators.homePageText);
    }
    public void goToProductsPage(){
        click(CommonLocators.productsLink);
    }
    public Boolean isAllProductsHeaderDisplayed(){
        return isElementDisplayed(allProductsHeader);
    }
    public Boolean isProductsListVisible(){
        return isElementDisplayed(productsList);
    }
    public void scrollToBrandsHeader(){
        scrollToElement(brandsHeader);
    }
    public void clickViewProductByIndex(int index){
        click(getViewProductByIndex(index));


    }
    // Product Details

    public String getProductName() {
        return getText(CommonLocators.productName).trim();
    }

    public String getProductCategory() {
        String fullCategoryText= getText(CommonLocators.productCategory).trim();
        return fullCategoryText.split(":")[1].trim().split(">")[0].trim();

    }

    public String getProductPrice() {
        return  getText(CommonLocators.productPrice).replace("Rs.","").trim();

    }

    public String getProductAvailability() {
        return getText(CommonLocators.productAvailability).replace("Availability:", "").trim();
    }

    public String getProductCondition() {
        return getText(CommonLocators.productCondition).replace("Condition:", "").trim();
    }

    public String getProductBrand() {
        return getText(CommonLocators.productBrand).replace("Brand:", "").trim();
    }

    public Boolean isProductDetailVisible(){
        return isElementDisplayed(CommonLocators.productName)
                && isElementDisplayed(CommonLocators.productCategory)
                && isElementDisplayed(CommonLocators.productPrice)
                && isElementDisplayed(CommonLocators.productAvailability)
                && isElementDisplayed(CommonLocators.productCondition)
                && isElementDisplayed(CommonLocators.productBrand);
    }

    //Methods TC_9 =>Search Product
    public void searchWithProductName(String productName){
        type(searchInputField,productName);

    }
    public void clickSearchBtn(){
        click(searchBtn);
    }
    public Boolean isSearchedProductsHeaderVisible(){

        return isElementDisplayed(searchedProductsHeader);
    }

    //Methods to get values of searched products
    public String getSearchedProductName() {
        return getText(CommonLocators.searchedProductName).trim();
    }
    public String getSearchedProductPrice() {
        return  getText(CommonLocators.searchedProductPrice).replace("Rs.","").trim();

    }

    public Boolean areSearchedProductDetailsVisible(){
        return isElementDisplayed(CommonLocators.searchedProductName)
                && isElementDisplayed(CommonLocators.searchedProductPrice);
    }
    //Locators  TC12=>Add Products in Cart

    private By addToCartBtnByIndex(int index) {
        return By.xpath("(//*[contains(text(),'Add to cart')])["+index+"]");
    }
    private By singleProductByIndex(int index) {
        return By.xpath("(//div[@class='single-products'])["+index+"]");
    }
    private final By continueShoppingBtn=By.xpath("//button[contains(text(),'Continue Shopping')]");

    //Methods -TC12=> Add Products in Cart
    public void hoverClickProductByIndex(int hoverIndex,int clickIndex){
        hoverOverElementAndClick(singleProductByIndex(hoverIndex),addToCartBtnByIndex(clickIndex));

    }
    public void clickContinueShoppingBtn(){
        click(continueShoppingBtn);
    }
    public void clickViewCartByIndex(int index){
        click(getViewCartByIndex(index));


    }










}
