package com.test.project.cookieandsession;

import java.util.HashMap;
import java.util.Map;


public class DBUtil {
    private static Map<String, Book> books = new HashMap<String, Book>();

    static {
        books.put("1", new Book("1", "西游记", 20, "张三"));
        books.put("2", new Book("2", "三国演义", 20, "李四"));
        books.put("3", new Book("3", "水浒传", 30, "王五"));
        books.put("4", new Book("4", "红楼梦", 10, "赵六"));
    }

    public static Map<String, Book> findAllBooks() {
        return books;
    }

    public static Book findBookById(String id) {
        return books.get(id);
    }
}
