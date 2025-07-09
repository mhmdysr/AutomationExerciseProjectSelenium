package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import utils.ConfigReader;
public class LoginTests extends BaseTest {

    LoginPage loginPage;

    @Test //TC_2
    public void tc_02_LoginWithCorrectEmailAndPassword() {
        SoftAssert softAssert = new SoftAssert();
        loginPage = new LoginPage(driver);

        softAssert.assertTrue(loginPage.isHomePageVisible(),"Home page is NOT visible!");
        loginPage.goToSignInPage();
        softAssert.assertTrue(loginPage.isLoginToYourAccTextVisible(),"Login to your account Text is not Visible");

        // Enter correct Email and Password then click Login Btn
        loginPage.enterLoginData(ConfigReader.getProperty("loginValidEmail1"),ConfigReader.getProperty("loginValidPassword1"));
        loginPage.clickLoginBtn();

        String actualLoggedAsName = loginPage.getLoggedAsActualName();
        String expectedLoggedAsName  ="Logged in as "+ConfigReader.getProperty("loginValidName1");
        softAssert.assertEquals(actualLoggedAsName,expectedLoggedAsName,"The Actual Name not as same the Expected Name");
        softAssert.assertAll();


    }

    @Test //TC_3
    public void tc_03_LoginWithIncorrectEmailAndPassword(){
        SoftAssert softAssert = new SoftAssert();
        loginPage = new LoginPage(driver);

        softAssert.assertTrue(loginPage.isHomePageVisible(),"Home page is NOT visible!");
        loginPage.goToSignInPage();
        softAssert.assertTrue(loginPage.isLoginToYourAccTextVisible(),"Login to your account Text is not Visible");

        // Enter correct Email and Password then click Login Btn
        loginPage.enterLoginData(ConfigReader.getProperty("loginValidEmail1"),ConfigReader.getProperty("loginInCorrectPassword1"));
        loginPage.clickLoginBtn();

        softAssert.assertTrue(loginPage.isYourEmailOrPasswordIncorrectTextVisible(),"Your email or password is incorrect! Text is not Visible");
        softAssert.assertAll();

    }

}
