package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.c.C4098b;
import com.alipay.sdk.m.a0.C4139b;
import com.alipay.sdk.m.a0.C4141d;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.alipay.apmobilesecuritysdk.d.d */
/* loaded from: classes12.dex */
public final class C4103d {
    public static synchronized Map<String, String> a() {
        HashMap hashMap;
        synchronized (C4103d.class) {
            hashMap = new HashMap();
            try {
                new C4098b();
                hashMap.put("AE16", "");
            } catch (Throwable unused) {
            }
        }
        return hashMap;
    }

    public static synchronized Map<String, String> a(Context context) {
        HashMap hashMap;
        synchronized (C4103d.class) {
            C4141d.a();
            C4139b.b();
            hashMap = new HashMap();
            hashMap.put("AE1", C4141d.b());
            StringBuilder sb = new StringBuilder();
            sb.append(C4141d.c() ? "1" : "0");
            hashMap.put("AE2", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(C4141d.a(context) ? "1" : "0");
            hashMap.put("AE3", sb2.toString());
            hashMap.put("AE4", C4141d.d());
            hashMap.put("AE5", C4141d.e());
            hashMap.put("AE6", C4141d.f());
            hashMap.put("AE7", C4141d.g());
            hashMap.put("AE8", C4141d.h());
            hashMap.put("AE9", C4141d.i());
            hashMap.put("AE10", C4141d.j());
            hashMap.put("AE11", C4141d.k());
            hashMap.put("AE12", C4141d.l());
            hashMap.put("AE13", C4141d.m());
            hashMap.put("AE14", C4141d.n());
            hashMap.put("AE15", C4141d.o());
            hashMap.put("AE21", C4139b.g());
        }
        return hashMap;
    }
}
