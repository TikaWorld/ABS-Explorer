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

    @Test
    @Transactional
    @Rollback(false)
    public void createUser() {
        Book book = new Book();
        book.setBookRank(new Integer(1));
        book.setBookName("BookName");
        book.setTranslated("Yes");
        rankRepository.save(book);
    }
}
