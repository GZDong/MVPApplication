package com.gzd.example.mvpapplication.model;

import com.gzd.example.mvpapplication.pojo.Book;

import java.util.List;

/**
 * Created by gzd on 2019/2/24 0024
 */
public interface IModel<T> {
    public void getDataFinished(T data);
}
