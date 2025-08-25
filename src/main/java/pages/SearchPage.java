package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {
        super(driver);
    }


    //Locators

    private final By searchInputField=By.cssSelector("input[id='search_product']");
    private final By searchBtn=By.cssSelector("button[id='submit_search']");
    private final By searchedProductsHeader=By.xpath("//h2[text()='Searched Products']");
    private final By productsList=By.className("features_items");
    private final By searchedProductID=By.id("product-5");

    //Methods

    //TC 20: Search Products and Verify Cart After Login
    public void searchProductWithName(String productName){
        type(searchInputField,productName);

    }
    public void clickSearchBtn(){
        click(searchBtn);


    }
    public Boolean isSearchedProductsHeaderVisible(){

        return isElementDisplayed(searchedProductsHeader);
    }
    public Boolean isProductsListVisible(){


     return isElementDisplayed(productsList);
    }
    public Boolean isSearchedProductDisplayed(){
     return isElementDisplayed(searchedProductID);
    }


}

