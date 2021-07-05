package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class MainPage extends BasePage {

    public static final String URL = "https://www.yahoo.com";
    public static final By LOG = By.xpath("//input[@name = 'crumb']/parent::div");
    public static final By ELEMENT = By.id("grid-layout");
    public static final By SEE_MORE = By.xpath("//a[contains (text(), 'See More')]");
    public static final By SATELLITE = By.cssSelector("[data-reactid='528']");
    public static final By HEATMAP = By.cssSelector("[data-reactid='530']");
    public static final By WIND = By.cssSelector("[data-reactid='532']");
    public static final By MAP_CATEGORY = By.cssSelector("[data-reactid='526']");
    public static final By MANAGE_LOCATION = By.xpath("//a[@href = 'https://settings.yahoo.com/locations?lang=en-US']");
    public static final By LANGUAGE_DROPDOWN = By.id("language-dropdown");
    public static final By RUSSIAN =  By.xpath("//option[@selected='selected']");


    public MainPage(WebDriver driver) {
        super(driver);
    }

        public MainPage openPage () {
            driver.get(URL);
            return this;
        }

        public MainPage transitionToLoginProcess () {
            driver.findElement(LOG).click();
            return this;
        }

        public MainPage isPageOpened () {
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(ELEMENT));
            } catch (TimeoutException ex) {
                System.out.println("Элемент не найден" + ELEMENT);
            }
            return this;
        }

        public MainPage changeHeatMap () {
            driver.findElement(SEE_MORE).click();
            driver.findElement(HEATMAP).click();
            return this;
        }
        public MainPage changeWind () {
            driver.findElement(SEE_MORE).click();
            driver.findElement(WIND).click();
            return this;
        }
        public MainPage changeSatellite () {
            driver.findElement(SEE_MORE).click();
            driver.findElement(SATELLITE).click();
            return this;
        }

        public String identMap () {
            return driver.findElement(MAP_CATEGORY).getText();
        }

        public MainPage chooseLanguage (){
            driver.findElement(SEE_MORE).click();
            driver.findElement(MANAGE_LOCATION).click();
            driver.findElement(LANGUAGE_DROPDOWN).click();
            driver.findElement(RUSSIAN).click();
            return this;
        }
        public String identLanguage () {
            return driver.findElement(LANGUAGE_DROPDOWN).getText();
        }
    }