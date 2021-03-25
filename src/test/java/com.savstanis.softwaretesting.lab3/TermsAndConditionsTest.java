package com.savstanis.softwaretesting.lab3;

import com.savstanis.softwaretesting.lab3.pages.MainPage;
import com.savstanis.softwaretesting.lab3.pages.PrivacyPolicyPage;
import com.savstanis.softwaretesting.lab3.pages.TermsAndConditionsPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TermsAndConditionsTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
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
