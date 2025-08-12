package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{

    /**
     * Constructor initializing the page with WebDriver instance.
     *
     * @param driver The WebDriver instance to use for page interactions
     */
    public HomePage(WebDriver driver) {
        super(driver);
    }

    WebElement adminIcon,pimIcon;

    By adminIconLocator= By.linkText("Admin");
    By pimIconLocator = By.linkText("PIM");
    public void navigateToAdminPage()
    {
        adminIcon=getElement(adminIconLocator);
        waitTheElementAndClick(adminIcon);
    }
    public void navigateToPIMIcon()
    {
        pimIcon=getElement(pimIconLocator);
        waitTheElementAndClick(pimIcon);
    }

}
