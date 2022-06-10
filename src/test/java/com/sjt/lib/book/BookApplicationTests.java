package com.sjt.lib.book;

import com.sjt.lib.book.controller.BookController;
import com.sjt.lib.book.dao.BookMapper;
import com.sjt.lib.book.domain.Book;
import com.sjt.lib.book.dto.ResponseResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;

@SpringBootTest
class BookApplicationTests {

    @Autowired
    private BookMapper bookMapper;

    @Test
    void contextLoads() {
        HashMap<String, Object> hashMap = new HashMap<>(2);
        List<Book> books = bookMapper.findBookByCondition(hashMap);
        System.out.println(books);
        System.out.println(books.get(1).toString());

        System.out.println(books.get(1).getId());
    }

    @Autowired
    private BookController bookController;

    @Test
     void getUsers() {
        ResponseResult responseResult = bookController.list(2, 7);
        System.out.println(responseResult.toString());
    }

}
