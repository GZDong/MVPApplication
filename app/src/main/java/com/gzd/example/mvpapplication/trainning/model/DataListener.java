package com.gzd.example.mvpapplication.trainning.model;

/**
 * Created by gzd on 2019/2/24 0024
 */
public interface DataListener<T> {
    void onFinish(T data);
}
