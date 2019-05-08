package com.toyproject.abs_explorer;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchControllerTest {

    @Autowired
    private RankRepository rankRepository;

    private SearchController searchController = new SearchController();
    private AmazonSearcher amazonSearcher = new AmazonSearcher();

    @Test
    @Transactional
    @Rollback(false)
    public void testRenewelBookRank(){
        Elements books = amazonSearcher.getBookElements("/best-sellers-books-computers-technology/zgbs/books/5/ref=zg_bs_nav_b_1_b");
        for(Element book: books){
            System.out.println(book);
            Book newBook = new Book();
            newBook.setBookRank(new Long(book.select("span[class=zg-badge-text]").text().replace("#","")));
            newBook.setBookName(book.select("span[class=aok-inline-block zg-item] > a[class=a-link-normal]").get(0).text());
            newBook.setTranslated("NULL");
            rankRepository.save(newBook);
        }
    }
}
