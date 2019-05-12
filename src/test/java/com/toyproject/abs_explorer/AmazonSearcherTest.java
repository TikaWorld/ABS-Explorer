package com.toyproject.abs_explorer;

import static org.junit.Assert.*;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

public class AmazonSearcherTest {
    @Test
    public void getCategoryTest() {
        AmazonSearcher amazonSearcher = new AmazonSearcher();
        Elements categories = amazonSearcher.getCategory();
        for(Element category: categories){
            System.out.println(category.text());
            System.out.println(category.attr("abs:href").replace("https://www.amazon.com", ""));
        }
    }
}
