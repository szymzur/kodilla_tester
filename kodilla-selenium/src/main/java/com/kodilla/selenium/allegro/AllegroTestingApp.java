package com.kodilla.selenium.allegro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Alert;

public class AllegroTestingApp {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "c:/selenium-drivers/chrome/chromedriver.exe");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("==remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://allegro.pl/");

        // Zamknięcie wyskakującego okienka (alert)
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            System.out.println("Brak wyskakującego okienka.");
        }

        // Znajdź i wybierz kategorię "Elektronika" używając XPath Relative
        WebElement categoryCombo = driver.findElement(By.xpath("//select[contains(@id, 'category')]"));
        Select categorySelect = new Select(categoryCombo);
        categorySelect.selectByVisibleText("Elektronika");

        // Wprowadź "Mavic mini" do pola wyszukiwania
        WebElement searchBox = driver.findElement(By.xpath("//input[contains(@type, 'search')]"));
        searchBox.sendKeys("Mavic mini");

        // Kliknij przycisk "Szukaj" używając XPath Relative
        WebElement searchButton = driver.findElement(By.xpath("//button[contains(@type, 'submit')]"));
        searchButton.click();
    }
}