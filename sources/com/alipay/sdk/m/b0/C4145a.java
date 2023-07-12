package com.alipay.sdk.m.b0;

import android.content.Context;
import com.alipay.sdk.m.y.C4367c;
import com.alipay.sdk.m.z.C4368a;
import java.util.HashMap;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.b0.a */
/* loaded from: classes12.dex */
public class C4145a {
    public static String a(Context context, String str, String str2) {
        String a;
        synchronized (C4145a.class) {
            String str3 = null;
            if (context != null) {
                try {
                    if (!C4368a.a(str) && !C4368a.a(str2)) {
                        try {
                            a = C4149e.a(context, str, str2, "");
                        } catch (Throwable unused) {
                        }
                        if (C4368a.a(a)) {
                            return null;
                        }
                        str3 = C4367c.b(C4367c.a(), a);
                        return str3;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return null;
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        synchronized (C4145a.class) {
            if (C4368a.a(str) || C4368a.a(str2) || context == null) {
                return;
            }
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
