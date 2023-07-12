package com.huawei.hms.framework.network.grs;

import android.content.Context;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* renamed from: com.huawei.hms.framework.network.grs.d */
/* loaded from: classes10.dex */
public class C5563d {
    private static final Map<String, C5561c> a = new ConcurrentHashMap(16);
    private static final Object b = new Object();

    public static C5561c a(GrsBaseInfo grsBaseInfo, Context context) {
        synchronized (b) {
            int uniqueCode = grsBaseInfo.uniqueCode();
            Map<String, C5561c> map = a;
            C5561c c5561c = map.get(context.getPackageName() + uniqueCode);
            if (c5561c == null) {
                C5561c c5561c2 = new C5561c(context, grsBaseInfo);
                map.put(context.getPackageName() + uniqueCode, c5561c2);
                return c5561c2;
            } else if (c5561c.a((Object) new C5561c(grsBaseInfo))) {
                return c5561c;
            } else {
                C5561c c5561c3 = new C5561c(context, grsBaseInfo);
                map.put(context.getPackageName() + uniqueCode, c5561c3);
                return c5561c3;
            }
        }
    }
}
