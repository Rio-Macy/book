package com.sjt.lib.book.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.*;

/**
 * book
 *
 * @author bianj
 * @version 1.0.0 2022-06-08
 */

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Data
public class Book implements java.io.Serializable {

    /**
     * 版本号
     */
    private static final long serialVersionUID = -1444057211464582430L;

    /**
     * id
     */
    private Integer id;

    /**
     * name
     */
    @ExcelProperty(index = 0)
    private String name;

    /**
     * author
     */
    @ExcelProperty(index = 1)
    private String author;

    /**
     * publish
     */
    @ExcelProperty(index = 2)
    private String publish;

    public Book(Integer id, String name, String author, String publish) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publish = publish;
    }

    public Book(String name, String author, String publish) {
        this.name = name;
        this.author = author;
        this.publish = publish;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publish='" + publish + '\'' +
                '}';
    }
}
