package org.example.scrape;

/*
 * @author : rabin
 */

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;

public class SeleniumWebScraper {

    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-gpu");
        options.addArguments("--headless");  // Run in headless mode
        options.addArguments("--no-sandbox");  // Bypass OS security model

        options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation", "disable-infobars"));

        // Path to your WebDriver executable (e.g., ChromeDriver)
        System.setProperty("webdriver.chrome.driver", "/Users/rabin/Downloads/chromedriver-mac-x64/chromedriver");

        // Initialize WebDriver with ChromeOptions
        WebDriver driver = new ChromeDriver(options);

        try {
            // Open the webpage
            System.out.println("Opening the webpage...");
            driver.get("https://www.google.com");

            // Capture and print the page source
            String pageSource = driver.getPageSource();
            System.out.println("Page Source: " + pageSource);

            // Check if the element exists
            if (driver.findElements(By.tagName("p")).size() > 0) {
                System.out.println("<p> tag found.");
            } else {
                System.out.println("<p> tag not found.");
            }

            // Wait for up to 30 seconds for the page to load and the first paragraph element to be visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("p")));

            // Print the title of the page
            String title = driver.getTitle();
            System.out.println("Title: " + title);

            // Find the first paragraph element and print its text
            WebElement firstParagraph = driver.findElement(By.tagName("p"));
            System.out.println("First paragraph: " + firstParagraph.getText());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
