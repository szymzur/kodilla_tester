package com.kodilla.selenium.pom;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KodillaStorePomTest {

    WebDriver driver;
    KodillaStorePom storePom;

    @BeforeEach
    public void setup() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.navigate().to("https://kodilla.com/pl/test/store");
        storePom = new KodillaStorePom(driver);
    }

    @Test
    public void testSearchResultsCount() {
        assertEquals(2, storePom.getSearchResultsCount("NoteBook"));
        assertEquals(1, storePom.getSearchResultsCount("School"));
        assertEquals(1, storePom.getSearchResultsCount("Brand"));
        assertEquals(0, storePom.getSearchResultsCount("Business"));
        assertEquals(1, storePom.getSearchResultsCount("Gaming"));
        assertEquals(3, storePom.getSearchResultsCount("Laptop"));
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }
}
