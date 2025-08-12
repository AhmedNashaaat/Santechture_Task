package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BasePage {

    protected static WebDriver driver;
    protected WebDriverWait wait;

    /**
     * Constructor initializing the page with WebDriver instance.
     *
     * @param driver The WebDriver instance to use for page interactions
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    /**
     * Waits for an element to be clickable and then clicks it.
     *
     * @param element The WebElement to wait for and click
     * @throws TimeoutException If the element doesn't become clickable within the wait time
     */
    public void waitTheElementAndClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    /**
     * Enters text into a visible web element after clearing it.
     *
     * @param element The WebElement to enter text into
     * @param txt The text to enter
     * @throws TimeoutException If the element doesn't become visible within 40 seconds
     */
    public void enterTxt(WebElement element, String txt) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(txt);
    }

    /**
     * Locates and returns a web element using a By locator.
     *
     * @param by The locator strategy to find the element
     * @return The found WebElement
     * @throws TimeoutException If the element isn't present within 20 seconds
     */
    public static WebElement getElement(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        return driver.findElement(by);
    }

    /**
     * Gets the text content of a web element with exception handling.
     *
     * @param element The WebElement to get text from
     * @return The element's text or empty string if any exception occurs
     */
    public String getText(WebElement element) {
        try {
            return element.getText();
        } catch (Exception e) {
            return "";
        }
    }


    /**
     * Scrolls to an element using smooth scrolling and ensures it's clickable.
     *
     * @param locator The locator for the target element
     * @param scrollTarget Optional existing element to scroll to (avoids duplicate lookup)
     * @return The located and scrolled-to WebElement
     * @throws TimeoutException If the element isn't found or becomes clickable within timeout
     */
    public static WebElement scrollToElementAndGetIt(By locator, WebElement... scrollTarget) {
        final int timeoutSeconds = 40;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));

        try {
            WebElement scrollElement = scrollTarget.length > 0 ? scrollTarget[0] :
                    wait.until(ExpectedConditions.presenceOfElementLocated(locator));

            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView({behavior: 'smooth'" +
                            ", block: 'center', inline: 'center'});",
                    scrollElement
            );

            // Additional scroll down by 200 pixels to ensure more visibility
            ((JavascriptExecutor) driver).executeScript(
                    "window.scrollBy(0, 200);"
            );

            return wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (TimeoutException e) {
            throw new TimeoutException(String.format(
                    "Element not found/visible after scrolling. Locator: %s (Timeout: %ds)",
                    locator.toString(),
                    timeoutSeconds
            ));
        }
    }


    // Method to click on button as a click form Keyboard
    public void sendKey(Keys keys) {
        Actions actions = new Actions(driver);
        actions.sendKeys(keys).perform();

    }

    public int getRecordsFromLabel(WebElement labelElement) {

        // Wait until the given WebElement is visible
        wait.until(ExpectedConditions.visibilityOf(labelElement));

        // Get the text from the element and extract the number
        String labelText = labelElement.getText();
        return Integer.parseInt(labelText.replaceAll("[^0-9]", ""));
    }

    public void forceClearField(WebElement element) {
        // Click into the field
        element.click();

        // Select all (works for most OS, adjust Keys if on Mac)
        element.sendKeys(Keys.CONTROL + "a");

        // Delete
        element.sendKeys(Keys.DELETE);

        // Extra safety: if text is still there, clear normally
        if (!element.getAttribute("value").isEmpty()) {
            element.clear();
        }
    }

}
