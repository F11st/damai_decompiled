package com.alipay.sdk.m.b0;

import android.content.Context;
import com.alipay.sdk.m.y.C4367c;
import com.alipay.sdk.m.z.C4368a;
import java.util.HashMap;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.b0.d */
/* loaded from: classes12.dex */
public final class C4148d {
    public static synchronized void a(Context context, String str, String str2, String str3) {
        synchronized (C4148d.class) {
            if (!C4368a.a(str)) {
                if (!C4368a.a(str2) && context != null) {
                    try {
                        String a = C4367c.a(C4367c.a(), str3);
                        HashMap hashMap = new HashMap();
                        hashMap.put(str2, a);
                        C4149e.a(context, str, hashMap);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }
}
