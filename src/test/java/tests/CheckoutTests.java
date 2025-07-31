package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.CartPage;
import pages.CheckoutPage;
import pages.ProductPage;
import pages.SignupPage;
import utils.CommonMethods;

public class CheckoutTests extends BaseTest {

    CheckoutPage checkoutPage;
    ProductPage productPage;
    SignupPage signupPage;
    CartPage cartPage;

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




    }
}
