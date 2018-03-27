package com.jlenx.hellolenx.presenter.imp;

import android.content.Context;

import com.jlenx.core.android.ui.BasePresenter;
import com.jlenx.hellolenx.presenter.ContentPresenter;
import com.jlenx.hellolenx.view.ContentView;

public class ContentPresenterImp extends BasePresenter<ContentView> implements ContentPresenter {

    public ContentPresenterImp(Context context, ContentView mView) {
        super(context, mView);
    }
}
