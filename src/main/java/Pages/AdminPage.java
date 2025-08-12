package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminPage extends BasePage{


    /**
     * Constructor initializing the page with WebDriver instance.
     *
     * @param driver The WebDriver instance to use for page interactions
     */
    public AdminPage(WebDriver driver) {
        super(driver);
    }

    WebElement addButton,deleteButton,userNameSearch
            ,searchButton,deleteConfirmationButton,successDeleteMessage,rowsLabel;

    By addButtonLocator = By.xpath("//button[@type='button' and contains(@class, 'oxd-button--secondary')]");
    By deleteButtonLocator= By.xpath("//button[contains(@class, 'oxd-icon-button') and .//i[contains(@class, 'bi-trash')]]");
    By userNameSearchLocator= By.cssSelector("div[class='oxd-input-group oxd-input-field-bottom-space'] div input[class='oxd-input oxd-input--active']");
    By searchButtonLocator = By.cssSelector("button[type='submit']");
    By deleteConfirmationButtonLocator = By.cssSelector("button[class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']");
    By successDeleteMessageLocator = By.cssSelector(".oxd-toast-content.oxd-toast-content--success");
    By rowsLabelLocator =  By.cssSelector("div[class='orangehrm-horizontal-padding orangehrm-vertical-padding'] span[class='oxd-text oxd-text--span']");

    public void addNewUser()
    {
        addButton=getElement(addButtonLocator);
        waitTheElementAndClick(addButton);
    }

    public int getTotalRecordsFromLabel(){
    rowsLabel=getElement(rowsLabelLocator);
    return getRecordsFromLabel(rowsLabel);
    }
    public void searchForCreatedUser(String newUserName){
        userNameSearch=getElement(userNameSearchLocator);
        enterTxt(userNameSearch,newUserName);
        searchButton=getElement(searchButtonLocator);
        waitTheElementAndClick(searchButton);
    }
    public void deleteNewUser(){
        deleteButton=scrollToElementAndGetIt(deleteButtonLocator);
        waitTheElementAndClick(deleteButton);
        deleteConfirmationButton=getElement(deleteConfirmationButtonLocator);
        waitTheElementAndClick(deleteConfirmationButton);

    }

    public WebElement getSuccessDeleteMessage(){
        successDeleteMessage=getElement(successDeleteMessageLocator);
        return successDeleteMessage;
    }
}
