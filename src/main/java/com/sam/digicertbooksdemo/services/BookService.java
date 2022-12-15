package com.sam.digicertbooksdemo.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sam.digicertbooksdemo.daos.BookDao;
import com.sam.digicertbooksdemo.models.Book;

@Component(value = "bookService")
public class BookService {

    private BookDao bookDao;

    @Autowired
    public BookService(BookDao dao) {
        this.bookDao = dao;
    }

    public Collection<Book> getBooks() {
        return this.bookDao.getAll();
    }

    public Book getBook(Integer id) {
        return this.bookDao.get(id);
    }

    public Book createBook(Book book) {
        return this.bookDao.create(book);
    }

    public void updateBook(Book book) {
        this.bookDao.update(book);
    }

    public void deleteBook(Integer id) {
        this.bookDao.delete(id);
    }
}
