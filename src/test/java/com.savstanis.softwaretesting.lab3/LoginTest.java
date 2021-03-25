package com.savstanis.softwaretesting.lab3;

import com.savstanis.softwaretesting.lab3.pages.AuthPage;
import com.savstanis.softwaretesting.lab3.pages.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
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
    public void loginUserWithoutCapture() {
        webDriver.get("https://www.farfetch.com/ru/shopping/men/items.aspx");
        MainPage mainPage = new MainPage(webDriver);
        AuthPage authPage = mainPage.getAuthPage();
        authPage.checkLoginCapture( "randomnameemail@gmail.com", "veryeasypassword")
                .checkLoginErrorMessage();
    }
}
