package com.toyproject.abs_explorer;

import com.toyproject.abs_explorer.Entity.Book;
import com.toyproject.abs_explorer.Entity.Category;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import org.jsoup.select.Elements;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class AmazonSearcher {
    private String url;
    private DataCrawler dataCrawler;
    public final Category mainCategory = new Category("main","/best-sellers-books-Amazon/zgbs/books/5");

    AmazonSearcher() {
        this.url = "https://www.amazon.com";
        this.dataCrawler = new DataCrawler(this.url);
    }

    public Elements crawlBooks(String category) {
        Document doc = dataCrawler.parsehttps(category);
        Elements books = doc.select("li[class=zg-item-immersion]");
        return books;
    }

    public Elements crawlCategory(String category) {
        Document doc = dataCrawler.parsehttps(category);
        Elements categories = doc.select("#zg_browseRoot > ul > ul > ul > li > a");
        return categories;
    }

    public List<Category> getCategory(Category current) {
        Elements categories = crawlCategory(current.getUrl());
        List<Category> categoryList = new List<Category>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Category> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Category category) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Category> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends Category> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Category get(int index) {
                return null;
            }

            @Override
            public Category set(int index, Category element) {
                return null;
            }

            @Override
            public void add(int index, Category element) {

            }

            @Override
            public Category remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Category> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Category> listIterator(int index) {
                return null;
            }

            @Override
            public List<Category> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
        for(Element category: categories){
            Category newCategory = new Category(category.text(),category.attr("abs:href").replace("https://www.amazon.com", ""));
            categoryList.add(newCategory);
        }
        return categoryList;
    }

    public List<Book> getBookList(Category category) {
        Elements books = crawlBooks(category.getUrl());
        List<Book> bookList = new List<Book>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Book> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Book book) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Book> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends Book> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Book get(int index) {
                return null;
            }

            @Override
            public Book set(int index, Book element) {
                return null;
            }

            @Override
            public void add(int index, Book element) {

            }

            @Override
            public Book remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Book> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Book> listIterator(int index) {
                return null;
            }

            @Override
            public List<Book> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
        for(Element book: books){
            Book.BookPK pk = new Book.BookPK(new Long(book.select("span[class=zg-badge-text]").text().replace("#","")), category.getName());
            Book newBook = new Book(pk, book.select("span[class=aok-inline-block zg-item] > a[class=a-link-normal]").get(0).text(), "NULL" );
            newBook.setTranslated("NULL");
            bookList.add(newBook);
        }
        return bookList;
    }
}
