package com.sjt.lib.book.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.sjt.lib.book.domain.Book;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sujuntao
 */
@Slf4j
public class BookDataListener extends AnalysisEventListener<Book> {

    private List<Book> list = new ArrayList<>();

    @Override
    public void invoke(Book book, AnalysisContext analysisContext) {

        list.add(book);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
    }

    public List<Book> getData() {

        return list;
    }
}