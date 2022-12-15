package com.sam.digicertbooksdemo.daos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.sam.digicertbooksdemo.interfaces.Dao;
import com.sam.digicertbooksdemo.models.Book;

@Component
public class BookDao implements Dao<Book> {

    private static ArrayList<Book> books;

    public BookDao() {
        if (books == null) {
            books = new ArrayList<>();
        }
    }

    public Book get(Integer id) {
        Optional<Book> result = books.stream().filter(book -> book.getId() == id).findFirst();
        if(!result.isEmpty())
             return result.get();
        else
            return null;
    }

    public Collection<Book> getAll() {
        return BookDao.books;
    }

    public Book create(Book book) {
        book.setId(books.size() + 1);
        BookDao.books.add(book);
        return book;
    }

    public void update(Book book) {
        Optional<Book> result = books.stream().filter(b -> b.getId() == book.getId()).findFirst();
        if(!result.isEmpty()) {
            int index = books.indexOf(result.get());
            books.set(index, book);
        }
    }

    public void delete(Integer id) {
        Optional<Book> result = books.stream().filter(b -> b.getId() == id).findFirst();
        if(!result.isEmpty()) {
            int index = books.indexOf(result.get());
            books.remove(index);
        }
    }
    
}
