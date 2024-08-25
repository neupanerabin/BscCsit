package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        BBCNewsScraper bbcScraper = new BBCNewsScraper();

        // Scrape headlines
        bbcScraper.scrapeHeadlines();
        bbcScraper.scrapeTableData();

        // Scrape table data
        // bbcScraper.scrapeTableData();  // Uncomment this line if you want to scrape table data as well
    }
}
