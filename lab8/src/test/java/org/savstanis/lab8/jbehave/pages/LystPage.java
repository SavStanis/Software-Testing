package org.savstanis.lab8.jbehave.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

@DefaultUrl("https://www.lyst.com/")
public class LystPage extends PageObject {

    @WhenPageOpens
    public void maximiseScreen() {
        getDriver().manage().window().setSize(new Dimension(1720, 1080));
    }

    @FindBy(xpath = "/html/body/div[6]/div[3]/div[2]/div/div/span[2]/form/div[1]/input")
    private WebElementFacade searchTextField;

    @FindBy(xpath = "/html/body/div[6]/div[3]/div[2]/div/div/span[2]/form/div[1]/button[1]")
    private WebElementFacade searchButton;

    public void enter_keywords(String keyword) {
        searchTextField.sendKeys(keyword);
    }

    public void search() {
        searchButton.click();
    }

    public String searchResultHeader() {
        return find(By.xpath("/html/body/div[6]/div[5]/div[2]/div[2]/div[1]/div/div/h1")).getText();
    }
}
