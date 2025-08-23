package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import utils.CommonMethods;

public class HomeTests extends BaseTest {

    HomePage subscriptionPage;
    HomePage categoryPage;


    @Test
    public void tc_10_verifySubscriptionInHomePage(){
        SoftAssert softAssert=new SoftAssert();
        subscriptionPage=new HomePage(driver);

        softAssert.assertTrue(subscriptionPage.isHomePageVisible(),"Home Page is Not Visible!");
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
    public void tc_18_viewCategoryProducts(){
        SoftAssert softAssert=new SoftAssert();
        categoryPage=new HomePage(driver);

        categoryPage.scrollToCategoryHeader();
        softAssert.assertTrue(categoryPage.areCategoriesDisplayed(),"Categories are NOT visible on left side bar");

        //Click on any category link under 'Women' category, for example: Dress and verify the navigated page
        categoryPage.clickWomenCategory();
        categoryPage.clickDressLink();
        softAssert.assertTrue(categoryPage.isWomenDressProductsHeaderVisible(),"Women - Dress Products Text is NOT visible");

//        //7. On left side bar, click on any sub-category link of 'Men' category verify the navigated page
        categoryPage.clickMenCategory();
        categoryPage.clickJeansLink();
        softAssert.assertTrue(categoryPage.isMenJeansProductsTextVisible(),"Mean - Jeans Products Text is NOT visible");


        softAssert.assertAll();


    }


}
