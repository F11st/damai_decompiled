package com.ali.user.mobile.callback;

import com.ali.user.mobile.rpc.RpcResponse;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public interface RpcRequestCallback<T> {
    void onError(RpcResponse<T> rpcResponse);

    void onSuccess(RpcResponse<T> rpcResponse);

    void onSystemError(RpcResponse<T> rpcResponse);
}
