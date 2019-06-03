package com.toyproject.abs_explorer;

import com.toyproject.abs_explorer.Entity.*;
import com.toyproject.abs_explorer.Repository.CategoryRepository;
import com.toyproject.abs_explorer.Repository.RankRepository;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class SearchController {

    @Autowired
    private RankRepository rankRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    private AmazonSearcher amazonSearcher = new AmazonSearcher();

    @RequestMapping(method= RequestMethod.GET)
    public String renewelMainCategory() {
        Category main = amazonSearcher.mainCategory;
        renewelCategory(main);
        return "renewel";
    }

    @Transactional
    void renewelCategory(Category current) {
        List<Category> categoryList = amazonSearcher.getCategory(current);
        for(Category newCategory: categoryList){
            categoryRepository.save(newCategory);
        }
    }

    @Transactional
    public String renewelBookRank(Category category) {
        List<Book> books = amazonSearcher.getBookList(category);
        for(Book newBook: books){
            rankRepository.save(newBook);
        }
        return "Renewl!";
    }
}
