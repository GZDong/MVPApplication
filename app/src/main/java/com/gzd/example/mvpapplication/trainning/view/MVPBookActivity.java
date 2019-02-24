package com.gzd.example.mvpapplication.trainning.view;

import android.os.Handler;
import android.os.Message;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.gzd.example.mvpapplication.R;
import com.gzd.example.mvpapplication.pojo.Book;
import com.gzd.example.mvpapplication.trainning.presenter.BookPresenter;

import java.util.List;

public class MVPBookActivity extends MVPBaseActivity<BookViewInterface,BookPresenter> implements BookViewInterface{

    private TextView mTextView;
    private List<Book> mBooks;
    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if (msg.what == 1){
                for (Book book : mBooks){
                    mTextView.setText(mTextView.getText() + "\n" + book.getName() + ":" +book.getPrice());
                }
            }
            return true;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        initView();
        presenter.setModelToView();
    }
    private void initView(){
        mTextView = findViewById(R.id.text_book);
        mTextView.setText("begin to get books: ");
        mTextView.setClickable(true);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book();
                book.setName("newBook");
                book.setPrice(100);
                presenter.addBook(book);
            }
        });
    }
    @Override
    protected BookPresenter createPresenter() {
        return new BookPresenter();
    }

    @Override
    public void updateList(List<Book> data) {
        mBooks = data;
        Message message = new Message();
        message.what = 1;
        mHandler.sendMessage(message);
    }

    @Override
    public void addBook(String result) {

    }
}
