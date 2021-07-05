package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class LoginPage extends BasePage {



    //public static final String PATH_TO_PROPERTIES = "src\\test\\resources\\config.properties";
    public static final String USERNAME = "viktoryia911@yahoo.com";
    public static final String PASSWORD = "PasswordforYahoo";
    public static final By LOGIN_PLACE = By.id("login-username");
    public static final By PASSWORD_PLACE = By.id("login-passwd");
    public static final By NEXT_BUTTON = By.id("login-signin");
    public static final By STAY_SIGNED = By.cssSelector("[id = 'persistent']");
    public static final By CHECKING_ELEMENT = By.id("ybarAccountMenuOpener");
    public static final By ERROR_ELEMENT = By.className("error-msg");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage attemptToLogin(String username, String password) {
        driver.findElement(LOGIN_PLACE).sendKeys(username);
        //driver.findElement(STAY_SIGNED).click();
        driver.findElement(NEXT_BUTTON).click();
        driver.findElement(PASSWORD_PLACE).sendKeys(password);
        driver.findElement(NEXT_BUTTON).click();
        return this;
    }

    public LoginPage attemptToLoginWithoutPasswordForTest(String username) {
        driver.findElement(LOGIN_PLACE).sendKeys(username);
        driver.findElement(NEXT_BUTTON).click();
        return this;
    }

    public String errorMessage() {
        return driver.findElement(ERROR_ELEMENT).getText();
    }

    public String isUserLogined() {
        return driver.findElement(CHECKING_ELEMENT).getText();

    }

}
