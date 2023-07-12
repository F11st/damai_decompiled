package com.huawei.agconnect.core.service.auth;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface TokenSnapshot {

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public enum State {
        SIGNED_IN,
        TOKEN_UPDATED,
        TOKEN_INVALID,
        SIGNED_OUT
    }

    State getState();

    String getToken();
}
