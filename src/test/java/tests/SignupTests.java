package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.SignupPage;
import utils.ConfigReader;

public class SignupTests extends BaseTest {

    SignupPage signupPage;

    @Test(dataProvider = "validRegister") //TC_1
    public void  tc_01_validRegisterUser(String nameOfUser,String userEmail ,String password) {
        SoftAssert softAssert = new SoftAssert();
        signupPage=new SignupPage(driver);

        // initial page
        softAssert.assertTrue(signupPage.isHomePageDisplayed(),"Home page is NOT visible!");

        //Enter Account Information
        signupPage.goToSignInPage();
        softAssert.assertTrue(signupPage.isNewUserSignupDisplayed(),"New User Signup! Text is NOT visible!");
        signupPage.setUserNameAndEmailAddress(nameOfUser,userEmail);
        signupPage.clickSignupSubmitBtn();

        softAssert.assertTrue(signupPage.isEnterAccountInfoTextDisplayed(),"Enter Account Information Text is NOT visible!");
        signupPage.fillAccountInformation("Mrs",nameOfUser,password,1,1,1);
        signupPage.scrollToNewsletterCheckBox();
        signupPage.clickNewsletterCheckBox();
        signupPage.clickOffersCheckBox();

        //Address Information
        signupPage.fillAccountAddressInformation("Noor","Yasser","Moddakir","October","Giza",
                1,"Egypt","Cairo","1911","+2012874");

        //  create account
        signupPage.submitCreateAccountBtn();
        Assert.assertTrue(signupPage.isAccountCreated(),"Account Created! Text is NOT visible!");
        signupPage.clickContinueBtn();

        //Compare the actual and expected username
        String actualLoggedAsName =signupPage.getLoggedAsActualName();
        String expectedLoggedAsName  ="Logged in as "+nameOfUser;
        Assert.assertEquals(actualLoggedAsName,expectedLoggedAsName,"The Actual Name not as same the Expected Name");

        //Delete Account
        signupPage.deleteAccount();
        Assert.assertTrue(signupPage.isAccountDeleted(),"Account Deleted! Text is NOT visible!");
        signupPage.clickContinueBtn();







    }
    @Test //TC_5
    public void tc_05_registerUserWithExistingEmail(){
        SoftAssert softAssert = new SoftAssert();

        signupPage=new SignupPage(driver);

        // initial page
        softAssert.assertTrue(signupPage.isHomePageDisplayed(),"Home page is NOT visible!");

        //Enter Account Information
        signupPage.goToSignInPage();
        softAssert.assertTrue(signupPage.isNewUserSignupDisplayed(),"New User Signup! Text is NOT visible!");

        //Reading from config.properties
        signupPage.setUserNameAndEmailAddress(ConfigReader.getProperty("loginValidName1"),ConfigReader.getProperty("loginValidEmail1"));
        signupPage.clickSignupSubmitBtn();

        softAssert.assertTrue(signupPage.isEmailAlreadyExistTextVisible(),"Email Already Exist Text is NOT visible!");

        softAssert.assertAll();

    }



    @DataProvider(name = "validRegister")
    public Object [] [] validRegisterData(){
        return new Object[][]{
                {"Ahmed","ahmed.ysr78wre@gmail.com","12345678"}
        };
    }

}
