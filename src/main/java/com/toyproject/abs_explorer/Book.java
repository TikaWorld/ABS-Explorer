package com.toyproject.abs_explorer;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="ranking")
public class Book {

    @Id
    private Long bookRank;

    private String bookName;

    private String translated;

    Long getBookRank() {
        return bookRank;
    }

    void setBookRank(Long bookRank) {
        this.bookRank = bookRank;
    }

    String getBookName() {
        return bookName;
    }

    void setBookName(String bookName) {
        this.bookName = bookName;
    }

    String getTranslated() {
        return translated;
    }

    void setTranslated(String translated) {
        this.translated = translated;
    }


}
