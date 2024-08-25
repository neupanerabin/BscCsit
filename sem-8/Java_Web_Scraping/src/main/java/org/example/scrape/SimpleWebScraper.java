package org.example.scrape;


/*
 * @author : rabin
 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class SimpleWebScraper {

    public static void main(String[] args) {
        // URL of the website to scrape
        String url = "https://example.com";

        try {
            // Fetch the HTML from the URL
            Document doc = Jsoup.connect(url).get();

            // Print the title of the page
            String title = doc.title();
            System.out.println("Title: " + title);

            // Extract and print the first paragraph
            Element firstParagraph = doc.select("p").first();
            if (firstParagraph != null) {
                System.out.println("First paragraph: " + firstParagraph.text());
            } else {
                System.out.println("No paragraphs found.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
