package com.savstanis.softwaretesting.lab3;

import com.savstanis.softwaretesting.lab3.pages.MainPage;
import com.savstanis.softwaretesting.lab3.pages.AuthPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class RegistrationTest {

    private WebDriver webDriver;

    @Before
    public void setUp() {
        webDriver = new ChromeDriver();
    }

    @After
    public void quit() {
        webDriver.quit();
    }

    @Test
    public void registerUserWithoutCapture() {
        webDriver.get("https://www.farfetch.com/ru/shopping/men/items.aspx");
        MainPage mainPage = new MainPage(webDriver);
        AuthPage authPage = mainPage.getAuthPage();
        authPage.checkRegistrationCapture("Random Name Name", "randomnameemail@gmail.com", "veryeasypassword")
                .checkRegistrationErrorMessage();
    }
}
