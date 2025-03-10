package com.kodilla.selenium.ebay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EBayTestingApp {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "c:/selenium-drivers/chrome/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.ebay.com/");
            WebElement searchBox = driver.findElement(By.id("gh-ac"));
            searchBox.sendKeys("Laptop");
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("btn btn-prim gh-spr")));
            searchButton.click();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
