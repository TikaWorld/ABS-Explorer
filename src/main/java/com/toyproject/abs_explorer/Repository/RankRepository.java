package com.toyproject.abs_explorer.Repository;

import com.toyproject.abs_explorer.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RankRepository extends JpaRepository<Book, Book.BookPK>{
}
