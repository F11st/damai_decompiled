package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.e.C4112h;
import com.alipay.sdk.m.z.C4368a;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.alipay.apmobilesecuritysdk.d.b */
/* loaded from: classes12.dex */
public final class C4101b {
    public static synchronized Map<String, String> a(Context context, Map<String, String> map) {
        HashMap hashMap;
        synchronized (C4101b.class) {
            hashMap = new HashMap();
            String a = C4368a.a(map, "tid", "");
            String a2 = C4368a.a(map, "utdid", "");
            String a3 = C4368a.a(map, "userId", "");
            String a4 = C4368a.a(map, "appName", "");
            String a5 = C4368a.a(map, "appKeyClient", "");
            String a6 = C4368a.a(map, "tmxSessionId", "");
            String f = C4112h.f(context);
            String a7 = C4368a.a(map, "sessionId", "");
            hashMap.put("AC1", a);
            hashMap.put("AC2", a2);
            hashMap.put("AC3", "");
            hashMap.put("AC4", f);
            hashMap.put("AC5", a3);
            hashMap.put("AC6", a6);
            hashMap.put("AC7", "");
            hashMap.put("AC8", a4);
            hashMap.put("AC9", a5);
            if (C4368a.b(a7)) {
                hashMap.put("AC10", a7);
            }
        }
        return hashMap;
    }
}
