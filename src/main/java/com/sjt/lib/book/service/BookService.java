package com.sjt.lib.book.service;

import com.sjt.lib.book.domain.Book;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sujuntao
 */
public interface BookService {

    /**
     * 获取一书本
     *
     * @param param
     * @return
     */
    List<Book> findBookByCondition(HashMap<String, Object> param);


    /**
     * 添加一本书
     *
     * @param books
     * @return
     */
    int addBooks(List<Book> books);

    /**
     * 添加一本书
     *
     * @param book
     * @return
     */
    int addBook(Book book);

    /**
     * 修改书籍信息
     *
     * @param param
     * @return
     */
    int updateBook(Map<String, Object> param);
    /**
     *  删除书籍
     * @param param
     * @return
     */
    int deleteBookById(Map<String, Object> param);
}
