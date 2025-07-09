package base;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait driverWait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.driverWait = new WebDriverWait(driver, Duration.ofSeconds(15));

    }

    public void click(By locator) {
        driverWait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    public void type(By locator, String text) {
        WebElement element = driverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }
    public String getText(By locator) {
        return driverWait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }
    public Boolean isElementDisplayed(By locator) {
        try {
            return driverWait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();

        } catch (TimeoutException e) {
            return false;
        }
    }
    public void scrollToElement(By locator){
        WebElement element=driverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

    }
    public void scrollToBottomPage(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }
    public void scrollToTopPage(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0);");
    }
    public void waitForElementClickable(By locator) {
        driverWait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public void waitForElementToDisappear(By locator) {
        driverWait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
    public void selectDropdownByText(By locator, String visibleText) {
        WebElement dropdown = driverWait.until(ExpectedConditions.elementToBeClickable(locator));
        Select select = new Select(dropdown);
        select.selectByVisibleText(visibleText);
    }
    public void selectDropdownByIndex(By locator, int itemIndex) {
        WebElement dropdown = driverWait.until(ExpectedConditions.elementToBeClickable(locator));
        Select select = new Select(dropdown);
        select.selectByIndex(itemIndex);
    }
    public void acceptAlert() {
        driverWait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public void dismissAlert() {
        driverWait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().dismiss();
    }

    public void hoverOverElementAndClick(By hoverLocator, By clickLocator){
        Actions actions=new Actions(driver);
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(hoverLocator));
        actions
                . moveToElement(driver.findElement(clickLocator))
                .click()
                .perform();
    }




}
