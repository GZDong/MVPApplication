package com.gzd.example.mvpapplication.util;

import android.util.Log;

import com.gzd.example.mvpapplication.event.MessageFromDB;
import com.gzd.example.mvpapplication.pojo.Book;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gzd on 2019/2/24 0024
 */
public class DBUtil {
    private DBUtil(){

    }
    public static DBUtil getInstance(){
        return SingletonOwner.mDBUtil;
    }

    private static class SingletonOwner{
        private static final DBUtil mDBUtil = new DBUtil();
    }

    public void connection(String db){
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<Book> books = new ArrayList<>();
                for (int i = 0; i < 6; i ++){
                    Book book = new Book();
                    book.setName("name" + i);
                    book.setPrice(10+i);
                    books.add(book);
                }
                EventBus.getDefault().post(new MessageFromDB(books));
            }
        }).start();
    }
}
