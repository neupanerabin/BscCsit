package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

public class BBCNewsScraper {

    private WebDriver driver;
    private WebDriverWait wait;

    public BBCNewsScraper() {
        // Set the path to the WebDriver executable
        System.setProperty("webdriver.chrome.driver", "/Users/rabin/Downloads/chromedriver-mac-x64/chromedriver");

        // Initialize ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);  // Use NORMAL strategy
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-gpu");
        options.addArguments("--headless");  // Run in headless mode
        options.addArguments("--no-sandbox");  // Bypass OS security model
        options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation", "disable-infobars"));

        // Initialize the WebDriver with ChromeOptions
        this.driver = new ChromeDriver(options);
        this.wait = new WebDriverWait(driver, 20);  // Increase the timeout to 20 seconds
    }

    public void scrapeHeadlines() {
        try {
            // Open the BBC News homepage
            driver.get("https://www.bbc.com/news");

            // Wait for the headlines to be visible
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h3")));

            // Locate and print the headlines
            List<WebElement> headlines = driver.findElements(By.cssSelector("h3"));
            for (WebElement headline : headlines) {
                System.out.println(headline.getText());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }

    public void scrapeTableData() {
        try {
            // Open the BBC News homepage (or any page with a table)
            driver.get("https://www.bbc.com/news");

            // Example waiting for a dynamic element to load
            WebElement dynamicElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".some-dynamic-class"))); // Adjust as needed

            // Locate table rows
            List<WebElement> rows = driver.findElements(By.cssSelector("table tr"));
            for (WebElement row : rows) {
                List<WebElement> cells = row.findElements(By.cssSelector("td"));
                for (WebElement cell : cells) {
                    System.out.println(cell.getText());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }


}
