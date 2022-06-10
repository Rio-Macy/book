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
public class ExcelUtils {

    @Autowired
    private BookMapper bookMapper;

    public void test() {
        // 生成Excel路径
        String fileName = "C:\\Users\\sujuntao\\Desktop\\book6.xlsx";
        EasyExcel.write(fileName).head(head()).sheet("模板").doWrite(data());
    }

    private List<List<String>> head() {

        List<List<String>> list = new ArrayList<>();

        List<String> head0 = new ArrayList<>();
        head0.add("name");
        List<String> head1 = new ArrayList<>();
        head1.add("author");
        List<String> head2 = new ArrayList<>();
        head2.add("publish");
        list.add(head0);
        list.add(head1);
        list.add(head2);
        return list;
    }
    private List<Book> data() {
        List<Book> userList = bookMapper.findBookByCondition(null);
        System.out.println(userList.size());
        return userList;
    }


    public static void main(String[] args) {
        ExcelUtils excelUtils = new ExcelUtils();
    }


}
