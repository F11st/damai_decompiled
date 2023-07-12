package com.ali.user.open.core.service;

import com.ali.user.open.core.model.RpcRequest;
import com.ali.user.open.core.model.RpcRequestCallbackWithCode;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public interface RpcService {
    String getDeviceId();

    void logout(String str);

    void registerSessionInfo(String str, String str2, String str3);

    <T> void remoteBusiness(RpcRequest rpcRequest, Class<T> cls, RpcRequestCallbackWithCode rpcRequestCallbackWithCode);
}
