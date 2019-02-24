package com.gzd.example.mvpapplication.trainning.presenter;

import com.gzd.example.mvpapplication.presenter.BasePresenter;
import com.gzd.example.mvpapplication.trainning.model.DataListener;
import com.gzd.example.mvpapplication.trainning.model.DataUtil;
import com.gzd.example.mvpapplication.trainning.view.TitleViewInterface;

/**
 * Created by gzd on 2019/2/24 0024
 */
public class TitlePresenter extends BasePresenter<TitleViewInterface> implements DataListener<String> {
    private DataUtil mDataUtil = DataUtil.getInstance();

    public void setTitleToPresenter(){
        mDataUtil.loadTitle(this);
    }

    @Override
    public void onFinish(String data) {
        getView().updateTitle(data);
    }
}
