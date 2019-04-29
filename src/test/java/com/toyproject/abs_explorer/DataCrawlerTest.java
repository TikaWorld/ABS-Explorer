package com.toyproject.abs_explorer;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;


public class DataCrawlerTest {
    @Test
    public void crawlTest() {
        DataCrawler dataCrawler = new DataCrawler("https://www.amazon.com");
        Document doc = dataCrawler.parsehttps("/Best-Sellers-Books-Computers-Technology/zgbs/books/5");
        Elements books = doc.select("li[class=zg-item-immersion]");
        for(Element book: books){
            System.out.println(book.select("span[class=zg-badge-text]").text());
            System.out.println(book.select("span[class=aok-inline-block zg-item] > a[class=a-link-normal]").get(0).text());
        }
    }
}
