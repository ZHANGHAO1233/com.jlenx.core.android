package com.jlenx.hellolenx.view.imp;

import com.jlenx.core.android.ui.BaseActivity;
import com.jlenx.hellolenx.R;
import com.jlenx.hellolenx.presenter.ContentPresenter;
import com.jlenx.hellolenx.presenter.imp.ContentPresenterImp;
import com.jlenx.hellolenx.view.ContentView;

public class ContentActivity extends BaseActivity<ContentPresenter> implements ContentView{

    @Override
    public int getLayoutId() {
        return R.layout.main_activity_content;
    }

    @Override
    protected ContentPresenter initPresenter() {
        return new ContentPresenterImp(this,this);
    }

    @Override
    protected void initView() {

    }
}
