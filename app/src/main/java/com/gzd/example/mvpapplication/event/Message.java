package com.gzd.example.mvpapplication.event;

import com.gzd.example.mvpapplication.pojo.Book;

import java.util.List;

/**
 * Created by gzd on 2019/2/24 0024
 */
public abstract class Message {
    protected List<Book> mBooks;
    protected int tag;

    public Message(List<Book> books){
        mBooks = books;
    }
    public List<Book> getBooks() {
        return mBooks;
    }

    public void setBooks(List<Book> books) {
        mBooks = books;
    }

    public int getTag() {
        return tag;
    }

    public abstract void setTag();
}
