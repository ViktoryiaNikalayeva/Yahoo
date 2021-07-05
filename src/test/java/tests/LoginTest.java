package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static pages.LoginPage.PASSWORD;
import static pages.LoginPage.USERNAME;

public class LoginTest extends BaseTest {


    @Test
    public void userShouldBeLogin() {
        mainPage
                .openPage()
                .isPageOpened()
                .transitionToLoginProcess();
        loginPage
                .attemptToLogin(USERNAME, PASSWORD);
        assertEquals(loginPage.isUserLogined(), "Viktoryia");
    }

    @Test
    public void loginVar1() {
        mainPage
                .openPage()
                .isPageOpened()
                .transitionToLoginProcess();
        loginPage
                .attemptToLoginWithoutPasswordForTest(" ");
        assertEquals(loginPage.errorMessage(), "Sorry, we don't recognize this email.");
    }

    @Test
    public void loginVar2() {
        mainPage
                .openPage()
                .isPageOpened()
                .transitionToLoginProcess();
        loginPage
                .attemptToLoginWithoutPasswordForTest("viktoryia5555567@yahoo.com");
        assertEquals(loginPage.errorMessage(), "Sorry, we don't recognize this email.");
    }


    @Test(dataProvider = "passwordVarsDP")
    public void passwordVarsTest(String username, String password, String errorMessage) {
        mainPage
                .openPage()
                .isPageOpened()
                .transitionToLoginProcess();
        loginPage
                .attemptToLogin(username, password);
        assertEquals(loginPage.errorMessage(), errorMessage);
    }

    @DataProvider
    public Object[][] passwordVarsDP() {
        return new Object[][]{
                {USERNAME, " ", "Please provide password."},
                {USERNAME, "dfdfdf", "Invalid password. Please try again"},
        };
    }
}
