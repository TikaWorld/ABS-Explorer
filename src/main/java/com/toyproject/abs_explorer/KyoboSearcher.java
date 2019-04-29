package com.toyproject.abs_explorer;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class KyoboSearcher {
    private String url;
    private DataCrawler dataCrawler;

    KyoboSearcher(){
        this.url = "http://www.kyobobook.co.kr/search/SearchCommonMain.jsp";
        dataCrawler = new DataCrawler(this.url);
    }

    public Element search(String word) {
        Document doc = dataCrawler.parsehttps("?vPstrKeyWord=" + word.replaceAll(" ", "%20") + "&vPplace=top");
        return doc.select("table[class=type_list] > tbody > tr").get(0);
    }
}
