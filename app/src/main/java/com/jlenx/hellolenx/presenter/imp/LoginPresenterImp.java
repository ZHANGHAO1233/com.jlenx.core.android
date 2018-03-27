package com.jlenx.hellolenx.presenter.imp;

import android.content.Context;

import com.jlenx.core.android.ui.BasePresenter;
import com.jlenx.hellolenx.presenter.LoginPresenter;
import com.jlenx.hellolenx.view.LoginView;

/**
 * Created by admin on 2018/3/26.
 */

public class LoginPresenterImp extends BasePresenter<LoginView> implements LoginPresenter {


    public LoginPresenterImp(Context context, LoginView mView) {
        super(context, mView);
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void login(String s, String s1) {

    }
}
