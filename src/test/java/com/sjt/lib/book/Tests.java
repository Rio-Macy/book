package com.sjt.lib.book;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import com.sjt.lib.book.dao.BookMapper;
import com.sjt.lib.book.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class Tests {

    @Autowired
    private BookMapper bookMapper;

    private List<List<Object>> data() {
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
    @Test
    public void te() {

        String fileName = "C:\\Users\\sujuntao\\Desktop\\book8.xlsx";
        EasyExcel.write(fileName).head(head()).registerWriteHandler(new LongestMatchColumnWidthStyleStrategy()).sheet("模板").doWrite(data());

    }


    @Test
    public void test1() {

//        ExcelUtils excelUtils = new ExcelUtils();
//        excelUtils.getBooks();
//        String fileName = "C:\\Users\\sujuntao\\Desktop\\book.xlsx";
//        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
//        EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).sheet().doRead();
    }

    /*
     * 不创建对象的写
     */
    @Test
    public void test() {
        // 生成Excel路径  C:\Users\sujuntao\Desktop\新建 Microsoft Excel 工作表.xlsx
        String fileName = "C:\\Users\\sujuntao\\Desktop\\book.xlsx";
//        EasyExcel.write(fileName).head(head()).sheet("模板").doWrite(dataList());
        EasyExcel.write(fileName).head(head()).registerWriteHandler(new LongestMatchColumnWidthStyleStrategy()).sheet("模板").doWrite(dataList());
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

    private List<List<Object>> dataList() {

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


//    @Test
//    public void test1() {
//        // 生成Excel路径
//        String fileName = "C:\\Users\\sujuntao\\Desktop\\测试1.xlsx";
//        EasyExcel.write(fileName, User.class).sheet("模板").doWrite(data());
//    }
//
//    private List<User> data() {
//        List<User> userList = new ArrayList<>();
//        User user;
//        for (int i = 1; i <= 10; i++) {
//            user = new User();
//            user.setName("张三" + i);
//            user.setSex("男");
//            user.setAge(i);
//            user.setCardid("440582xxxx");
//            userList.add(user);
//        }
//        return userList;
//    }
}