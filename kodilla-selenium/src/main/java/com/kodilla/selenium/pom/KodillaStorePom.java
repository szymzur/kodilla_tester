package com.kodilla.selenium.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class KodillaStorePom extends AbstractPom {

    @FindBy(css = "input[name='search']")
    private WebElement searchField;

    public KodillaStorePom(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public int getSearchResultsCount(String searchPhrase) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='" + searchPhrase + "';", searchField);
        js.executeScript("arguments[0].dispatchEvent(new Event('change'))", searchField);
        js.executeScript("arguments[0].dispatchEvent(new Event('submit'))", searchField);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<WebElement> products = driver.findElements(By.cssSelector("div.element"));
        System.out.println("Liczba znalezionych elementów: " + products.size());

        for (WebElement product : products) {
            System.out.println("Znaleziony produkt: " + product.getText());
        }

        return products.size();
    }
}