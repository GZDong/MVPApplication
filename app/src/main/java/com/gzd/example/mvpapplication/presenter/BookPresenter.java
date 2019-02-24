package com.gzd.example.mvpapplication.presenter;

import com.gzd.example.mvpapplication.model.DBModel;
import com.gzd.example.mvpapplication.model.HttpModel;
import com.gzd.example.mvpapplication.model.IModel;
import com.gzd.example.mvpapplication.pojo.Book;
import com.gzd.example.mvpapplication.view.ViewInterface;
import java.util.List;

/**
 * Created by gzd on 2019/2/24 0024
 */
public class BookPresenter extends BasePresenter<ViewInterface> {
    DBModel mDBModel = DBModel.getInstance();
    HttpModel mHttpModel = HttpModel.getInstance();

    public void showBooksFromDB(){
        mDBModel.getDataFromDB(new IModel<List<Book>>() {
            @Override
            public void getDataFinished(List<Book> data) {
                getView().showBooks(data);
            }
        });
    }

    public void showBooksFromHttp(){
        mHttpModel.getDataFromHttp(new IModel<List<Book>>() {
            @Override
            public void getDataFinished(List<Book> data) {
                getView().showBooks(data);
            }
        });
    }
}
