package com.alipay.auth.mobile.api;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface IAlipayAuthEventHandler {
    void alipayAuthDidCancel();

    void alipayAuthFailure();

    void alipayAuthSuccess(String str);
}
