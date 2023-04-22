package com.example.mvc;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mvc.dao.BookDao;
import com.example.mvc.domain.Book;
import com.example.mvc.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MvcApplicationTests {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private BookService bookService;
    @Test
    void contextLoads() {
        System.out.println(bookDao.selectById(12));
        Book added = new Book();
        added.setId(19);
        added.setDescription("savannah tong test");
        added.setName("another my book");
        added.setType("selfie");
//        System.out.println(bookDao.insert(added));
        System.out.println(bookDao.updateById(added));
    }

    @Test
    void testGetPage() {
        IPage page = new Page(3, 5);
        bookDao.selectPage(page, null);
    }

    @Test
    void testCustomizedQuery() {
        QueryWrapper<Book> qw = new QueryWrapper<>();
        // Select * from where name like 'Spring';
        qw.like("name", "Spring");
        System.out.println(bookDao.selectList(qw));
    }

    @Test
    void testCustomizedQuery2() {
        LambdaQueryWrapper<Book> qw = new LambdaQueryWrapper<>();
        qw.like(Book::getName, "Spring");

        // Select * from where name like 'Spring';
        System.out.println(bookDao.selectList(qw));
    }

    @Test
    void testGetAll() {
        bookService.getAll();
    }


}
