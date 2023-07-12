package com.alipay.sdk.m.c;

import android.content.Context;
import com.alipay.sdk.m.b.InterfaceC4143b;
import com.alipay.sdk.m.d.C4169a;
import com.alipay.sdk.m.i0.C4206b;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.c.d */
/* loaded from: classes10.dex */
public class C4157d implements InterfaceC4143b {
    @Override // com.alipay.sdk.m.b.InterfaceC4143b
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        boolean a = C4206b.a();
        C4169a.b("getOAID", "isSupported", Boolean.valueOf(a));
        if (a) {
            return C4206b.b(context);
        }
        return null;
    }
}
