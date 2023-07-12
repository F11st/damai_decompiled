package com.alipay.sdk.m.g0;

import android.content.Context;
import com.alipay.sdk.m.d0.C4173d;
import com.alipay.sdk.m.d0.InterfaceC4170a;
import com.alipay.sdk.m.f0.C4189b;
import com.alipay.sdk.m.f0.C4190c;
import com.alipay.sdk.m.f0.C4191d;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.g0.b */
/* loaded from: classes10.dex */
public class C4196b implements InterfaceC4195a {
    public static InterfaceC4195a a;
    public static InterfaceC4170a b;

    public static InterfaceC4195a a(Context context, String str) {
        if (context == null) {
            return null;
        }
        if (a == null) {
            b = C4173d.a(context, str);
            a = new C4196b();
        }
        return a;
    }

    @Override // com.alipay.sdk.m.g0.InterfaceC4195a
    public C4190c a(C4191d c4191d) {
        return C4189b.a(b.a(C4189b.a(c4191d)));
    }

    @Override // com.alipay.sdk.m.g0.InterfaceC4195a
    public boolean logCollect(String str) {
        return b.logCollect(str);
    }
}
