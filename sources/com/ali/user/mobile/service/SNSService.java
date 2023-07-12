package com.ali.user.mobile.service;

import android.app.Activity;
import com.ali.user.mobile.model.SNSSignInAccount;
import com.ali.user.mobile.model.UrlParam;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.rpc.login.model.LoginReturnData;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public interface SNSService {
    void dismissLoading(Activity activity);

    void onError(Activity activity, RpcResponse<LoginReturnData> rpcResponse);

    void onFastRegOrLoginBind(Activity activity, String str, String str2, String str3);

    void onH5(Activity activity, RpcResponse<LoginReturnData> rpcResponse, UrlParam urlParam);

    void onLoginBind(Activity activity, String str, String str2, String str3, String str4);

    void onLoginSuccess(Activity activity, SNSSignInAccount sNSSignInAccount, RpcResponse<LoginReturnData> rpcResponse);

    void onRebind(Activity activity, String str, String str2, String str3);

    void onRegBind(Activity activity, String str);

    void onSMSLogin(Activity activity, SNSSignInAccount sNSSignInAccount);

    void onTokenLogin(Activity activity, String str, String str2);

    void showLoading(Activity activity);

    void toast(Activity activity, String str);
}
