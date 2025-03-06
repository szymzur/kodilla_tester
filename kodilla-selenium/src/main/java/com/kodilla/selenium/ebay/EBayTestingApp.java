package com.kodilla.selenium.ebay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EBayTestingApp {
    public static void main(String[] args) {
        // Ustawienie właściwości systemowej dla lokalizacji sterownika Chrome
        System.setProperty("webdriver.chrome.driver", "c:/selenium-drivers/chrome/chromedriver.exe");

        // Utworzenie nowej instancji przeglądarki Chrome
        WebDriver driver = new ChromeDriver();

        // Otwórz stronę eBay
        driver.get("https://www.ebay.com/");

        // Znajdź pole do wyszukiwania
        WebElement searchBox = driver.findElement(By.id("gh-ac"));
        searchBox.sendKeys("Laptop");

        // Utworzenie instancji WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // Znajdź przycisk wyszukiwania za pomocą nazwy klasy i poczekaj, aż będzie klikalny
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("gh-search-button__label")));

        // Kliknij przycisk wyszukiwania
        searchButton.click();

        // Zamknij przeglądarkę
        driver.quit();
    }
}