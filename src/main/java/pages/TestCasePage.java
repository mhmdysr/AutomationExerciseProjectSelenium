package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.CommonLocators;

public class TestCasePage extends BasePage {
    public TestCasePage(WebDriver driver) {
        super(driver);
    }

    private final By testCasesLink=By.xpath("//a[text()=' Test Cases']");
    private final By testCasesText=By.cssSelector("h2[class='title text-center']");

    public Boolean isHomePageVisible() {
        return isElementDisplayed(CommonLocators.homePageText);
    }
    public void goToTestCasesPage(){
        click(testCasesLink);
    }
    public Boolean isTestCasesPageVisible(){
        return isElementDisplayed(testCasesText);

    }



}
