package com.toyproject.abs_explorer;

import org.jsoup.nodes.Document;

public class KyoboSearcher {
    private String url;
    private DataCrawler dataCrawler;
    KyoboSearcher(){
        this.url = "http://www.kyobobook.co.kr/search/SearchCommonMain.jsp";
        dataCrawler = new DataCrawler(this.url);
    }

    String search(String word) {
        Document doc = dataCrawler.parsehttps("?vPstrKeyWord=" + "&vPplace=top");
    }
}
