package com.toyproject.abs_explorer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RankRepositoryTest {

    @Autowired
    private RankRepository rankRepository;

    private SearchController searchController = new SearchController();

    @Test
    @Transactional
    @Rollback(false)
    public void createBook() {
//        Book book = new Book();
//        book.setBookRank(new Long("1"));
//        System.out.println(book.getBookRank());
//        book.setBookName("BookName");
//        book.setTranslated("Yes");
//        System.out.println("DB:" + rankRepository.findAll());
//        rankRepository.save(book);
    }
}
