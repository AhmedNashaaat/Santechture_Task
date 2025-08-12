package Tests;

import Pages.*;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase extends BaseTest {

    HomePage homePage;
    AdminPage adminPage;
    UserFormPage userFormPage;
    PIMPage pimPage;

    static String fName;
    static String mName;
    static String lName;
    static String employeeId;
    static String newUserName;
    static String newUserPassword;

    @BeforeClass
    public void setupTestData() {
        homePage = new HomePage(driver);
        adminPage = new AdminPage(driver);
        userFormPage = new UserFormPage(driver);
        pimPage = new PIMPage(driver);


        fName = faker.name().firstName();
        mName = faker.name().nameWithMiddle();
        lName = faker.name().lastName();
        employeeId = faker.number().digits(5);
        newUserName = faker.name().username();
        newUserPassword = faker.internet().password();

        // Login once before all tests
        loginPage = new LoginPage(driver);
        loginPage.login(testData.userName, testData.password);
    }

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    public void testCreateNewEmployeeAndUser() {
        // Create new employee
        homePage.navigateToPIMIcon();
        pimPage.createNewEmployee(fName, mName, lName, employeeId);
        Assert.assertTrue(pimPage.getSuccessMessage().isDisplayed(),
                "Employee creation success message should be displayed");

        // Create new user and verify count increase
        homePage.navigateToAdminPage();
        int initialCount = adminPage.getTotalRecordsFromLabel();

        adminPage.addNewUser();
        userFormPage.enterNewUserDetails(fName, newUserName, newUserPassword, newUserPassword,
                testData.newUserRole, testData.newUserStatus);

        Assert.assertTrue(userFormPage.getSuccessMessage().isDisplayed(),
                "User creation success message should be displayed");

        int updatedCount = adminPage.getTotalRecordsFromLabel();
        Assert.assertEquals(updatedCount, initialCount + 1,
                "User count should increase by 1 after creating new user");
    }

    @Test(priority = 2)
    public void testDeleteUserAndVerifyCountDecrease() {
        homePage.navigateToAdminPage();
        int initialCount = adminPage.getTotalRecordsFromLabel();

        // Search and delete the user created in previous test
        adminPage.searchForCreatedUser(newUserName);
        adminPage.deleteNewUser();

        Assert.assertTrue(adminPage.getSuccessDeleteMessage().isDisplayed(),
                "User deletion success message should be displayed");

        // Verify count decreased
        homePage.navigateToAdminPage();
        int newCount = adminPage.getTotalRecordsFromLabel();
        Assert.assertEquals(newCount, initialCount - 1,
                "User count should decrease by 1 after deleting the user");
    }
}