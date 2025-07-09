package pages;

import base.BasePage;
import org.openqa.selenium.*;
import utils.CommonLocators;
import java.io.File;

public class ContactUsPage extends BasePage {
    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    private final By getInTouchText=By.xpath("//h2[text()='Get In Touch']");
    private final By messageNameField=By.cssSelector("input[data-qa='name']");
    private final By messageEmailField=By.cssSelector("input[data-qa='email']");
    private final By messageSubjectField=By.cssSelector("input[data-qa='subject']");
    private final By messageTextField=By.id("message");
    private final By choseFileBtn=By.name("upload_file");
    private final By submitForm=By.cssSelector("input[data-qa='submit-button']");
    private final By successMessage=By.cssSelector("div[class='status alert alert-success']");
    private final By homBtn=By.cssSelector("a[class='btn btn-success']");


    //Methods
    public Boolean isHomePageVisible(){
        return isElementDisplayed(CommonLocators.homePageText);
    }
    public void goToContactusPage(){
        click(CommonLocators.contactUsLink);
    }
    public Boolean isGetInTouchTextVisible(){
        return isElementDisplayed(getInTouchText);
    }
    public void fillContactUsData(String messageName , String messageEmail, String messageSubject, String messageText){

        // Send name, email, subject and message
        type(messageNameField,messageName);
        type(messageEmailField,messageEmail);
        type(messageSubjectField,messageSubject);
        type(messageTextField,messageText);
    }
    public void uploadFileToContactUsForm(){
        File uploadFile=new File("src/main/resources/fileToUploaded");
        WebElement fileInput=driver.findElement(choseFileBtn);
        fileInput.sendKeys(uploadFile.getAbsolutePath());
    }
    public void scrollToSubmitFormBtn(){
        scrollToElement(submitForm);
    }
    public void clickSubmitContactUsForm(){
        click(submitForm);
    }
    public void clickAlert(String alertAction){
        if(alertAction.equalsIgnoreCase("ok")){
            acceptAlert();
        }
        else if (alertAction.equalsIgnoreCase("cancel")) {
           dismissAlert();
        }


    }
    public Boolean isSuccessMessageVisible(){
        return isElementDisplayed(successMessage);
    }
    public void clickHomeBtn(){
        click(homBtn);
    }



}
