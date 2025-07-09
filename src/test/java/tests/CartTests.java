package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import utils.CommonMethods;

public class CartTests extends BaseTest {


    CartPage cartPage;
    HomePage subscriptionPage;
    ProductPage productPage;

    @Test void tc_11_verifySubscriptionInCartPage(){
        SoftAssert softAssert=new SoftAssert();
        cartPage=new CartPage(driver);
        subscriptionPage=new HomePage(driver);


        softAssert.assertTrue(subscriptionPage.isHomePageVisible(),"Home Page is Not Visible!");
        cartPage.goToCartPage();
        subscriptionPage.scrollDownToFooter();
        softAssert.assertTrue(subscriptionPage.isSubscriptionTextVisible(),"Subscription Text is Not Visible!");

        // call random Email
        subscriptionPage.subscribeToNewsletter(CommonMethods.generateRandomEmail());

        //Verify success message 'You have been successfully subscribed!' is visible
        softAssert.assertTrue(subscriptionPage.isSubscribedSuccessfulTextVisible(),"The Subscription msg is Not Visible!");
        String actualResults=subscriptionPage.getSuccessSubscribeMessage();
        String expectedResults="You have been successfully subscribed!";
        softAssert.assertEquals(actualResults,expectedResults,"You have been successfully subscribed! Text is Not Visible!");

    }
    @Test
    public void tc_02_addProductsInCart(){
        SoftAssert softAssert=new SoftAssert();
        productPage=new ProductPage(driver);
        cartPage=new CartPage(driver);

        Assert.assertTrue(productPage.isHomePageVisible(),"Home Page is Not Visible!");
        productPage.goToProductsPage();
        productPage.scrollToBrandsHeader();
        productPage.hoverClickProductByIndex(1,1);
        productPage.clickContinueShoppingBtn();
        productPage.hoverClickProductByIndex(2,1);
        productPage.clickViewProductByIndex(1);

        // Verify both products are added to Cart
        //Assert.assertTrue(cartPage.areBothAddedProductsVisible(),"Both products are Not added to Cart ");
//
//        //Verify their prices, quantity and total price
//
//        // first added product
//        Assert.assertEquals(productsPage.getPrice(0),"Rs. 500","The First Product Price not as expected ");
//        Assert.assertEquals(productsPage.getQuantity(0),"1","The First Product Quantity not as expected ");
//        Assert.assertEquals(productsPage.getTotalPrice(0),"Rs. 500","The First Total Product Price not as expected ");
//
//        // second added product
//        Assert.assertEquals(productsPage.getPrice(1),"Rs. 400","The second Product Price not as expected ");
//        Assert.assertEquals(productsPage.getQuantity(1),"1","The second Product Quantity not as expected ");
//        Assert.assertEquals(productsPage.getTotalPrice(1),"Rs. 400","The second Total Product Price not as expected ");






    }
}
