package Tests;

import Data.JsonDataReader;
import Pages.BasePage;
import Pages.HomePage;
import Pages.LoginPage;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.index.qual.LengthOf;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected JsonDataReader testData;
    static Faker faker = new Faker();



    /**
     * Initializes WebDriver and navigates to application URL.
     * Sets up test environment before each test.
     */

    @BeforeTest
    public void setUp() throws IOException, ParseException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        testData = new JsonDataReader();
        testData.jsonReader();
    }

    /**
     * Cleans up test environment after each test.
     * Closes browser instance if it exists.
     */
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
