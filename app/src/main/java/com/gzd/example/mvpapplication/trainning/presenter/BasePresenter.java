package com.gzd.example.mvpapplication.trainning.presenter;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by gzd on 2019/2/24 0024
 */
public abstract class BasePresenter<T> {  //所有的view，不一定是Activity，类型参数化
    protected Reference<T> mVewRef;

    public void attachView(T view){
        mVewRef = new WeakReference<>(view);  //持有弱引用
    }
    protected T getView(){     //调用弱引用的方法时
        return mVewRef.get();
    }

    public boolean isAttachView(){
        return mVewRef ==null && getView() ==null;
    }
    public void detachView(){
        if (mVewRef != null){
            mVewRef.clear();
            mVewRef = null;
        }
    }
}
