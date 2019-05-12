package com.toyproject.abs_explorer.Entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="ranking")
public class Book {

    @Embeddable
    public static class BookPK implements Serializable {

        @Column(name="book_rank", nullable=false)
        private Long bookRank;

        @Column(name="category", nullable=false)
        private String category;

        public BookPK(){}

        public BookPK(Long bookRank, String category) {
            super();
            this.bookRank = bookRank;
            this.category = category;
        }

        public Long getBookRank() {
            return this.bookRank;
        }

        public String getCategory()  {
            return this.category;
        }
    }


    @EmbeddedId
    private BookPK pk;

    private String bookName;

    private String translated;

    public Book(){}

    public Book(BookPK pk, String bookName, String translated) {
        this.pk = pk;
        this.bookName = bookName;
        this.translated = translated;
    }

    public BookPK getPk() {
        return pk;
    }

    public void setPk(BookPK pk) {
        this.pk = pk;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTranslated() {
        return translated;
    }

    public void setTranslated(String translated) {
        this.translated = translated;
    }
}
