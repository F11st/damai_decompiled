package com.alipay.sdk.m.b0;

import android.content.Context;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public final class d {
    public static synchronized void a(Context context, String str, String str2, String str3) {
        synchronized (d.class) {
            if (!com.alipay.sdk.m.z.a.a(str)) {
                if (!com.alipay.sdk.m.z.a.a(str2) && context != null) {
                    try {
                        String a = com.alipay.sdk.m.y.c.a(com.alipay.sdk.m.y.c.a(), str3);
                        HashMap hashMap = new HashMap();
                        hashMap.put(str2, a);
                        e.a(context, str, hashMap);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }
}
