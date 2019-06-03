package com.toyproject.abs_explorer;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

public class KyoboSearcherTest {
    @Test
    public void searchTest() {
        KyoboSearcher kyoboSearcher = new KyoboSearcher();
        System.out.println(kyoboSearcher.search("Computer Architecture").select("td[class=detail]"));
    }


}
