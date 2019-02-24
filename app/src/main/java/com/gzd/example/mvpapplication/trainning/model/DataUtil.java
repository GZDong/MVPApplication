package com.gzd.example.mvpapplication.trainning.model;

import com.gzd.example.mvpapplication.pojo.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gzd on 2019/2/24 0024
 */
public class DataUtil {
    private DataUtil(){}

    public static DataUtil getInstance(){
        return DataUtilHolder.instance;
    }
    private static class DataUtilHolder{
        private static final DataUtil instance = new DataUtil();
    }

    public void loadDataFromDBAndSendToPresenter(final DataListener callback){
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
                if (books.size() > 0){
                    callback.onFinish(books);
                }else {
                    loadDataFromHttpAndSendToPresenter(callback);
                }
            }
        }).start();
    }

    public void loadDataFromHttpAndSendToPresenter(final DataListener callback){
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
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                callback.onFinish(books);
            }
        }).start();
    }

    public void loadTitle(DataListener<String> listener){
        //...
        listener.onFinish("it is OK");
    }

    public void addBook(Book book,DataListener<String> listener){
        //...
        listener.onFinish("add finish");
    }
}
