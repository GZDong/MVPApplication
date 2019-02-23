package com.gzd.example.mvpapplication.event;

import com.gzd.example.mvpapplication.pojo.Book;

import java.util.List;

/**
 * Created by gzd on 2019/2/24 0024
 */
public class MessageFromDB extends Message{
    public MessageFromDB(List<Book> books) {
        super(books);
    }

    @Override
    public void setTag() {
        tag = 0;
    }
}
