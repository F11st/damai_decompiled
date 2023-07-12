package com.ali.user.mobile.register.ui;

import com.ali.user.mobile.base.BaseView;
import com.ali.user.mobile.data.model.SmsApplyResult;
import com.ali.user.mobile.rpc.RpcResponse;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public interface RegisterFormView extends BaseView {
    String getPageName();

    String getRegType();

    void onH5(String str);

    void onNumAuthRegisterFail(RpcResponse rpcResponse);

    void onRegisterFail(int i, String str);

    void onRegisterSuccess(String str);

    void onSMSSendFail(RpcResponse rpcResponse);

    void onSendSMSSuccess(long j, SmsApplyResult smsApplyResult);
}
