package tests;
import base.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestCasePage;

public class TestCaseTests extends BaseTest {

    TestCasePage testCasePage ;
    @Test
    public void tc_01_verifyTestCasesPage(){
        SoftAssert softAssert=new SoftAssert();

        testCasePage=new TestCasePage(driver);
        softAssert.assertTrue(testCasePage.isHomePageVisible(),"Home page is NOT visible!");
        testCasePage.goToTestCasesPage();
        softAssert.assertTrue(testCasePage.isTestCasesPageVisible(),"Test cases page is Not Visible");

    }
}
