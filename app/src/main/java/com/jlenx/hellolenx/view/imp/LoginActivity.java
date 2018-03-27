package com.jlenx.hellolenx.view.imp;

import android.widget.Button;
import android.widget.EditText;

import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.widget.RxTextView;
import com.jlenx.core.android.ui.BaseActivity;
import com.jlenx.hellolenx.R;
import com.jlenx.hellolenx.presenter.LoginPresenter;
import com.jlenx.hellolenx.presenter.imp.LoginPresenterImp;
import com.jlenx.hellolenx.view.LoginView;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func2;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginView {


    @BindView(R.id.tv_account)
    EditText tvAccount;
    @BindView(R.id.tv_password)
    EditText tvPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;

    @Override
    public int getLayoutId() {
        return R.layout.login_activity_login;
    }

    @Override
    protected LoginPresenter initPresenter() {
        return new LoginPresenterImp(this, this);
    }

    @Override
    public void initView() {
        Observable<CharSequence> observableName = RxTextView.textChanges(this.tvAccount);
        Observable<CharSequence> observablePassword = RxTextView.textChanges(this.tvPassword);
        Observable.combineLatest(observableName, observablePassword, new Func2<CharSequence,
                CharSequence, Boolean>() {
            @Override
            public Boolean call(CharSequence phone, CharSequence password) {
                return isPhoneValid(phone.toString()) && isPasswordValid(password.toString());
            }
        }).subscribe(new Action1<Boolean>() {
            @Override
            public void call(Boolean aBoolean) {
                RxView.enabled(btnLogin).call(aBoolean);
            }
        });
    }

    private boolean isPhoneValid(String phone) {
        return phone.length() == 11;
    }

    private boolean isPasswordValid(String password) {
        return password.length() >= 6;
    }

    @OnClick(R.id.btn_login)
    public void login() {

    }




}
