package com.jlenx.core.android.ui.rx;

import android.app.Activity;
import android.content.Context;

import com.jlenx.core.androi.dui.R;
import com.jlenx.core.android.rx.ServerException;
import com.jlenx.core.android.ui.BaseApplication;
import com.jlenx.core.android.ui.widget.LoadingDialog;
import com.jlenx.core.android.utils.NetWorkUtils;

import java.net.SocketTimeoutException;

import rx.Subscriber;

/**
 * des:订阅封装
 */


public abstract class ViewSubscriber<T> extends Subscriber<T> {

    private Context mContext;
    private String msg;
    private boolean showDialog = true;

    /**
     * 是否显示浮动dialog
     */
    public void showDialog() {
        this.showDialog = true;
    }

    public void hideDialog() {
        this.showDialog = false;
    }

    public ViewSubscriber(Context context, String msg, boolean showDialog) {
        this.mContext = context;
        this.msg = msg;
        this.showDialog = showDialog;
    }

    public ViewSubscriber(Context context) {
        this(context, BaseApplication.getAppContext().getString(R.string.loading), false);
    }

    public ViewSubscriber(Context context, boolean showDialog) {
        this(context, BaseApplication.getAppContext().getString(R.string.loading), showDialog);
    }

    @Override
    public void onCompleted() {
        if (showDialog)
            LoadingDialog.cancelDialogForLoading();
    }

    @Override
    public void onStart() {
        super.onStart();
        if (showDialog) {
            try {
                LoadingDialog.showDialogForLoading((Activity) mContext, msg, true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void onNext(T t) {
        if (showDialog)
            LoadingDialog.cancelDialogForLoading();
        _onNext(t);
    }

    @Override
    public void onError(Throwable e) {
        if (showDialog)
            LoadingDialog.cancelDialogForLoading();
        e.printStackTrace();
        //网络
        if (!NetWorkUtils.isNetConnected(BaseApplication.getAppContext())) {
            _onError(BaseApplication.getAppContext().getString(R.string.no_net));
        }
        //服务器
        else if (e instanceof ServerException) {
            _onError(e.getMessage());
        } else if (e instanceof SocketTimeoutException) {
            _onError("系统访问超时");
        }
        //其它
        else {
            _onError(BaseApplication.getAppContext().getString(R.string.net_error));
        }
    }

    protected abstract void _onNext(T t);

    protected abstract void _onError(String message);

}
