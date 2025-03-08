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

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KodillaStorePomTest {

    WebDriver driver;
    KodillaStorePom storePom;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "c:/selenium-drivers/chrome/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.navigate().to("https://kodilla.com/pl/test/store");
        storePom = new KodillaStorePom(driver);
    }

    @Test
    public void testSearchResults() {
        String[] searchQueries = {"NoteBook", "School", "Brand", "Business", "Gaming", "Powerful"};
        int[] expectedResults = {5, 3, 4, 2, 6, 1}; // rzeczywiste wartości do zastąpienia

        for (int i = 0; i < searchQueries.length; i++) {
            System.out.println("Testing query: " + searchQueries[i]);
            storePom.searchFor(searchQueries[i]);
            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section > article"))); // Ensure results are loaded
            int resultCount = storePom.getSearchResultsCount();
            System.out.println("Query: " + searchQueries[i] + ", Results: " + resultCount);
            assertEquals(expectedResults[i], resultCount);
        }
    }

    @Test
    public void testSearchResultsIgnoreCase() {
        String[] searchQueries = {"NoteBook", "notebook", "School", "school", "Brand", "brand", "Business", "business", "Gaming", "gaming", "Powerful", "powerful"};
        int[] expectedResults = {5, 5, 3, 3, 4, 4, 2, 2, 6, 6, 1, 1}; // rzeczywiste wartości do zastąpienia

        for (int i = 0; i < searchQueries.length; i++) {
            System.out.println("Testing query: " + searchQueries[i]);
            storePom.searchFor(searchQueries[i]);
            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section > article"))); // Ensure results are loaded
            int resultCount = storePom.getSearchResultsCount();
            System.out.println("Query: " + searchQueries[i] + ", Results: " + resultCount);
            assertEquals(expectedResults[i], resultCount);
        }
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }
}