package tests;


import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static pages.LoginPage.PASSWORD;
import static pages.LoginPage.USERNAME;


public class MainTest extends BaseTest {
    @Test
    public void mapTestHeatMap() {
        mainPage
                .openPage()
                .isPageOpened()
                .changeHeatMap();
        assertEquals(mainPage.identMap(), "Heat map");
    }
    @Test
    public void mapTestWind()  {
        mainPage
                .openPage()
                .isPageOpened()
                .changeWind();
        assertEquals(mainPage.identMap(), "Wind");
    }
    @Test
    public void mapTestSatellite() {
        mainPage
                .openPage()
                .isPageOpened()
                .changeSatellite();
        assertEquals(mainPage.identMap(), "Satellite");
    }

    @Test
    public void chooseLanguageTest() {
        mainPage
                .openPage()
                .isPageOpened()
                .transitionToLoginProcess();
        loginPage
                .attemptToLogin(USERNAME, PASSWORD);
        mainPage
                .chooseLanguage();
        assertEquals(mainPage.identLanguage(), "Русский - Russian Federation");
    }
}