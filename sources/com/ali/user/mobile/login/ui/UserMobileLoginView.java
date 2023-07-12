package com.ali.user.mobile.login.ui;

import com.ali.user.mobile.rpc.RpcResponse;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public interface UserMobileLoginView extends BaseLoginView {
    String getCountryCode();

    String getPhoneCode();

    void onCheckCodeError();

    void onSMSOverLimit(RpcResponse rpcResponse);

    void onSMSSendFail(RpcResponse rpcResponse);

    void onSendSMSSuccess(long j, boolean z);
}
