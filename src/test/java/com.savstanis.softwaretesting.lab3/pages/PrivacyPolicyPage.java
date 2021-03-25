package com.savstanis.softwaretesting.lab3.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class PrivacyPolicyPage {
    private final String PRIVACY_POLICY_PAGE_URL = "https://www.farfetch.com/ru/privacy-policy/";
    private final WebDriver driver;

    public PrivacyPolicyPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkLink() {
        Assert.assertTrue(PRIVACY_POLICY_PAGE_URL.equals(driver.getCurrentUrl()));
    }
}
