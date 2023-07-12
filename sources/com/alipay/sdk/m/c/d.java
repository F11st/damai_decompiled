package com.alipay.sdk.m.c;

import android.content.Context;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class d implements com.alipay.sdk.m.b.b {
    @Override // com.alipay.sdk.m.b.b
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        boolean a = com.alipay.sdk.m.i0.b.a();
        com.alipay.sdk.m.d.a.b("getOAID", "isSupported", Boolean.valueOf(a));
        if (a) {
            return com.alipay.sdk.m.i0.b.b(context);
        }
        return null;
    }
}
