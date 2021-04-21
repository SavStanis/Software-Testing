package com.savstanis.softwaretesting.lab3.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthPage {
    private final WebDriver driver;

    public AuthPage(WebDriver driver) {
        this.driver = driver;
    }

    public AuthPage checkRegistrationCapture(String name, String email, String password) {

        sleep(6000);

        WebElement registrationTab = driver.findElement(By.xpath("//*[@id=\"tabs--6--tab--1\"]"));
        registrationTab.click();


        WebElement nameField = driver.findElement(By.id("register-name"));
        nameField.sendKeys(name);

        WebElement emailField = driver.findElement(By.id("register-email"));
        emailField.sendKeys(email);

        WebElement passwordField = driver.findElement(By.id("register-password"));
        passwordField.sendKeys(password);

        WebElement confirmPasswordField = driver.findElement(By.id("register-password-confirmation"));
        confirmPasswordField.sendKeys(password);

        driver.findElement(By.xpath("//*[@id=\"tabs--6--panel--1\"]/form/div[6]/button")).click();

        return this;
    }

    public AuthPage checkLoginCapture(String email, String password) {
        sleep(6000);

        WebElement nameField = driver.findElement(By.id("login-email"));
        nameField.sendKeys(email);

        WebElement emailField = driver.findElement(By.id("login-password"));
        emailField.sendKeys(password);

        //driver.findElement(By.xpath("//*[@id=\"tabs--6--panel--0\"]/form/div[4]/button")).click();

        return this;
    }

    public AuthPage checkRegistrationErrorMessage() {
        Assert.assertTrue("Capture error should be present", driver.findElements(By.xpath("//*[@id=\"tabs--6--panel--1\"]/form/div[5]/div[2]")).size() != 0);
        return this;
    }

    public AuthPage checkLoginErrorMessage() {
        Assert.assertTrue("Capture error should be present", driver.findElements(By.xpath("//*[@id=\"tabs--6--panel--0\"]/form/div[3]/div[2]")).size() != 0);
        return this;
    }



    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
