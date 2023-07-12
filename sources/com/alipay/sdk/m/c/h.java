package com.alipay.sdk.m.c;

import android.content.Context;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class h implements com.alipay.sdk.m.b.b {
    @Override // com.alipay.sdk.m.b.b
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        boolean c = com.alipay.sdk.m.p0.e.c(context);
        com.alipay.sdk.m.d.a.b("getOAID", "isSupported", Boolean.valueOf(c));
        if (c) {
            return com.alipay.sdk.m.p0.e.a(context);
        }
        return null;
    }
}
