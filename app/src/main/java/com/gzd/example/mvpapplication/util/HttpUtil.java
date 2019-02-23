package com.gzd.example.mvpapplication.util;

import android.util.Log;

import com.gzd.example.mvpapplication.event.MessageFromHttp;
import com.gzd.example.mvpapplication.pojo.Book;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gzd on 2019/2/24 0024
 */
public class HttpUtil {
    private static HttpUtil mHttpUtil;
    private HttpUtil(){}

    public static HttpUtil getInstance(){
        if (mHttpUtil == null){
            synchronized (HttpUtil.class){
                if (mHttpUtil == null){
                    mHttpUtil = new HttpUtil();
                    return mHttpUtil;
                }
            }
        }
        return mHttpUtil;
    }

    public void connection(String url){
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<Book> books = new ArrayList<>();
                for (int i = 7; i < 10; i ++){
                    Book book = new Book();
                    book.setName("name" + i);
                    book.setPrice(10+i);
                    books.add(book);
                }
                EventBus.getDefault().post(new MessageFromHttp(books));
            }
        }).start();
    }
}
