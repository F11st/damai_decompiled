package com.alipay.android.phone.mrpc.core;

import org.apache.http.HttpResponse;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.protocol.HttpContext;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public final class f implements ConnectionKeepAliveStrategy {
    public final /* synthetic */ d a;

    public f(d dVar) {
        this.a = dVar;
    }

    public final long getKeepAliveDuration(HttpResponse httpResponse, HttpContext httpContext) {
        return 180000L;
    }
}
