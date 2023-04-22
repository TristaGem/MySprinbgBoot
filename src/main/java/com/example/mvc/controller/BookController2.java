package com.example.mvc.controller;


import com.example.mvc.controller.util.R;
import com.example.mvc.dao.BookDao;
import com.example.mvc.domain.Book;
import com.example.mvc.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/books")
public class BookController2 {

//    private static final Logger logger = LoggerFactory.getLogger(BookController2.class);

    @Autowired
    private BookService bookService;

    @GetMapping
    R getAll() {
        R r = new R();
        r.setData(bookService.getAll());
        return r;
    }

    @PostMapping
    R save(@RequestBody Book book) {
        return new R(bookService.save(book));
    }

    @PutMapping
    R update(@RequestBody Book book) {
        return new R(bookService.update(book));
    }

    @DeleteMapping("{id}")
    R delete(@PathVariable Integer id) {
        return new R(bookService.delete(id));
    }

    @GetMapping("{id}")
    R getById(@PathVariable Integer id) {
        R r = new R();
        try {
            Book book = bookService.getById(id);
            r.setFlag(true);
            r.setData(book);
        } catch (Exception e) {
            return r;
        }
        log.info("info,,");
        log.warn("warn.......");
        log.error("error....");
        return r;
    }
}
