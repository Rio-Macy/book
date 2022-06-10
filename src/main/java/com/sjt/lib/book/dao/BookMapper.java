package com.sjt.lib.book.dao;

import com.sjt.lib.book.domain.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author sujuntao
 */
@Mapper
public interface BookMapper {

    /**
     *  查询书籍
     * @param param
     * @return
     */
    List<Book> findBookByCondition(Map<String, Object> param);

    /**
     *  添加一本书
     * @param book
     * @return
     */
    int addBook(Book book);

    /**
     * 录入大量书籍
     * @param books
     * @return
     */
    int addBooks(List<Book> books);

    /**
     *  修改书籍信息
     * @param param
     * @return
     */
    int updateBook(Map<String, Object> param);

    /**
     * 修改书籍信息
     *
     * @param listBook
     * @return
     */
    int updateBooks(List<Book> listBook);

    /**
     *  修改书籍信息
     * @param param
     * @return
     */
    int updateBook(Book param);

    /**
     *  删除书籍
     * @param param
     * @return
     */
    int deleteBookById(Map<String, Object> param);
}
