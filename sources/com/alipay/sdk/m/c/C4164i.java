package com.alipay.sdk.m.c;

import android.content.Context;
import com.alipay.sdk.m.b.InterfaceC4143b;
import com.alipay.sdk.m.d.C4169a;
import com.alipay.sdk.m.j0.C4217b;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.c.i */
/* loaded from: classes10.dex */
public class C4164i implements InterfaceC4143b {
    @Override // com.alipay.sdk.m.b.InterfaceC4143b
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        boolean a = C4217b.a();
        C4169a.b("getOAID", "isSupported", Boolean.valueOf(a));
        if (a) {
            return C4217b.b(context);
        }
        return null;
    }
}
