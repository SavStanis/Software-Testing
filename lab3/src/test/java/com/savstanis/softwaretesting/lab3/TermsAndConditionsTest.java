package com.savstanis.softwaretesting.lab3;


import com.savstanis.softwaretesting.lab3.pages.MainPage;
import com.savstanis.softwaretesting.lab3.pages.TermsAndConditionsPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class TermsAndConditionsTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless", "--disable-gpu", "--no-sandbox", "--window-size=1920,1080");
        System.setProperty("webdriver.gecko.driver", "C:/Program Files/webdrivers/geckodriver.exe");
        driver = new FirefoxDriver(options);
    }

    @After
    public void quit() {
        driver.quit();
    }

    @Test
    public void checkPrivacyPolicy() {
        driver.get("https://www.farfetch.com/ru/shopping/men/items.aspx");
        MainPage mainPage = new MainPage(driver);
        TermsAndConditionsPage termsAndConditionsPage = mainPage.getTermsAndConditionsPage();
        termsAndConditionsPage.checkLink();
    }
}
