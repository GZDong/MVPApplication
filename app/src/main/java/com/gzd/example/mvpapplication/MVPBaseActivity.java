package com.gzd.example.mvpapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;

import com.gzd.example.mvpapplication.presenter.BasePresenter;

/**
 * Created by gzd on 2019/2/24 0024
 */
public abstract class MVPBaseActivity<V,T extends BasePresenter<V>> extends Activity {
    protected T mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        mPresenter.attachView((V)this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    protected abstract T createPresenter();   //因为没有办法new T()
}
