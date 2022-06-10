package com.sjt.lib.book.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sjt.lib.book.dao.BookMapper;
import com.sjt.lib.book.domain.Book;
import com.sjt.lib.book.dto.ResponseResult;
import com.sjt.lib.book.service.BookService;
import com.sjt.lib.book.utils.ExcelTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sujuntao
 */
@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookMapper bookMapper;

    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseResult list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", defaultValue = "7") Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);

        List<Book> bookList = bookService.findBookByCondition(null);
        PageInfo<Book> pageInfo = new PageInfo<>(bookList);
        List<Book>  bookList1 = pageInfo.getList();

        return new ResponseResult("success", "200", bookList1);
    }

    @RequestMapping(value = "add_book", method = RequestMethod.POST)
    public ResponseResult addBook(Book book) {

        int res = bookService.addBook(book);

        if (res == 0){
            return new ResponseResult("fail", "400", "失败");
        }
        return new ResponseResult("success", "200", "成功");
    }

    @RequestMapping(value = "add_books", method = RequestMethod.POST)
    public ResponseResult addBooks(@RequestParam("file") MultipartFile[] files) {

        int res = 0;

        if (res == 0){
            return new ResponseResult("fail", "400", "失败");
        }
        return new ResponseResult("success", "200", "成功");
    }

    @RequestMapping(value = "update_book", method = RequestMethod.POST)
    public ResponseResult updateBook(Book book) {

        Map<String, Object> bookMap = new HashMap<>(4);

        bookMap.put("id", book.getId());
        bookMap.put("name", book.getName());
        bookMap.put("author", book.getAuthor());
        bookMap.put("publish", book.getPublish());

        int res = bookService.updateBook(bookMap);

        if (res == 0){

            return new ResponseResult("fail", "400", "失败");
        }

        return new ResponseResult("success", "200", "成功");
    }

    @RequestMapping(value = "delete_book", method = RequestMethod.DELETE)
    public ResponseResult deleteBook(@RequestParam(value = "pageNum", defaultValue = "1") Integer id) {

        Map<String, Object> bookMap = new HashMap<>(4);
        bookMap.put("id", id);

        int res = bookService.deleteBookById(bookMap);

        if (res == 0) {

            return new ResponseResult("fail", "400", "失败");
        }

        return new ResponseResult("success", "200", "成功");
    }

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult upload(MultipartFile file) throws IOException {

        String fileName = file.getName();
        System.out.println(fileName);

        InputStream inputStream = file.getInputStream();

        // 这里每次会读取100条数据 然后返回过来 直接调用使用数据就行
        EasyExcel.read(inputStream, Book.class, new PageReadListener<Book>(dataList -> {
            bookService.addBooks(dataList);
        })).sheet().doRead();

        return new ResponseResult("success", "200", "成功");
    }

    /**
     * 文件下载（失败了会返回一个有部分数据的Excel）
     */
    @GetMapping("download")
    public void download(HttpServletResponse response) throws IOException {

        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("书籍信息", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        ExcelTools excelTools = new ExcelTools();

        EasyExcel.write(response.getOutputStream(), Book.class).sheet("模板")
                .head(excelTools.head())
                .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
                .doWrite(excelTools.data(bookMapper));

    }

}
