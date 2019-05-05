package com.toyproject.abs_explorer;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="ranking")
public class Book {

    @Id
    private Integer bookRank;

    private String bookName;

    private String translated;

    Integer getBookRank() {
        return bookRank;
    }

    void setBookRank(Integer bookRank) {
        bookRank = this.bookRank;
    }

    String getBookName() {
        return bookName;
    }

    void setBookName(String bookName) {
        bookName = this.bookName;
    }

    String getTranslated() {
        return translated;
    }

    void setTranslated(String translated) {
        translated = this.translated;
    }


}
