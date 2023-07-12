package com.alipay.sdk.m.c;

import android.content.Context;
import com.alipay.sdk.m.b.InterfaceC4143b;
import com.alipay.sdk.m.d.C4169a;
import com.alipay.sdk.m.p0.C4277e;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.c.h */
/* loaded from: classes10.dex */
public class C4163h implements InterfaceC4143b {
    @Override // com.alipay.sdk.m.b.InterfaceC4143b
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        boolean c = C4277e.c(context);
        C4169a.b("getOAID", "isSupported", Boolean.valueOf(c));
        if (c) {
            return C4277e.a(context);
        }
        return null;
    }
}
