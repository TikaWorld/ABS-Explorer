package com.toyproject.abs_explorer;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

public class SearchController {

    @Autowired
    private RankRepository rankRepository;

    private AmazonSearcher amazonSearcher = new AmazonSearcher();

    @Transactional
    void renewelBookRank(String category) {
        Elements books = amazonSearcher.getBookElements(category);
        for(Element book: books){
//            Book newBook = new Book();
//            newBook.setBookRank(new Long(book.select("span[class=zg-badge-text]").text().replace("#","")));
//            newBook.setBookName(book.select("span[class=aok-inline-block zg-item] > a[class=a-link-normal]").get(0).text());
//            newBook.setTranslated("NULL");
//            rankRepository.save(newBook);
        }
    }
}
