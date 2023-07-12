package com.alibaba.security.realidentity.http;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class RpHttpResponse implements Serializable {
    private final String responseBody;
    private final boolean successful;

    RpHttpResponse(boolean z, String str) {
        this.successful = z;
        this.responseBody = str;
    }

    public static RpHttpResponse create(boolean z, String str) {
        return new RpHttpResponse(z, str);
    }

    public String getResponseBody() {
        return this.responseBody;
    }

    public boolean isSuccessful() {
        return this.successful;
    }
}
