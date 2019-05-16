package com.toyproject.abs_explorer;

import com.toyproject.abs_explorer.Entity.Category;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import org.jsoup.select.Elements;
public class AmazonSearcher {
    private String url;
    private DataCrawler dataCrawler;
    private Category mainCategory = new Category("main","/best-sellers-books-Amazon/zgbs/books/5");

    AmazonSearcher() {
        this.url = "https://www.amazon.com";
        this.dataCrawler = new DataCrawler(this.url);
    }

    Category getMainCategory() {
        return this.mainCategory;
    }

    public Elements getBookElements(String category) {
        Document doc = dataCrawler.parsehttps(category);
        Elements books = doc.select("li[class=zg-item-immersion]");
        return books;
    }

    public Elements getCategory(String category) {
        Document doc = dataCrawler.parsehttps(category);
        Elements categories = doc.select("#zg_browseRoot > ul > ul > ul > li > a");
        return categories;
    }
}
