package com.savstanis.softwaretesting.lab3;


import com.savstanis.softwaretesting.lab3.pages.AuthPage;
import com.savstanis.softwaretesting.lab3.pages.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;

public class LoginTest {
    private WebDriver webDriver;

    @Before
    public void setUp() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless", "--disable-gpu", "--no-sandbox", "--window-size=1920,1080");
        System.setProperty("webdriver.gecko.driver", "C:/Program Files/webdrivers/geckodriver.exe");
        webDriver = new FirefoxDriver(options);
    }

    @After
    public void quit() {
        webDriver.quit();
    }

    @Test
    public void loginUserWithoutCapture() {
        webDriver.get("https://www.farfetch.com/ru/shopping/men/items.aspx");
        MainPage mainPage = new MainPage(webDriver);
        AuthPage authPage = mainPage.getAuthPage();

        authPage.checkLoginCapture( "randomnameemail@gmail.com", "veryeasypassword");
    }
}
