package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PIMPage extends BasePage{

    /**
     * Constructor initializing the page with WebDriver instance.
     *
     * @param driver The WebDriver instance to use for page interactions
     */
    public PIMPage(WebDriver driver) {
        super(driver);
    }

    WebElement addEmployeeButton,employeeFName
            ,employeeMName,employeeLName
            ,employeeId,saveButton,successMessage;


    By addEmployeeButtonLocator =By.cssSelector("button[class='oxd-button oxd-button--medium oxd-button--secondary']");
    By employeeFNameLocator = By.cssSelector("input[placeholder='First Name']");
    By employeeMNameLocator = By.cssSelector("input[placeholder='Middle Name']");
    By employeeLNameLocator = By.cssSelector("input[placeholder='Last Name']");
    By employeeIdLocator = By.cssSelector("div[class='oxd-input-group oxd-input-field-bottom-space'] div input[class='oxd-input oxd-input--active']");
    By saveButtonLocator = By.cssSelector("button[type='submit']");
    By successMessageLocator = By.cssSelector(".oxd-toast.oxd-toast--success.oxd-toast-container--toast");

    public void createNewEmployee(String employeeFNameValue,String employeeMNameValue
            ,String employeeLNameValue,String employeeIdValue)
    {
        addEmployeeButton=getElement(addEmployeeButtonLocator);
        waitTheElementAndClick(addEmployeeButton);
        employeeFName=getElement(employeeFNameLocator);
        employeeMName=getElement(employeeMNameLocator);
        employeeLName=getElement(employeeLNameLocator);
        employeeId=getElement(employeeIdLocator);
        saveButton=getElement(saveButtonLocator);


        enterTxt(employeeFName,employeeFNameValue);
        enterTxt(employeeMName,employeeMNameValue);
        enterTxt(employeeLName,employeeLNameValue);
        waitTheElementAndClick(employeeId);
        forceClearField(employeeId);
        enterTxt(employeeId,employeeIdValue);
        waitTheElementAndClick(saveButton);

    }

    public WebElement getSuccessMessage() {
        successMessage=getElement(successMessageLocator);
        return successMessage;
    }
}
