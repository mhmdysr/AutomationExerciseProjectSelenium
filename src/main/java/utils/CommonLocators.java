package utils;

import org.openqa.selenium.By;

public class CommonLocators {

    public static final By signInLoginLink = By.xpath("//a[text()=' Signup / Login']");
    public static final By homePageText=By.xpath("//h2[text()='Full-Fledged practice website for Automation Engineers']");
    public static final By loggedInAsText=By.xpath("//*[contains(text(), 'Logged in as')]");
    public static final By contactUsLink =By.xpath("//*[contains(text(),'Contact us')]");
    public static final By productsLink=By.xpath("//a[contains(text(),'Products')]");
    public static final By productName = By.xpath("//div[@class='product-information']//h2");
    public static final By productCategory = By.xpath("//div[@class='product-information']//p[1]");
    public static final By productPrice = By.xpath("//div[@class='product-information']//span/span");
    public static final By productAvailability = By.xpath("//div[@class='product-information']//p[b[text()='Availability:']]");
    public static final By productCondition = By.xpath("//div[@class='product-information']//p[b[text()='Condition:']]");
    public static final By productBrand = By.xpath("//div[@class='product-information']//p[b[text()='Brand:']]");

    public static final By searchedProductName = By.xpath("//div[@class='productinfo text-center']//p");
    public static final By searchedProductPrice = By.xpath("//div[@class='productinfo text-center']//h2");
    public static final By cartLink =By.linkText("Cart");
    public static final By productDetailsClass=By.className("product-details");






}
