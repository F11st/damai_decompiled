package com.alibaba.security.realidentity.http;

import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public interface IHttpCallback {
    void onFailure(Exception exc);

    void onResponse(RpHttpResponse rpHttpResponse) throws IOException;
}
