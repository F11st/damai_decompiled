package com.alipay.sdk.m.c;

import android.content.Context;
import com.alipay.sdk.m.b.InterfaceC4143b;
import com.alipay.sdk.m.d.C4169a;
import com.alipay.sdk.m.h0.C4203a;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.c.f */
/* loaded from: classes10.dex */
public class C4159f implements InterfaceC4143b {
    public boolean a = false;

    @Override // com.alipay.sdk.m.b.InterfaceC4143b
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        if (!this.a) {
            C4203a.e(context);
            this.a = true;
        }
        boolean a = C4203a.a();
        C4169a.b("getOAID", "isSupported", Boolean.valueOf(a));
        if (a) {
            return C4203a.b(context);
        }
        return null;
    }
}
