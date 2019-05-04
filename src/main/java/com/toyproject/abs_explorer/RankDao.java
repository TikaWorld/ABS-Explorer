package com.toyproject.abs_explorer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RankDao {

    @Autowired
    private JdbcTemplate template;

    public void insertNewContent(String content) {
        template.update("INSERT INTO entries(bookRank, bookName, chkTranslated)");
    }
}
