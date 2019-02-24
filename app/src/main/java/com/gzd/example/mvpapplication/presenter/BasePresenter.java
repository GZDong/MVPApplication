package com.gzd.example.mvpapplication.presenter;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by gzd on 2019/2/24 0024
 */
public abstract class BasePresenter<T> {
    protected Reference<T> mViewRef;

    public void attachView(T view){
        mViewRef = new WeakReference<>(view);
    }

    protected T getView(){
        return mViewRef.get();
    }

    public boolean isViewAttached(){
        return mViewRef != null && mViewRef.get()!=null;
    }

    public void detachView(){
        if (mViewRef != null){
            mViewRef.clear();
            mViewRef = null;
        }
    }
}
