package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

    /**
     * Constructor initializing the page with WebDriver instance.
     *
     * @param driver The WebDriver instance to use for page interactions
     */
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    WebElement userNameField,passwordField,loginButton;

    By userNameFiledLocator= By.cssSelector("input[placeholder='Username']");
    By passwordFieldLocator= By.cssSelector("input[placeholder='Password']");
    By loginButtonLocator = By.cssSelector("button[type='submit']");


    public void login(String userNameValue,String passwordValue)
    {
        userNameField=getElement(userNameFiledLocator);
        enterTxt(userNameField,userNameValue);
        passwordField=getElement(passwordFieldLocator);
        enterTxt(passwordField,passwordValue);
        loginButton=getElement(loginButtonLocator);
        waitTheElementAndClick(loginButton);
    }

}
