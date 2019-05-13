package com.toyproject.abs_explorer;

import com.toyproject.abs_explorer.Entity.*;
import com.toyproject.abs_explorer.Repository.CategoryRepository;
import com.toyproject.abs_explorer.Repository.RankRepository;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class SearchController {

    @Autowired
    private RankRepository rankRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    private AmazonSearcher amazonSearcher = new AmazonSearcher();

    @Transactional
    void renewelCategory() {
        Elements categories = amazonSearcher.getCategory();
        for(Element category: categories){
            Category newCategory = new Category(category.text(),category.attr("abs:href").replace("https://www.amazon.com", ""));
            categoryRepository.save(newCategory);
        }
    }

    @Transactional
    void renewelBookRank(Category category) {
        Elements books = amazonSearcher.getBookElements(category.getUrl());
        for(Element book: books){
            Book.BookPK pk = new Book.BookPK(new Long(book.select("span[class=zg-badge-text]").text().replace("#","")), category.getName());
            Book newBook = new Book(pk, book.select("span[class=aok-inline-block zg-item] > a[class=a-link-normal]").get(0).text(), "NULL" );
            newBook.setTranslated("NULL");
            rankRepository.save(newBook);
        }
    }
}
