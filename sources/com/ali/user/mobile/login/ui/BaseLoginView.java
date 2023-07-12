package com.ali.user.mobile.login.ui;

import android.app.Activity;
import android.content.DialogInterface;
import com.ali.user.mobile.base.BaseView;
import com.ali.user.mobile.data.model.Login2RegParam;
import com.ali.user.mobile.login.AccountType;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.rpc.HistoryAccount;
import com.ali.user.mobile.rpc.RpcResponse;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public interface BaseLoginView extends BaseView {
    void alert(String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, String str4, DialogInterface.OnClickListener onClickListener2);

    void alertList(String[] strArr, DialogInterface.OnClickListener onClickListener, boolean z);

    void dismissAlertDialog();

    Activity getBaseActivity();

    HistoryAccount getHistoryAccount();

    int getLoginSite();

    AccountType getLoginType();

    String getPageName();

    String getPageSpm();

    boolean isHistoryMode();

    boolean loginFailHandler(RpcResponse rpcResponse);

    void onError(RpcResponse rpcResponse);

    void onNeedReg(Login2RegParam login2RegParam);

    void onNotify(RpcResponse rpcResponse);

    void onPostSuccess(LoginParam loginParam, RpcResponse rpcResponse);

    void onSuccess(LoginParam loginParam, RpcResponse rpcResponse);

    void setLoginAccountInfo(String str);
}
