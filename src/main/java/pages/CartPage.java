package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.CommonLocators;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }


    //Locators =>TC12: Add Products in Cart[product +cart]
    private final By firstAddedProduct=By.linkText("Blue Top");
    private final By secondAddedProduct=By.linkText("Men Tshirt");
    private final By priceCellsToAddedProduct=By.xpath("//td[@class='cart_price']");
    private  final By quantityInputsToAddedProduct=By.xpath("//td[@class='cart_quantity']");
    private  final By totalPriceCellsToAddedProduct=By.xpath("//td[@class='cart_total']");
    private final By shoppingCartHeader= By.xpath("//*[text()='Shopping Cart']");
    private final By proceedToCheckoutBtn=By.cssSelector("a[class='btn btn-default check_out']");
    private final By signupLoginLink=By.linkText("Register / Login");





    //Methods TC11=>Verify Subscription in Cart page
    public Boolean isHomePageVisible(){

        return isElementDisplayed(CommonLocators.homePageText);
    }
    public void goToCartPage(){
        click(CommonLocators.carTLink);
    }

    //Methods =>TC12: Add Products in Cart[product+cart]
    public Boolean areBothAddedProductsVisible(){
        return isElementDisplayed(firstAddedProduct) && isElementDisplayed(secondAddedProduct);
    }


    //verifyTheirPricesQuantityAndTotalPrice from the Cart Page
    public String getPriceToAddedProduct(int index ){
        return driver.findElements(priceCellsToAddedProduct).get(index).getText();

    }
    public String getQuantityToAddedProduct(int index ){

        return driver.findElements(quantityInputsToAddedProduct).get(index).getText();

    }
    public String getTotalPriceToAddedProduct(int index ){

        return driver.findElements(totalPriceCellsToAddedProduct).get(index).getText();

    }

    //Methods =>TC14: Place Order: Register while Checkout

    public boolean isCartPageDisplayed(){
        return isElementDisplayed(shoppingCartHeader);
    }
    public void clickProceedToCheckout(){
        click(proceedToCheckoutBtn);
    }
    public void clickSignupLoginLink(){
        click(signupLoginLink);
    }

    //TC16: Place Order: Login before Checkout









}
