package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ContactUsPage;

public class ContactUsTests extends BaseTest {

    ContactUsPage contactUsPage;

    @Test(dataProvider = "contactUsForm")
    public void tc_06_contactUsForm(String msgName,String msfEmail,String msgSubject,String msgText){
        SoftAssert softAssert=new SoftAssert();
        contactUsPage=new ContactUsPage(driver);

        softAssert.assertTrue(contactUsPage.isHomePageVisible(),"Home page is NOT visible!");
        contactUsPage.goToContactusPage();
        softAssert.assertTrue(contactUsPage.isGetInTouchTextVisible(),"Get In Touch Text is NOT visible!");

        // Enter name, email, subject and message using Data Provider
        contactUsPage.fillContactUsData(msgName,msfEmail,msgSubject,msgText);
        //upload file
        contactUsPage.uploadFileToContactUsForm();
        contactUsPage.scrollToSubmitFormBtn();
        contactUsPage.clickSubmitContactUsForm();
        contactUsPage.clickAlert("ok"); // 'ok' for accept && 'cancel' for dismiss

        softAssert.assertTrue(contactUsPage.isSuccessMessageVisible()," Success! Your details have been submitted successfully Text is NOT visible!");
        // click Home Page and verify it
        contactUsPage.clickHomeBtn();
        softAssert.assertTrue(contactUsPage.isHomePageVisible(),"Home page is NOT visible!");

        softAssert.assertAll();


    }

    @DataProvider(name = "contactUsForm")
    public Object[][] contactUsData(){
        return new Object[][]{
                {"Open Vacancy","midQc@fpl.com","Test Automation Engineer","Hello Dear, I Hope U Well.."}
        };

    }
}
