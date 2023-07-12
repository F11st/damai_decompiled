package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.e.h;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public final class b {
    public static synchronized Map<String, String> a(Context context, Map<String, String> map) {
        HashMap hashMap;
        synchronized (b.class) {
            hashMap = new HashMap();
            String a = com.alipay.sdk.m.z.a.a(map, "tid", "");
            String a2 = com.alipay.sdk.m.z.a.a(map, "utdid", "");
            String a3 = com.alipay.sdk.m.z.a.a(map, "userId", "");
            String a4 = com.alipay.sdk.m.z.a.a(map, "appName", "");
            String a5 = com.alipay.sdk.m.z.a.a(map, "appKeyClient", "");
            String a6 = com.alipay.sdk.m.z.a.a(map, "tmxSessionId", "");
            String f = h.f(context);
            String a7 = com.alipay.sdk.m.z.a.a(map, "sessionId", "");
            hashMap.put("AC1", a);
            hashMap.put("AC2", a2);
            hashMap.put("AC3", "");
            hashMap.put("AC4", f);
            hashMap.put("AC5", a3);
            hashMap.put("AC6", a6);
            hashMap.put("AC7", "");
            hashMap.put("AC8", a4);
            hashMap.put("AC9", a5);
            if (com.alipay.sdk.m.z.a.b(a7)) {
                hashMap.put("AC10", a7);
            }
        }
        return hashMap;
    }
}
