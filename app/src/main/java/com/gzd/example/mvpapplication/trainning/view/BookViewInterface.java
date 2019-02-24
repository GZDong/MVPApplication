package com.gzd.example.mvpapplication.trainning.view;

import com.gzd.example.mvpapplication.pojo.Book;

import java.util.List;

/**
 * Created by gzd on 2019/2/24 0024
 */
public interface BookViewInterface {
    void updateList(List<Book> data);
    void addBook(String result);
}
