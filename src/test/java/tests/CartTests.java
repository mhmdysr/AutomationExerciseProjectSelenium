package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;
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
    public void tc_12_addProductsInCart(){
        SoftAssert softAssert=new SoftAssert();
        productPage=new ProductPage(driver);
        cartPage=new CartPage(driver);

        softAssert.assertTrue(productPage.isHomePageVisible(),"Home Page is Not Visible!");
        productPage.goToProductsPage();
        productPage.scrollToBrandsHeader();
        productPage.hoverClickProductByIndex(1,1);
        productPage.clickContinueShoppingBtn();
        productPage.hoverClickProductByIndex(2,3);
        productPage.clickViewCartByIndex(1);

        // Verify both products are added to Cart
        Assert.assertTrue(cartPage.areBothAddedProductsVisible(),"Both products are Not added to Cart ");

        //Verify their prices, quantity and total price

        // first added product

        Assert.assertEquals(cartPage.getPriceToAddedProduct(0),"Rs. 500","The First Product Price not as expected ");
        Assert.assertEquals(cartPage.getQuantityToAddedProduct(0),"1","The First Product Quantity not as expected ");
        Assert.assertEquals(cartPage.getTotalPriceToAddedProduct(0),"Rs. 500","The First Total Product Price not as expected ");

        // second added product
        Assert.assertEquals(cartPage.getPriceToAddedProduct(1),"Rs. 400","The second Product Price not as expected ");
        Assert.assertEquals(cartPage.getQuantityToAddedProduct(1),"1","The second Product Quantity not as expected ");
        Assert.assertEquals(cartPage.getTotalPriceToAddedProduct(1),"Rs. 400","The second Total Product Price not as expected ");






    }
    @Test
    public void  tc_13_verifyProductQuantityInCart(){
        SoftAssert softAssert=new SoftAssert();
        cartPage=new CartPage(driver);
        productPage=new ProductPage(driver);

        softAssert.assertTrue(productPage.isHomePageVisible(),"Home Page is Not Visible!");
        productPage.scrollToBrandsHeader();
        productPage.clickViewProductByIndex(1);

        Assert.assertTrue(productPage.isProductDetailsDisplayed(),"Product Details Elements is Not Visible!");

        //Increase quantity
        productPage.increaseProductQuantity("4");
        productPage.addToCartBtnInProductDetailsPage();
        productPage.clickViewCartByIndex(1);

        // Verify that product is displayed in cart page with exact quantity
        Assert.assertEquals(cartPage.getPriceToAddedProduct(0),"Rs. 500","The First Product Price not as expected ");
        Assert.assertEquals(cartPage.getQuantityToAddedProduct(0),"4","The First Product Quantity not as expected ");
        Assert.assertEquals(cartPage.getTotalPriceToAddedProduct(0),"Rs. 2000","The First Total Product Price not as expected ");


    }

    @Test
    public void  tc_17_removeProductsFromCart(){
        SoftAssert softAssert=new SoftAssert();
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        softAssert.assertTrue(productPage.isHomePageVisible(), "Home Page is Not Visible!");
        productPage.goToProductsPage();
        productPage.scrollToBrandsHeader();
        productPage.hoverClickProductByIndex(1, 1);
        productPage.clickViewCartByIndex(1);
        cartPage.goToCartPage();
        softAssert.assertTrue(cartPage.isCartPageDisplayed(), "Cart Page is Not Visible");

        cartPage.removeAllProducts();
        Assert.assertTrue(cartPage.isCartEmpty(),"Cart is Not Empty");



    }

}
