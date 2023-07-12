package com.alibaba.security.realidentity.http.model;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public abstract class HttpResponse implements Serializable {
    public String Code;
    public int errorCode;

    public abstract boolean isSuccessful();
}
