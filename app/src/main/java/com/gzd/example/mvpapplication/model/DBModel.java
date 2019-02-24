package com.gzd.example.mvpapplication.model;

import com.gzd.example.mvpapplication.pojo.Book;
import com.gzd.example.mvpapplication.util.DBUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gzd on 2019/2/24 0024
 */
public class DBModel {
    private static DBModel mDBModel;
    private DBModel(){}
    public static DBModel getInstance(){
        if (mDBModel == null){
            synchronized (DBModel.class){
                if (mDBModel == null){
                    mDBModel = new DBModel();
                    return mDBModel;
                }
            }
        }
        return mDBModel;
    }
    public void getDataFromDB(final IModel<List<Book>> model){
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
                try {
                    Thread.sleep(2500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                model.getDataFinished(books);
            }
        }).start();
    }
}
