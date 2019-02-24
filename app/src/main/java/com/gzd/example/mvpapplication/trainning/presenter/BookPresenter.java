package com.gzd.example.mvpapplication.trainning.presenter;

import com.gzd.example.mvpapplication.pojo.Book;
import com.gzd.example.mvpapplication.presenter.BasePresenter;
import com.gzd.example.mvpapplication.trainning.model.DataListener;
import com.gzd.example.mvpapplication.trainning.model.DataUtil;
import com.gzd.example.mvpapplication.trainning.view.BookViewInterface;

import java.util.List;

/**
 * Created by gzd on 2019/2/24 0024
 */
public class BookPresenter extends BasePresenter<BookViewInterface> implements DataListener<List<Book>> {
    private DataUtil mDataUtil = DataUtil.getInstance();

    public void setModelToView(){
        mDataUtil.loadDataFromDBAndSendToPresenter(this);
    }

    @Override
    public void onFinish(List<Book> books) {
        getView().updateList(books);
    }

    public void addBook(Book book){
        mDataUtil.addBook(book,new DataListener<String>() {
            @Override
            public void onFinish(String result) {
                getView().addBook(result);
            }
        });
    }
}
