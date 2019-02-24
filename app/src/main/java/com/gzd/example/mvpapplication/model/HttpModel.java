package com.gzd.example.mvpapplication.model;

import com.gzd.example.mvpapplication.pojo.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gzd on 2019/2/24 0024
 */
public class HttpModel {
    private HttpModel(){}

    public static HttpModel getInstance(){
        return HttpModelHolder.instance;
    }

    private static class HttpModelHolder{
        private static final HttpModel instance = new HttpModel();
    }

    public void getDataFromHttp(final IModel<List<Book>> model){
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
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                model.getDataFinished(books);
            }
        }).start();
    }
}
