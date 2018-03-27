package com.jlenx.core.android.ui;

import android.content.Context;

import com.jlenx.core.android.ui.rx.RxManager;
import com.jlenx.core.android.ui.interf.IBasePresenter;
import com.jlenx.core.android.ui.interf.IBaseView;


public abstract class BasePresenter<T extends IBaseView> implements IBasePresenter {
    private Context mContext;
    private T mView;
    private RxManager mRxManage = new RxManager();


    public BasePresenter(Context context, T view) {
        this.mContext = context;
        this.mView = view;
        this.onStart();
    }


    public Context getContext() {
        return mContext;
    }


    public T getView() {
        return mView;
    }

    public RxManager getRxManage() {
        return mRxManage;
    }

    public void onStart() {
    }

    public void onDestroy() {
        mRxManage.clear();
    }
}
