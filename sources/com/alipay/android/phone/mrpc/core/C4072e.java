package com.alipay.android.phone.mrpc.core;

import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultRedirectHandler;
import org.apache.http.protocol.HttpContext;

/* compiled from: Taobao */
/* renamed from: com.alipay.android.phone.mrpc.core.e */
/* loaded from: classes12.dex */
public final class C4072e extends DefaultRedirectHandler {
    public int a;
    public final /* synthetic */ C4071d b;

    public C4072e(C4071d c4071d) {
        this.b = c4071d;
    }

    public final boolean isRedirectRequested(HttpResponse httpResponse, HttpContext httpContext) {
        int statusCode;
        this.a++;
        boolean isRedirectRequested = super.isRedirectRequested(httpResponse, httpContext);
        if (isRedirectRequested || this.a >= 5 || !((statusCode = httpResponse.getStatusLine().getStatusCode()) == 301 || statusCode == 302)) {
            return isRedirectRequested;
        }
        return true;
    }
}
