package com.kodilla.selenium.pom;

import org.openqa.selenium.WebDriver;

public class SearchResultDetailsPage {
    private WebDriver driver;

    public SearchResultDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCurrentPageUrl() {
        return driver.getCurrentUrl();
    }
}
