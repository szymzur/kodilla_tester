package com.kodilla.selenium.pom;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import java.util.Random;
import java.util.List;

public class GoogleSearchTest {
    private WebDriver driver;
    private GoogleSearchPage googleSearchPage;
    private SearchResultPage searchResultPage;
    private SearchResultDetailsPage searchResultDetailsPage;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "c:/selenium-drivers/chrome/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 10);
        driver.get("https://www.google.pl");
        googleSearchPage = new GoogleSearchPage(driver);
        searchResultPage = new SearchResultPage(driver);
        searchResultDetailsPage = new SearchResultDetailsPage(driver);
    }

    @Test
    public void testRandomSearchResult() {
        googleSearchPage.enterSearchTerm("Java tutorial");
        googleSearchPage.clickSearchButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".rc .r a")));
        String expectedUrl = searchResultPage.getSelectedSearchResultUrl();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".rc .r a")));
        searchResultPage.clickRandomSearchResult();
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String actualUrl = searchResultDetailsPage.getCurrentPageUrl();
        assert actualUrl.equals(expectedUrl) : "Opened URL does not match the selected search result URL.";
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}