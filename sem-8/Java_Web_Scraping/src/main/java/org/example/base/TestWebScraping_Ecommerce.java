package org.example.base;

import org.example.base.Database_Connection;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TestWebScraping_Ecommerce extends base.BaseTest {
    private JSONArray scrapedData = new JSONArray();

    @Test
    public void testScrapingEcommerce() {
        driver.get("https://ecommerce-playground.lambdatest.io/");
        driver.manage().window().maximize();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(.,'Shop by Category')]")));
        driver.findElement(By.xpath("//a[contains(.,'Shop by Category')]")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(.,'Phone, Tablets & Ipod')]")));
        driver.findElement(By.xpath("//span[contains(.,'Phone, Tablets & Ipod')]")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='entry_212408']//div[@class='row']")));
        WebElement allProducts = driver.findElement(By.xpath("//*[@id='entry_212408']//div[@class='row']"));
        List<WebElement> productList = allProducts.findElements(By.xpath(".//div[contains(@class,'product-layout product-grid no-desc')]"));

        for (WebElement product : productList) {
            try {
                WebElement detail = product.findElement(By.xpath(".//a[@class='text-ellipsis-2']"));
                WebElement price = product.findElement(By.xpath(".//span[@class='price-new']"));

                String productName = detail.getText().trim();
                String productPrice = price.getText().replaceAll("[^0-9.]", "");
                String productImage = detail.getAttribute("href").trim();

                JSONObject productMetaData = new JSONObject();
                productMetaData.put("product_image", productImage);
                productMetaData.put("product_name", productName);
                productMetaData.put("product_price", productPrice);

                scrapedData.put(productMetaData);
                insertDataIntoDatabase(detail.getAttribute("href"), detail.getText(), price.getText());

            } catch (Exception e) {
                System.out.println("Element not found: " + e.getMessage());
            }
        }
        System.out.println(scrapedData.toString(1));
    }

    private void insertDataIntoDatabase(String imageUrl, String productName, String productPrice) {
        String checkQuery = "SELECT COUNT(*) FROM Scrape_data WHERE product_image = ? AND product_name = ? AND product_price = ?";
        String insertQuery = "INSERT INTO Scrape_data (product_image, product_name, product_price) VALUES (?, ?, ?)";

        Database_Connection DatabaseHelper = new Database_Connection();
        try (Connection connection = Database_Connection.getConnection();
             PreparedStatement checkStatement = connection.prepareStatement(checkQuery);
             PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {

            checkStatement.setString(1, imageUrl);
            checkStatement.setString(2, productName);
            checkStatement.setString(3, productPrice);

            ResultSet resultSet = checkStatement.executeQuery();
            if (resultSet.next() && resultSet.getInt(1) > 0) {
                System.out.println("Duplicate data found: " + imageUrl + ", " + productName + ", " + productPrice);
            } else {
                insertStatement.setString(1, imageUrl);
                insertStatement.setString(2, productName);
                insertStatement.setString(3, productPrice);

                insertStatement.executeUpdate();
                System.out.println("Inserted data: " + imageUrl + ", " + productName + ", " + productPrice);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
