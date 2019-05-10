package com.toyproject.abs_explorer;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="ranking")
public class Book {

    @EmbeddedId
    private BookPK pk;

    private String bookName;

    private String translated;

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
