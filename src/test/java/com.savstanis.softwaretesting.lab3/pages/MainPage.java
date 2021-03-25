package com.savstanis.softwaretesting.lab3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private final WebDriver driver;

    @FindBy(xpath = "//*[@id=\"slice-header\"]/div[2]/div/div[1]/div[2]/button")
    private WebElement profileIcon;

    @FindBy(linkText = "Политикой конфиденциальности")
    private WebElement privacyPolicyLink;

    @FindBy(linkText = "Условиями пользования")
    private WebElement termsAndConditionsLink;

    @FindBy(xpath = "//*[@id=\"slice-header\"]/div[2]/div/div[1]/div[2]/a[1]")
    private WebElement wishlistLink;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public AuthPage getAuthPage() {
        profileIcon.click();
        return new AuthPage(driver);
    }

    public PrivacyPolicyPage getPrivacyPolicyPage() {
        privacyPolicyLink.click();
        return new PrivacyPolicyPage(driver);
    }

    public TermsAndConditionsPage getTermsAndConditionsPage() {
        termsAndConditionsLink.click();
        return new TermsAndConditionsPage(driver);
    }

    public WishListPage getWishListPage() {
        wishlistLink.click();
        return new WishListPage(driver);
    }
}
