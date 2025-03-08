package com.kodilla.selenium.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class KodillaStorePom extends AbstractPom {

    @FindBy(css = "input[type='search']")
    WebElement searchField;

    @FindBy(css = "section > article")
    List<WebElement> searchResults;

    public KodillaStorePom(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void searchFor(String query) {
        searchField.clear();
        searchField.sendKeys(query);
        searchField.submit();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfAllElements(searchResults));
    }

    public int getSearchResultsCount() {
        // Debug print to check if searchResults is populated
        System.out.println("Number of results found: " + searchResults.size());
        for (WebElement result : searchResults) {
            System.out.println(result.getText());
        }
        return searchResults.size();
    }
}