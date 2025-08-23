package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;
import utils.CommonMethods;
import utils.ConfigReader;

public class CheckoutTests extends BaseTest {

    CheckoutPage checkoutPage;
    ProductPage productPage;
    SignupPage signupPage;
    CartPage cartPage;
    LoginPage loginPage;

    @Test
    public void tc_014_placeOrderAndRegisterWhileCheckout() {
        SoftAssert softAssert = new SoftAssert();

        signupPage = new SignupPage(driver);
        productPage = new ProductPage(driver);
        checkoutPage = new CheckoutPage(driver);
        cartPage = new CartPage(driver);

        // set the name/email of user
        String nameOfUser = "Noah";
        String emailOfUser = CommonMethods.generateRandomEmail();

        softAssert.assertTrue(productPage.isHomePageVisible(), "Home Page is Not Visible!");
        productPage.scrollToBrandsHeader();
        productPage.hoverClickProductByIndex(1, 1);
        productPage.clickViewCartByIndex(1);
        softAssert.assertTrue(cartPage.isCartPageDisplayed(), "Cart Page is Not Visible");

        //Cart Page
        cartPage.clickProceedToCheckout();
        cartPage.clickSignupLoginLink();
        //Checkout page
        //==>> Fill all details in Signup and create account
        signupPage.setUserNameAndEmailAddress(nameOfUser, emailOfUser);
        signupPage.clickSignupSubmitBtn();

        softAssert.assertTrue(signupPage.isEnterAccountInfoTextDisplayed(), "Enter Account Information Text is NOT visible!");
        signupPage.fillAccountInformation("Mrs", nameOfUser, "12345678", 1, 1, 1);
        signupPage.scrollToNewsletterCheckBox();
        signupPage.clickNewsletterCheckBox();
        signupPage.clickOffersCheckBox();

        //Address Information
        signupPage.fillAccountAddressInformation("Noor", "Yasser", "Moddakir", "October", "Giza",
                1, "Egypt", "Cairo", "1911", "+2012874");

        //  create account
        signupPage.submitCreateAccountBtn();
        softAssert.assertTrue(signupPage.isAccountCreated(), "Account Created! Text is NOT visible!");
        signupPage.clickContinueBtn();

        //Compare the actual and expected username
        String actualLoggedAsName = signupPage.getLoggedAsActualName();
        String expectedLoggedAsName = "Logged in as " + nameOfUser;
        softAssert.assertEquals(actualLoggedAsName, expectedLoggedAsName, "The Actual Name not as same the Expected Name");

        //Cart Page

        cartPage.goToCartPage();
        cartPage.clickProceedToCheckout();
        //14. Verify Address Details and Review Your Order


        //15. Enter description in comment text area and click 'Place Order'
        checkoutPage.scrollToOrderMessageArea();
        checkoutPage.writeCommentAboutYourOrder("Hi I'm an Arsenal Fan , So you should respect this Club");
        checkoutPage.clickPlaceOrderBtn();

        //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        checkoutPage.fillPaymentDetail("Mohamed yasser","123456789","123","8","25");
        checkoutPage.clickPayAndConfirmOrderBtn();
        softAssert.assertTrue(checkoutPage.isYourOrderPlacedSuccessfullyMessageVisible(),"Your order has been placed successfully! Message is Not Visible");


        //Delete Account
        signupPage.deleteAccount();
        softAssert.assertTrue(signupPage.isAccountDeleted(),"Account Deleted! Text is NOT visible!");
        signupPage.clickContinueBtn();
        softAssert.assertAll();


    }

    @Test
    public void tc_015_placeOrderAndRegisterBeforeCheckout(){
        SoftAssert softAssert = new SoftAssert();

        signupPage = new SignupPage(driver);
        productPage = new ProductPage(driver);
        checkoutPage = new CheckoutPage(driver);
        cartPage = new CartPage(driver);

        // set the name/email of user
        String nameOfUser = "Ali";
        String emailOfUser = CommonMethods.generateRandomEmail();

        softAssert.assertTrue(productPage.isHomePageVisible(), "Home Page is Not Visible!");
        signupPage.goToSignInPage();

        signupPage.setUserNameAndEmailAddress(nameOfUser, emailOfUser);
        signupPage.clickSignupSubmitBtn();
        //5. Fill all details in Signup and create account

        softAssert.assertTrue(signupPage.isEnterAccountInfoTextDisplayed(), "Enter Account Information Text is NOT visible!");
        signupPage.fillAccountInformation("Mrs", nameOfUser, "12345678", 1, 1, 1);
        signupPage.scrollToNewsletterCheckBox();
        signupPage.clickNewsletterCheckBox();
        signupPage.clickOffersCheckBox();

        //Address Information
        signupPage.fillAccountAddressInformation("Nader", "Yasser", "Moddakir", "October", "Giza",
                1, "Egypt", "Cairo", "1911", "+2012874");

        //  create account
        signupPage.submitCreateAccountBtn();
        softAssert.assertTrue(signupPage.isAccountCreated(), "Account Created! Text is NOT visible!");
        signupPage.clickContinueBtn();

        //Compare the actual and expected username
        String actualLoggedAsName = signupPage.getLoggedAsActualName();
        String expectedLoggedAsName = "Logged in as " + nameOfUser;
        softAssert.assertEquals(actualLoggedAsName, expectedLoggedAsName, "The Actual Name not as same the Expected Name");
        softAssert.assertAll();




    }

