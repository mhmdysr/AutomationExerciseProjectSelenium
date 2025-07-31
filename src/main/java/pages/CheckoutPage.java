package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }


    //Locators

    private final By textAreaLocator = By.cssSelector("textarea[class='form-control']");
    private final By placeOrderBtn = By.linkText("Place Order");
    private final By nameOnCardField = By.name("name_on_card");
    private final By cardNumberField = By.name("card_number");
    private final By cVCField = By.cssSelector("input[name='cvc']");
    private final By expirationMonthField = By.name("expiry_month");
    private final By expirationYearField = By.name("expiry_year");
    private final By payConfirmOrderBtn = By.cssSelector("button[data-qa='pay-button']");
    private final By orderPlacedSuccessfullyLocator = By.xpath("//*[text()='Congratulations! Your order has been confirmed!']");


    //Methods =>TC_14: Place Order: Register while Checkout

    public void scrollToOrderMessageArea() {
        scrollToElement(textAreaLocator);
    }

    public void writeCommentAboutYourOrder(String orderMessage) {
        type(textAreaLocator, orderMessage);
    }

    public void clickPlaceOrderBtn() {
        click(placeOrderBtn);
    }

    public void fillPaymentDetail(String nameOnCard, String cardNumber, String cvc, String expirationMonth, String expirationYear) {

        type(nameOnCardField, nameOnCard);
        type(cardNumberField, cardNumber);
        type(cVCField, cvc);
        type(expirationMonthField, expirationMonth);
        type(expirationYearField, expirationYear);
    }

    public void clickPayAndConfirmOrderBtn() {
        click(payConfirmOrderBtn);
    }

    public Boolean isYourOrderPlacedSuccessfullyMessageVisible() {
        return isElementDisplayed(orderPlacedSuccessfullyLocator);

    }


}
