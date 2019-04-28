package com.toyproject.abs_explorer;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class AmazonSearcher {
    private String url;
    private DataCrawler dataCrawler;

    AmazonSearcher() {
        this.url = "https://www.amazon.com";
        this.dataCrawler = new DataCrawler(this.url);
    }

    public Elements getBookElements(String category) {
        Document doc = dataCrawler.parsehttps(category + "/zgbs/books/5");
        Elements books = doc.select("li[class=zg-item-immersion]");
        return books;
    }

    public Elements getCategory() {
        Document doc = dataCrawler.parsehttps("/best-sellers-books-Amazon/zgbs/books/5");
        Elements category = doc.select("div[class=a-fixed-left-grid-col a-col-left]");
        return category;
    }
}
