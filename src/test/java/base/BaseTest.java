package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void LaunchBrowser(){
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ConfigReader.getProperty("baseUrl"));

    }



    @AfterMethod
    public void tearDown()  {
        driver.manage().deleteAllCookies();
      // driver.quit();

    }
}
