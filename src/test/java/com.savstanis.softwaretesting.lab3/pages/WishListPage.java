package com.savstanis.softwaretesting.lab3.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WishListPage {
    private final WebDriver driver;

    public WishListPage(WebDriver driver) {
        this.driver = driver;
    }

    public void findRegistrationLink() {
        List<WebElement> elements = driver.findElements(By.className("registration-button"));
        Assert.assertEquals(1, elements.size());
    }
}
