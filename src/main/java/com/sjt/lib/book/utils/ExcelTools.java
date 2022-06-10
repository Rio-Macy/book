package com.sjt.lib.book.utils;

import com.alibaba.excel.EasyExcel;
import com.sjt.lib.book.dao.BookMapper;
import com.sjt.lib.book.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sujuntao
 */
public class ExcelTools {

    public List<List<String>> head() {
        List<List<String>> list = new ArrayList<>(3);
        List<String> head0 = new ArrayList<>(1);
        head0.add("name");
        List<String> head1 = new ArrayList<>(1);
        head1.add("author");
        List<String> head2 = new ArrayList<>(1);
        head2.add("publish");
        list.add(head0);
        list.add(head1);
        list.add(head2);
        return list;
    }

    public List<List<Object>> data(BookMapper bookMapper) {

        List<List<Object>> list = new ArrayList<>();
        List<Book> bookList = bookMapper.findBookByCondition(null);

        for (int i = 0; i < bookList.size(); i++) {

            List<Object> data = new ArrayList<>();
            data.add(bookList.get(i).getName());
            data.add(bookList.get(i).getAuthor());
            data.add(bookList.get(i).getPublish());
            list.add(data);
        }
        return list;
    }
}
