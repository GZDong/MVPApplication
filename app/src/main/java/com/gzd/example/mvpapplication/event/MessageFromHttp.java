package com.gzd.example.mvpapplication.event;

import com.gzd.example.mvpapplication.pojo.Book;

import java.util.List;

/**
 * Created by gzd on 2019/2/24 0024
 */
public class MessageFromHttp extends Message{
    public MessageFromHttp(List<Book> books) {
        super(books);
        setTag();
    }

    @Override
    public void setTag() {
        tag = 1;
    }
}
