package com.alipay.android.phone.mrpc.core;

import org.apache.http.HttpResponse;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.protocol.HttpContext;

/* compiled from: Taobao */
/* renamed from: com.alipay.android.phone.mrpc.core.f */
/* loaded from: classes12.dex */
public final class C4073f implements ConnectionKeepAliveStrategy {
    public final /* synthetic */ C4071d a;

    public C4073f(C4071d c4071d) {
        this.a = c4071d;
    }

    public final long getKeepAliveDuration(HttpResponse httpResponse, HttpContext httpContext) {
        return 180000L;
    }
}