    @Test
    public void tc_016_placeOrderAndLoginBeforeCheckout(){
        SoftAssert softAssert = new SoftAssert();

        loginPage=new LoginPage(driver);
        productPage = new ProductPage(driver);
        checkoutPage = new CheckoutPage(driver);
        cartPage = new CartPage(driver);
        // set the name/email of user
        String nameOfUser = "Mohamed Morsi";

        softAssert.assertTrue(productPage.isHomePageVisible(), "Home Page is Not Visible!");
        loginPage.goToSignInPage();

        // Enter correct Email and Password then click Login Btn
        loginPage.enterLoginData(ConfigReader.getProperty("getEmail"),ConfigReader.getProperty("getPassword"));
        loginPage.clickLoginBtn();

        //Compare the actual and expected username
        String actualLoggedAsName = loginPage.getLoggedAsActualName();
        String expectedLoggedAsName = "Logged in as " + ConfigReader.getProperty("getNameOfUser");
        softAssert.assertEquals(actualLoggedAsName, expectedLoggedAsName, "The Actual Name not as same the Expected Name");

        productPage.scrollToBrandsHeader();
        productPage.hoverClickProductByIndex(1, 1);
        productPage.clickViewCartByIndex(1);
        cartPage.goToCartPage();
        softAssert.assertTrue(cartPage.isCartPageDisplayed(), "Cart Page is Not Visible");

        //Cart Page
        cartPage.clickProceedToCheckout();
        // Expected Delivery Details
        softAssert.assertEquals(checkoutPage.getDeliveryName(), "Mrs. Mohamed Morsi", "Delivery Name mismatch!");
        softAssert.assertEquals(checkoutPage.getDeliveryCompany(), "GET Group", "Delivery Company mismatch!");
        softAssert.assertEquals(checkoutPage.getDeliveryAddressLine1(), "Maadi", "Delivery Address Line 1 mismatch!");
        softAssert.assertEquals(checkoutPage.getDeliveryAddressLine2(), "Sheraton", "Delivery Address Line 2 mismatch!");
        softAssert.assertEquals(checkoutPage.getDeliveryCityStatePostcode(), "Alx Egypt 32.03", "Delivery City/State/Postcode mismatch!");
        softAssert.assertEquals(checkoutPage.getDeliveryCountry(), "New Zealand", "Delivery Country mismatch!");
        softAssert.assertEquals(checkoutPage.getDeliveryPhone(), "6972305694", "Delivery Phone mismatch!");

        // Expected Billing Details
        softAssert.assertEquals(checkoutPage.getBillingName(), "Mrs. Mohamed Morsi", "Billing Name mismatch!");
        softAssert.assertEquals(checkoutPage.getBillingCompany(), "GET Group", "Billing Company mismatch!");
        softAssert.assertEquals(checkoutPage.getBillingAddressLine1(), "Maadi", "Billing Address Line 1 mismatch!");
        softAssert.assertEquals(checkoutPage.getBillingAddressLine2(), "Sheraton", "Billing Address Line 2 mismatch!");
        softAssert.assertEquals(checkoutPage.getBillingCityStatePostcode(), "Alx Egypt 32.03", "Billing City/State/Postcode mismatch!");
        softAssert.assertEquals(checkoutPage.getBillingCountry(), "New Zealand", "Billing Country mismatch!");
        softAssert.assertEquals(checkoutPage.getBillingPhone(), "6972305694", "Billing Phone mismatch!");



        // 12. Enter description in comment text area and click 'Place Order'
        checkoutPage.scrollToOrderMessageArea();
        checkoutPage.writeCommentAboutYourOrder("Hello Everyone This My the 16th Test Case ");
        checkoutPage.clickPlaceOrderBtn();

        //13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        checkoutPage.fillPaymentDetail("Mohamed Morsi","123456781","789","8","29");
        checkoutPage.clickPayAndConfirmOrderBtn();
        softAssert.assertTrue(checkoutPage.isYourOrderPlacedSuccessfullyMessageVisible(),"Your order has been placed successfully! Message is Not Visible");
        // i will not delete the ACC i  need it LOL
        softAssert.assertAll();





    }

}
