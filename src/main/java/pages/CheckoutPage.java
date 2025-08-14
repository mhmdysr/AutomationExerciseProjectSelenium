package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
       scrollToElement(payConfirmOrderBtn); click(payConfirmOrderBtn);
    }

    public Boolean isYourOrderPlacedSuccessfullyMessageVisible() {
        return isElementDisplayed(orderPlacedSuccessfullyLocator);

    }

    //TC16: Place Order: Login before Checkout (delivery address=DA)

    //Locators of "Your delivery address" Class
    private final By deliveryName  = By.xpath("//ul[@id='address_delivery']//li[2]");
    private final By deliveryCompany  = By.xpath("//ul[@id='address_delivery']//li[3]");
    private final By deliveryAddressLine1  = By.xpath("//ul[@id='address_delivery']//li[4]");
    private final By deliveryAddressLine2  = By.xpath("//ul[@id='address_delivery']//li[5]");
    private final By deliveryCityStatePostcode  = By.xpath("//ul[@id='address_delivery']//li[6]");
    private final By deliveryCountry  = By.xpath("//ul[@id='address_delivery']//li[7]");
    private final By deliveryPhone  = By.xpath("//ul[@id='address_delivery']//li[8]");

    //Locators of "Your billing address" Class
    private final By billingName  = By.xpath("//ul[@id='address_invoice']//li[2]");
    private final By billingCompany  = By.xpath("//ul[@id='address_invoice']//li[3]");
    private final By billingAddressLine1  = By.xpath("//ul[@id='address_invoice']//li[4]");
    private final By billingAddressLine2 = By.xpath("//ul[@id='address_invoice']//li[5]");
    private final By billingCityStatePostcode    = By.xpath("//ul[@id='address_invoice']//li[6]");
    private final By billingCountry  = By.xpath("//ul[@id='address_invoice']//li[7]");
    private final By billingPhone  = By.xpath("//ul[@id='address_invoice']//li[8]");

    // Methods to get Delivery Address text
    public String getDeliveryName() { return getText(deliveryName); }
    public String getDeliveryCompany() { return getText(deliveryCompany); }
    public String getDeliveryAddressLine1() { return getText(deliveryAddressLine1); }
    public String getDeliveryAddressLine2() { return getText(deliveryAddressLine2); }
    public String getDeliveryCityStatePostcode() { return getText(deliveryCityStatePostcode); }
    public String getDeliveryCountry() { return getText(deliveryCountry); }
    public String getDeliveryPhone() { return getText(deliveryPhone); }

    // Methods to get Billing Address text
    public String getBillingName() { return getText(billingName); }
    public String getBillingCompany() { return getText(billingCompany); }
    public String getBillingAddressLine1() { return getText(billingAddressLine1); }
    public String getBillingAddressLine2() { return getText(billingAddressLine2); }
    public String getBillingCityStatePostcode() { return getText(billingCityStatePostcode); }
    public String getBillingCountry() { return getText(billingCountry); }
    public String getBillingPhone() { return getText(billingPhone); }





}
