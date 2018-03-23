package com.jlenx.core.android.ui;
import android.content.Context;

import com.jlenx.core.android.rx.RxManager;


public abstract class BasePresenter<T> {
    private Context mContext;
    private T mView;
    private RxManager mRxManage = new RxManager();


    public void inject(Context context, T view) {
        mContext = context;
        mView = view;
        onStart();
    }

    public void inject(T view) {
        mView = view;
        onStart();
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
