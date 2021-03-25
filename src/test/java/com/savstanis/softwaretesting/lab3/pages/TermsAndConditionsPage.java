package com.savstanis.softwaretesting.lab3.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class TermsAndConditionsPage {
    private final String TERMS_AND_CONDITIONS_PAGE_URL = "https://www.farfetch.com/ru/terms-and-conditions/";
    private final WebDriver driver;

    public TermsAndConditionsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkLink() {
        Assert.assertTrue(TERMS_AND_CONDITIONS_PAGE_URL.equals(driver.getCurrentUrl()));
    }
}
