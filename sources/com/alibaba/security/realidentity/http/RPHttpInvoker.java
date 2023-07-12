package com.alibaba.security.realidentity.http;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class RPHttpInvoker extends AbsHttpInvoker {
    @Override // com.alibaba.security.realidentity.http.AbsHttpInvoker
    public AbsRPCInvoker getRPCInvoker() {
        return new RpcInvoker();
    }
}
