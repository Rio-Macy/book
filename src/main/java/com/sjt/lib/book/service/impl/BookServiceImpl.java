package com.sjt.lib.book.service.impl;

import com.sjt.lib.book.dao.BookMapper;
import com.sjt.lib.book.domain.Book;
import com.sjt.lib.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sujuntao
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    /**
     * 获取一书本
     *
     * @param param
     * @return
     */
    @Override
    public List<Book> findBookByCondition(HashMap<String, Object> param) {

        List<Book> bookList = bookMapper.findBookByCondition(param);

        return bookList;
    }

    /**
     * 添加一本书
     *
     * @param books
     * @return
     */
    @Override
    public int addBooks(List<Book> books) {
        return bookMapper.addBooks(books);
    }

    /**
     * 添加一本书
     *
     * @param book
     * @return
     */
    @Override
    public int addBook(Book book) {

        int res = bookMapper.addBook(book);

        return res;
    }

    /**
     * 修改书籍信息
     *
     * @param param
     * @return
     */
    @Override
    public int updateBook(Map<String, Object> param) {
        int res = bookMapper.updateBook(param);

        return res;
    }

    /**
     * 删除书籍
     *
     * @param param
     * @return
     */
    @Override
    public int deleteBookById(Map<String, Object> param) {
        return bookMapper.deleteBookById(param);
    }
}
