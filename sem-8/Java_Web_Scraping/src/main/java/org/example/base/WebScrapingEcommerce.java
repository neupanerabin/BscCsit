package org.example.base;

/*
 * @author : rabin
 */

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WebScrapingEcommerce {
    public static void main(String[] args) {
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "/Users/rabin/Downloads/chromedriver-mac-x64/chromedriver");

        // Create an instance of ChromeDriver
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JSONArray scrapedData = new JSONArray();

        try {
            // Navigate to the LambdaTest e-commerce website
            driver.get("https://ecommerce-playground.lambdatest.io/");

            // Maximize the browser window
            driver.manage().window().maximize();

            // Wait for element to be visible and then click on it
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(.,'Shop by Category')]")));
            driver.findElement(By.xpath("//a[contains(.,'Shop by Category')]")).click();

            // Wait for phones, tablets category element to be visible and then click on it
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(.,'Phone, Tablets & Ipod')]")));
            driver.findElement(By.xpath("//span[contains(.,'Phone, Tablets & Ipod')]")).click();

            // Wait for all products to load on the screen
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='entry_212408']//div[@class='row']")));

            // Fetch and store the reference to all products parent web element
            WebElement allProducts = driver.findElement(By.xpath("//*[@id='entry_212408']//div[@class='row']"));

            // Use the parent web element to fetch list of web elements for each individual product
            List<WebElement> productList = allProducts.findElements(By.xpath(".//div[contains(@class,'product-layout product-grid no-desc')]"));

            // Traverse the list of product web elements to scrape the required data
            for (WebElement product : productList) {
                WebElement detail = product.findElement(By.xpath(".//a[@class='text-ellipsis-2']"));
                WebElement price = product.findElement(By.xpath(".//span[@class='price-new']"));

                // Store product image link, name and price in a JSON object
                JSONObject productMetaData = new JSONObject();
                productMetaData.put("product_image", detail.getAttribute("href"));
                productMetaData.put("product_name", detail.getText());
                productMetaData.put("product_price", price.getText());

                // Add each product detail to JSON array to aggregate the data at one location
                scrapedData.put(productMetaData);
            }

            // Display the scraped data
            displayScrapedData(scrapedData);
        } finally {
            // Close the browser
            driver.quit();
        }
    }

    private static void displayScrapedData(JSONArray scrapedData) {
        for (int i = 0; i < scrapedData.length(); i++) {
            JSONObject product = scrapedData.getJSONObject(i);
            System.out.println("Product " + (i + 1) + ":");
            System.out.println("  Image URL: " + product.getString("product_image"));
            System.out.println("  Name: " + product.getString("product_name"));
            System.out.println("  Price: " + product.getString("product_price"));
            System.out.println();
        }
    }
}
