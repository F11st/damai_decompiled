package com.taobao.android.sns4android.handler;

import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.rpc.login.model.LoginReturnData;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface LoginFailHandler {
    boolean loginFailHandler(RpcResponse<LoginReturnData> rpcResponse);
}
