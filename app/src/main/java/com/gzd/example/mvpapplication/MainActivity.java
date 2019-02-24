package com.gzd.example.mvpapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.gzd.example.mvpapplication.adapter.MainAdapter;
import com.gzd.example.mvpapplication.event.Message;
import com.gzd.example.mvpapplication.pojo.Book;
import com.gzd.example.mvpapplication.trainning.view.MVPBookActivity;
import com.gzd.example.mvpapplication.util.DBUtil;
import com.gzd.example.mvpapplication.util.HttpUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    RecyclerView mRecyclerView;
    List<Book> mBooks = new ArrayList<>();
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
        getDataFromDB();
    }

    private void initView(){
        mRecyclerView = findViewById(R.id.rv_main);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(lm);
        MainAdapter adapter = new MainAdapter(mBooks);
        mRecyclerView.setAdapter(adapter);

        mButton = findViewById(R.id.btn_to_mvp_activity);
        mButton.setOnClickListener(this);
    }

    private void updateView(){
        mRecyclerView.getAdapter().notifyDataSetChanged();
    }

    private void getDataFromDB(){
        DBUtil util = DBUtil.getInstance();
        util.connection("book.db");
    }

    @Subscribe
    public void onEventMainThread(Message message){
        if (message.getTag() == 0){
            mBooks.addAll(message.getBooks());
            initView();
            getDataFromHttp();
        }else if (message.getTag() ==1){
            mBooks.addAll(message.getBooks());
            updateView();
        }
    }

    private void getDataFromHttp(){
        HttpUtil util = HttpUtil.getInstance();
        util.connection("www.book.com");
    }

    @Override
    public void onClick(View v) {
        //Main2ActivityMVP.onActionStart(this);
        startActivity(new Intent(this,MVPBookActivity.class));
    }
}
