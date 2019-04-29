package com.toyproject.abs_explorer;

import static org.junit.Assert.*;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

public class KyoboSearcherTest {
    @Test
    public void searchTest() {
        KyoboSearcher kyoboSearcher = new KyoboSearcher();
        System.out.println(kyoboSearcher.search("Computer Architecture").select("td[class=detail]"));
    }

    @Test
    public void crawlAndSearchTest() {
        KyoboSearcher kyoboSearcher = new KyoboSearcher();
        AmazonSearcher amazonSearcher = new AmazonSearcher();
        Elements books = amazonSearcher.getBookElements("/Best-Sellers-Books-Computer-Programming");
        for(Element book: books) {
            System.out.println(book.select("span[class=zg-badge-text]").text());
            System.out.println(kyoboSearcher.search(book.select("span[class=aok-inline-block zg-item] > a[class=a-link-normal]").get(0).text()).select("td[class=detail]"));
        }
    }
}
