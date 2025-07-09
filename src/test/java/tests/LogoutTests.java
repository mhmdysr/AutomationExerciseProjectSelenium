package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.ManageAccPage;
import utils.ConfigReader;

public class LogoutTests extends BaseTest {

    LoginPage loginPage;
    ManageAccPage logoutPage;
    @Test //TC_4
    public void tc_04_LogoutUser() {
        SoftAssert softAssert = new SoftAssert();
        loginPage = new LoginPage(driver);
        logoutPage=new ManageAccPage(driver);

        softAssert.assertTrue(loginPage.isHomePageVisible(),"Home page is NOT visible!");
        loginPage.goToSignInPage();
        softAssert.assertTrue(loginPage.isLoginToYourAccTextVisible(),"Login to your account Text is not Visible");

        // Enter correct Email and Password then click Login Btn
        loginPage.enterLoginData(ConfigReader.getProperty("loginValidEmail1"),ConfigReader.getProperty("loginValidPassword1"));
        loginPage.clickLoginBtn();

        String actualLoggedAsName = loginPage.getLoggedAsActualName();
        String expectedLoggedAsName  ="Logged in as "+ConfigReader.getProperty("loginValidName1");
        softAssert.assertEquals(actualLoggedAsName,expectedLoggedAsName,"The Actual Name not as same the Expected Name");
        //click Logout Btn
        logoutPage.clickLogoutBtn();
        Assert.assertTrue(logoutPage.isUserLogoutSuccessfully(),"user not Logout Successful");

        softAssert.assertAll();



    }
}
