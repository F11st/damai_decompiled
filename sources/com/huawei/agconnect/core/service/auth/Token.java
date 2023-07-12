package com.huawei.agconnect.core.service.auth;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface Token {
    long getExpiration();

    long getIssuedAt();

    long getNotBefore();

    String getTokenString();
}
