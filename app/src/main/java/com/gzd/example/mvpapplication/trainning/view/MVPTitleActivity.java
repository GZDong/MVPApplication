package com.gzd.example.mvpapplication.trainning.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gzd.example.mvpapplication.R;
import com.gzd.example.mvpapplication.trainning.presenter.TitlePresenter;

public class MVPTitleActivity extends MVPBaseActivity<TitleViewInterface,TitlePresenter> implements TitleViewInterface{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvptitle);
    }

    @Override
    protected TitlePresenter createPresenter() {
        return new TitlePresenter();
    }

    @Override
    public void updateTitle(String title) {

    }
}
