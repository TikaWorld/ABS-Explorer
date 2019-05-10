package com.toyproject.abs_explorer;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class BookPK implements Serializable {

    private static final long serialVersionUID = 1L;

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
