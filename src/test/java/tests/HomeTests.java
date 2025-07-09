package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import utils.CommonMethods;

public class HomeTests extends BaseTest {

    HomePage subscriptionPage;


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


}
