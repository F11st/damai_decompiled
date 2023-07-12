package com.alipay.sdk.m.c;

import android.content.Context;
import com.alipay.sdk.m.b.InterfaceC4143b;
import com.alipay.sdk.m.d.C4169a;
import com.alipay.sdk.m.r0.C4290b;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.c.c */
/* loaded from: classes10.dex */
public class C4156c implements InterfaceC4143b {
    public static final int d = 1;
    public C4290b a;
    public boolean b = false;
    public boolean c = false;

    @Override // com.alipay.sdk.m.b.InterfaceC4143b
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        if (!this.b) {
            C4290b c4290b = new C4290b();
            this.a = c4290b;
            this.c = c4290b.a(context, (C4290b.InterfaceC4292b<String>) null) == 1;
            this.b = true;
        }
        C4169a.b("getOAID", "isSupported", Boolean.valueOf(this.c));
        if (this.c && this.a.e()) {
            return this.a.b();
        }
        return null;
    }
}
