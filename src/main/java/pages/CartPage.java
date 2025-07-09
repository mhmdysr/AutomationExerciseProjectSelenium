package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.CommonLocators;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }


    //Locators =>TC12: Add Products in Cart[product +cart]
    private final By firstAddedProduct=By.linkText("Blue Top");
    private final By secondAddedProduct=By.linkText("Men Tshirt");



    //Methods TC11=>Verify Subscription in Cart page
    public Boolean isHomePageVisible(){

        return isElementDisplayed(CommonLocators.homePageText);
    }
    public void goToCartPage(){
        click(CommonLocators.carTLink);
    }
    //Methods =>TC12: Add Products in Cart[product+cart]
    //public Boolean areBothAddedProductsVisible(){

        //firstAddedProduct
        //secondAddedProduct
    //}







}
