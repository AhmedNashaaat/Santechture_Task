package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserFormPage extends BasePage{
    /**
     * Constructor initializing the page with WebDriver instance.
     *
     * @param driver The WebDriver instance to use for page interactions
     */
    public UserFormPage(WebDriver driver) {
        super(driver);
    }

    WebElement userRole,status
            ,employeeName,userName,passwordField
            ,confirmPasswordField,saveButton,successMessage;

    By userRoleLocator = By.cssSelector("body > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > form:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1)");
    By statusLocator= By.cssSelector("body > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > form:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1)");
    By employeeNameLocator=By.cssSelector("input[placeholder='Type for hints...']");
    By userNameLocator= By.cssSelector("div[class='oxd-form-row'] div[class='oxd-grid-2 orangehrm-full-width-grid'] div[class='oxd-grid-item oxd-grid-item--gutters'] div[class='oxd-input-group oxd-input-field-bottom-space'] div input[class='oxd-input oxd-input--active']");
    By passwordFieldLocator = By.xpath("(//input[@type='password'])[1]");
    By confirmPasswordFieldLocator = By.xpath("(//input[@type='password'])[2]");
    By saveButtonLocator= By.cssSelector("button[type='submit']");
    By successMessageLocator = By.cssSelector(".oxd-toast.oxd-toast--success.oxd-toast-container--toast");


    public void enterNewUserDetails(String employeeNameValue, String userNameValue,
                                    String passwordValue, String confirmPasswordValue,
                                    String role, String statusValue) {

        // Select User Role dynamically
        userRole = getElement(userRoleLocator);
        waitTheElementAndClick(userRole);
        if (role.equalsIgnoreCase("Admin")) {
            sendKey(Keys.DOWN);
        } else if (role.equalsIgnoreCase("ESS")) {
            sendKey(Keys.DOWN);
            sendKey(Keys.DOWN);
        }
        sendKey(Keys.ENTER);

        // Select Status dynamically
        status = getElement(statusLocator);
        waitTheElementAndClick(status);
        if (statusValue.equalsIgnoreCase("Enabled")) {
            sendKey(Keys.DOWN);
        } else if (statusValue.equalsIgnoreCase("Disabled")) {
            sendKey(Keys.DOWN);
            sendKey(Keys.DOWN);
        }
        sendKey(Keys.ENTER);

        // Employee Name autocomplete
        employeeName = getElement(employeeNameLocator);
        waitTheElementAndClick(employeeName);
        enterTxt(employeeName, employeeNameValue);
        waitForSuggestionContaining(employeeNameValue);
        sendKey(Keys.DOWN);
        sendKey(Keys.ENTER);

        // Username
        userName = getElement(userNameLocator);
        enterTxt(userName, userNameValue);

        // Password & Confirm Password
        passwordField = getElement(passwordFieldLocator);
        enterTxt(passwordField, passwordValue);

        confirmPasswordField = getElement(confirmPasswordFieldLocator);
        enterTxt(confirmPasswordField, confirmPasswordValue);

        // Save
        saveButton = getElement(saveButtonLocator);
        waitTheElementAndClick(saveButton);
    }



    public WebElement getSuccessMessage() {
        successMessage=getElement(successMessageLocator);
        return successMessage;
    }

    private void waitForSuggestionContaining(String partialName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for the dropdown container to be visible first
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".oxd-autocomplete-dropdown")
        ));

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class,'oxd-autocomplete-option') and contains(.,'" + partialName + "')]")
        ));
    }
}
