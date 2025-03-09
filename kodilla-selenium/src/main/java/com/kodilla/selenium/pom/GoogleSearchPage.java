package com.kodilla.selenium.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoogleSearchPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By searchBox = By.cssSelector("input[name='q']");
    private By searchButton = By.cssSelector("input[name='btnK']");

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public void enterSearchTerm(String searchTerm) {
        WebElement searchBoxElement = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
        searchBoxElement.sendKeys(searchTerm);
    }

    public void clickSearchButton() {
        WebElement searchButtonElement = wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButtonElement.click();
    }
}