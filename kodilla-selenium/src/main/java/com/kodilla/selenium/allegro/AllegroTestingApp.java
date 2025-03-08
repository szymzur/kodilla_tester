package com.kodilla.selenium.allegro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class AllegroTestingApp {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "c:/selenium-drivers/chrome/chromedriver.exe");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("==remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.ebay.pl/");

        // Wprowadź "Mavic mini" do pola wyszukiwania
        WebElement searchBox = driver.findElement(By.cssSelector("input[type='text']"));
        searchBox.sendKeys("Mavic mini");

        // Kliknij przycisk "Szukaj" używając className
        WebElement searchButton = driver.findElement(By.className("gh-search-button__label"));
        searchButton.click();

        // Dodaj wait, który poczeka na pierwszy wynik wyszukiwania
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".s-item")));

        // Znajdź wszystkie karty produktów i przypisz je do jednej listy
        List<WebElement> productCards = driver.findElements(By.cssSelector(".s-item"));

        // Wyświetl informacje o produkcie za pomocą getText()
        for (WebElement productCard : productCards) {
            System.out.println(productCard.getText());
        }
    }
}