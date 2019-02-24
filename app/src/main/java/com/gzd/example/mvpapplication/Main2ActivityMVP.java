package com.gzd.example.mvpapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gzd.example.mvpapplication.adapter.MainAdapter;
import com.gzd.example.mvpapplication.pojo.Book;
import com.gzd.example.mvpapplication.presenter.BookPresenter;
import com.gzd.example.mvpapplication.view.ViewInterface;

import java.util.ArrayList;
import java.util.List;

public class Main2ActivityMVP extends MVPBaseActivity<ViewInterface,BookPresenter> implements ViewInterface {

    private RecyclerView mRecyclerView;
    private List<Book> mData = new ArrayList<>();
    public static void onActionStart(Context context){
        Intent intent = new Intent(context,Main2ActivityMVP.class);
        context.startActivity(intent);
    }

    @Override
    protected BookPresenter createPresenter() {
        return new BookPresenter();
    }

    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if (msg.what == 1){
                mRecyclerView.getAdapter().notifyDataSetChanged();
            }
            return true;
        }
    });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_mvp);
        initView();
        mPresenter.showBooksFromDB();
        mPresenter.showBooksFromHttp();
    }

    @Override
    public void showBooks(List<Book> books) {          //这里是不能执行UI操作的
        mData.addAll(books);
        Message message = new Message();
        message.what = 1;
        mHandler.sendMessage(message);
    }

    private void initView(){
        mRecyclerView = findViewById(R.id.rv_main2);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(lm);
        MainAdapter adapter = new MainAdapter(mData);
        mRecyclerView.setAdapter(adapter);
    }
}
