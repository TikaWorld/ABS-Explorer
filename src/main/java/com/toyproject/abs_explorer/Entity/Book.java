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

}
