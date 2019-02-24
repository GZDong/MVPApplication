package com.gzd.example.mvpapplication.trainning.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.gzd.example.mvpapplication.presenter.BasePresenter;

/**
 * Created by gzd on 2019/2/24 0024
 */
public abstract class MVPBaseActivity<V,P extends BasePresenter<V>> extends AppCompatActivity {  //这里的V代表不同的Activity可能实现不同的接口
                                                                                                //P代表和哪个presenter绑定
    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
        presenter.attachView((V)this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    protected abstract P createPresenter();
}
