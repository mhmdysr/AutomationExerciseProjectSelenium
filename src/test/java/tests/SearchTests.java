package tests;

import base.BasePage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductPage;
import pages.SearchPage;
import utils.ConfigReader;

import java.io.IOException;


public class SearchTests extends BaseTest {

    SearchPage searchPage;
    ProductPage productPage;
    LoginPage loginPage;
    CartPage cartPage;

    @Test
    public void tc_20_searchProductsAndVerifyCartAfterLogin()  {
        SoftAssert softAssert = new SoftAssert();
        String productName = "Winter Top";

        searchPage = new SearchPage(driver);
        productPage = new ProductPage(driver);
        loginPage = new LoginPage(driver);
        cartPage = new CartPage(driver);

        productPage.goToProductsPage();
        softAssert.assertTrue(productPage.isAllProductsHeaderDisplayed(), "The ALL PRODUCTS page was not displayed successfully!");
        searchPage.searchProductWithName(productName);
        searchPage.clickSearchBtn();
        softAssert.assertTrue(searchPage.isSearchedProductsHeaderVisible(), "The Searched Products Header is not displayed successfully!");
        softAssert.assertTrue(searchPage.isProductsListVisible(), "Products list is not visible on the ALL PRODUCTS page.");

        //Add those products to cart
        //productPage.scrollToBrandsHeader();
        productPage.scrollToBottomPage();
        productPage.hoverClickProductByIndex(1, 1);
        productPage.clickViewCartByIndex(1);

        //Verify that products are visible in cart
        softAssert.assertTrue(searchPage.isSearchedProductDisplayed(), "The Searched Product is not displayed!");

        //10. Click 'Signup / Login' button and submit login details
        loginPage.goToSignInPage();
        loginPage.enterLoginData(ConfigReader.getProperty("emailToSearchPage"), ConfigReader.getProperty("passwordToSearchPage"));
        loginPage.clickLoginBtn();
        productPage.acceptAlert();
        cartPage.goToCartPage();
        softAssert.assertTrue(searchPage.isSearchedProductDisplayed(), "The Searched Product is not displayed!");
        softAssert.assertAll();


    }



}
