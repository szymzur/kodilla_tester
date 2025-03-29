package com.kodilla.testcontainers;

import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testcontainers.containers.BrowserWebDriverContainer;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.images.builder.ImageFromDockerfile;
import org.testcontainers.shaded.org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ApplicationTest {

    @Rule
    public GenericContainer<?> businessCardServer =
            new GenericContainer<>(
                    new ImageFromDockerfile()
                            .withFileFromClasspath("/tmp/index.html", "index.html")
                            .withDockerfileFromBuilder(builder ->
                                    builder
                                            .from("httpd:2.4")
                                            .copy("/tmp/index.html", "/usr/local/apache2/htdocs/")
                                            .build()))
                    .withExposedPorts(80);

    @Rule
    public BrowserWebDriverContainer<?> chrome =
            new BrowserWebDriverContainer<>()
                    .withCapabilities(new ChromeOptions());

    @Test
    public void testBusinessCard() throws IOException {
        RemoteWebDriver driver = chrome.getWebDriver();
        driver.get("http://localhost:" + businessCardServer.getMappedPort(80));

        // Pobierz zrzut ekranu
        File screenshot = driver.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("./build/screenshots/" + screenshot.getName()));

        // Zweryfikuj elementy na stronie
        String title = driver.getTitle();
        assertEquals("Business Card", title);

        String headerText = driver.findElement(By.tagName("h1")).getText();
        assertEquals("Hello!", headerText);

        String contact = driver.findElement(By.tagName("a")).getText();
        assertEquals("szymzur@gmail.com", contact);
    }
}