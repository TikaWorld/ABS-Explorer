package com.toyproject.abs_explorer;

import com.toyproject.abs_explorer.Entity.Book;
import com.toyproject.abs_explorer.Entity.Category;
import com.toyproject.abs_explorer.Repository.CategoryRepository;
import com.toyproject.abs_explorer.Repository.RankRepository;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchControllerTest {

    @Autowired
    private RankRepository rankRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    private SearchController searchController = new SearchController();
    private AmazonSearcher amazonSearcher = new AmazonSearcher();

    @Test
    @Transactional
    @Rollback(false)
    public void testRenewelCategory(){
        Elements categories = amazonSearcher.crawlCategory(amazonSearcher.mainCategory.getUrl());
        for(Element category: categories){
            Category newCategory = new Category(category.text(),category.attr("abs:href").replace("https://www.amazon.com", ""));
            categoryRepository.save(newCategory);
        }
    }

}
