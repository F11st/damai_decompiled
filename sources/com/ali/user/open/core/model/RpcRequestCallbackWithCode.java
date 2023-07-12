package com.ali.user.open.core.model;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public interface RpcRequestCallbackWithCode {
    void onError(String str, RpcResponse rpcResponse);

    void onSuccess(RpcResponse rpcResponse);

    void onSystemError(String str, RpcResponse rpcResponse);
}
