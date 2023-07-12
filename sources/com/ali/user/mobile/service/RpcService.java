package com.ali.user.mobile.service;

import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.callback.RpcRequestCallbackWithCode;
import com.ali.user.mobile.rpc.RpcRequest;
import com.ali.user.mobile.rpc.RpcResponse;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public interface RpcService {
    String getDeviceId();

    void logout();

    <T extends RpcResponse<?>> T post(RpcRequest rpcRequest, Class<T> cls);

    <T extends RpcResponse<?>> T post(RpcRequest rpcRequest, Class<T> cls, String str);

    void registerSessionInfo(String str, String str2, String str3);

    <T extends RpcResponse<?>> void remoteBusiness(RpcRequest rpcRequest, Class<T> cls, RpcRequestCallback rpcRequestCallback);

    <T extends RpcResponse<?>> void remoteBusiness(RpcRequest rpcRequest, Class<T> cls, RpcRequestCallbackWithCode rpcRequestCallbackWithCode);

    <T extends RpcResponse<?>> void remoteBusiness(RpcRequest rpcRequest, Class<T> cls, String str, RpcRequestCallback rpcRequestCallback);

    void setHeader(String str, String str2);
}
