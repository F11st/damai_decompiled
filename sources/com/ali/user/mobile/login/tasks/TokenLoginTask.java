package com.ali.user.mobile.login.tasks;

import android.text.TextUtils;
import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.login.LoginDataRepository;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.LoginType;
import com.ali.user.mobile.rpc.login.model.LoginReturnData;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class TokenLoginTask extends BaseLoginTask {
    @Override // com.ali.user.mobile.login.tasks.BaseLoginTask
    protected String getLoginType() {
        LoginParam loginParam = this.loginParam;
        if (loginParam != null && !TextUtils.isEmpty(loginParam.nativeLoginType)) {
            return this.loginParam.nativeLoginType;
        }
        return LoginType.ServerLoginType.TokenLogin.getType();
    }

    @Override // com.ali.user.mobile.login.tasks.BaseLoginTask
    protected void invokeLoginRpc(LoginParam loginParam, RpcRequestCallback<LoginReturnData> rpcRequestCallback) {
        LoginDataRepository.getInstance().loginByToken(loginParam, rpcRequestCallback);
    }
}
