package com.toyproject.abs_explorer;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;

public class DataCrawler {
    private String url;

    DataCrawler(String url) {
        this.url = url;
        parsehttps("");
    }

    Document gethttps(String resource) {
        try {
            return Jsoup.connect(this.url + resource).header("content-type", "application/json;charset=UTF-8")
                    .header("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
                    .header("accept-encoding", "gzip, deflate, br")
                    .header("accept-language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7")
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36")
                    .ignoreContentType(true).get();
        } catch (IOException e) {
            return null;
        }
    }

    Document parsehttps(String resource) {
        try {
            return Jsoup.connect(this.url + resource).header("content-type", "application/json;charset=UTF-8")
                    .header("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
                    .header("accept-encoding", "gzip, deflate, br")
                    .header("accept-language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7")
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36")
                    .ignoreContentType(true).execute().parse();
        } catch (IOException e) {
            return null;
        }
    }


}
