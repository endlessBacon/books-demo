package com.sam.digicertbooksdemo.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sam.digicertbooksdemo.exceptions.ResourceNotFoundException;
import com.sam.digicertbooksdemo.models.Book;
import com.sam.digicertbooksdemo.services.BookService;

@RestController
@RequestMapping("books")
public class BookController {

    private BookService service;

    @Autowired
    public BookController(BookService bookService) {
        this.service = bookService;
    }

    @RequestMapping(value="/{bookId}", method = RequestMethod.GET)
    public Book getBook(@PathVariable(value = "bookId") Integer id) {
        Book book = service.getBook(id);

        if(book == null) {
            throw new ResourceNotFoundException("book not found: " + id);
        }

        return service.getBook(id);
    }

    @RequestMapping(value="", method = RequestMethod.GET)
    public Collection<Book> listBooks() {
        return service.getBooks();
    }

    @RequestMapping(value="", method = RequestMethod.POST)
    public Book createBook(@RequestBody Book book) {
        return this.service.createBook(book);
    }

    @RequestMapping(value="/{bookId}", method = RequestMethod.PUT)
    public void updateBook(@RequestBody Book book) {
        this.service.updateBook(book);
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @RequestMapping(value="/{bookId}", method = RequestMethod.DELETE)
    public void deleteBook(@PathVariable(value = "bookId") Integer id) {
        this.service.deleteBook(id);
    }
}