package com.example.mvc.controller;


import com.example.mvc.dao.BookDao;
import com.example.mvc.domain.Book;
import com.example.mvc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    List<Book> getAll() {
        return bookService.getAll();
    }

    @PostMapping
    Boolean save(@RequestBody Book book) {
        return bookService.save(book);
    }

    @PutMapping
    Boolean update(@RequestBody Book book) {
        return bookService.update(book);
    }

    @DeleteMapping("{id}")
    Boolean delete(@PathVariable Integer id) {
        return bookService.delete(id);
    }

    @GetMapping("{id}")
    Book getById(@PathVariable Integer id) {
        return bookService.getById(id);
    }
}
