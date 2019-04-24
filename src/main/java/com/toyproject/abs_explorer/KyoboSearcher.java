package com.toyproject.abs_explorer;

import org.jsoup.nodes.Document;

public class KyoboSearcher {
    private String url;
    private DataCrawler dataCrawler;
    KyoboSearcher(){
        this.url = "http://www.kyobobook.co.kr/search/SearchCommonMain.jsp";
        dataCrawler = new DataCrawler(this.url);
    }

    public void search(String word) {
        Document doc = dataCrawler.parsehttps("?vPstrKeyWord=" + regularization(word) + "&vPplace=top");
    }

    protected String regularization(String sentence) {
        String words[] = sentence.split(" ");
        String newStence = "";
        for(String word: words) {
            newStence = newStence + word;
            newStence = newStence + "%20";
        }
        return replaceLast(newStence, "%20", "");
    }

    private static String replaceLast(String string, String toReplace, String replacement) {
        int pos = string.lastIndexOf(toReplace);
        if (pos > -1) {
            return string.substring(0, pos)+ replacement + string.substring(pos + toReplace.length(), string.length());
        } else {
            return string;
        }
    }
}
