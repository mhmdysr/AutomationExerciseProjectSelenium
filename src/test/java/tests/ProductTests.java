package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ProductPage;

public class ProductTests extends BaseTest {


    ProductPage productPage;
    @Test //TC_8
    public void tc_08_verifyAllProductsAndProductDetailPage(){
        SoftAssert softAssert=new SoftAssert();
        productPage=new ProductPage(driver);

        softAssert.assertTrue(productPage.isHomePageVisible(),"Home Page is Not Visible!");
        productPage.goToProductsPage();
        softAssert.assertTrue(productPage.isAllProductsHeaderDisplayed(),"The ALL PRODUCTS page was not displayed successfully!");
        softAssert.assertTrue(productPage.isProductsListVisible(), "Products list is not visible on the ALL PRODUCTS page.");

        //click first view products
        productPage.scrollToBrandsHeader();
        productPage.clickViewProductByIndex(1);

        //9. Verify that product detail is visible: product name, category, price, availability, condition, brand
        softAssert.assertTrue(productPage.isProductDetailVisible()," product details are Not visible correctly");

        softAssert.assertAll();
//        // Optional: Print for debugging
//        System.out.println("Name: " + productPage.getProductName());
//        System.out.println("Category: " + productPage.getProductCategory());
//        System.out.println("Price: " + productPage.getProductPrice());
//        System.out.println("Availability: " + productPage.getProductAvailability());
//        System.out.println("Condition: " + productPage.getProductCondition());
//        System.out.println("Brand: " + productPage.getProductBrand());






    }

    @Test
    public  void tc_09_searchProduct(){
        SoftAssert softAssert=new SoftAssert();
        productPage=new ProductPage(driver);
        softAssert.assertTrue(productPage.isHomePageVisible(),"Home Page is Not Visible!");
        productPage.goToProductsPage();
        softAssert.assertTrue(productPage.isAllProductsHeaderDisplayed(),"The ALL PRODUCTS page was not displayed successfully!");

        //6. Enter product name in search input and click search button
        productPage.searchWithProductName("Winter Top");
        productPage.clickSearchBtn();
        softAssert.assertTrue(productPage.isSearchedProductsHeaderVisible(),"The Searched Products Header is not displayed successfully!");

        // Print for debugging
        System.out.println("Name: " + productPage.getSearchedProductName());
        System.out.println("Price: " + productPage.getSearchedProductPrice());

        softAssert.assertTrue(productPage.areSearchedProductDetailsVisible(),"No products found in search Displayed");
        softAssert.assertAll();


    }


}
