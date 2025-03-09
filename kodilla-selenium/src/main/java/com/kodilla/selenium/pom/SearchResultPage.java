package com.kodilla.selenium.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Random;

public class SearchResultPage {
    private WebDriver driver;
    private By searchResults = By.cssSelector(".rc .r a");

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickRandomSearchResult() {
        List<WebElement> results = driver.findElements(searchResults);
        Random rand = new Random();
        int randomIndex = rand.nextInt(results.size());
        results.get(randomIndex).click();
    }

    public String getSelectedSearchResultUrl() {
        List<WebElement> results = driver.findElements(searchResults);
        Random rand = new Random();
        int randomIndex = rand.nextInt(results.size());
        return results.get(randomIndex).getAttribute("href");
    }
}

