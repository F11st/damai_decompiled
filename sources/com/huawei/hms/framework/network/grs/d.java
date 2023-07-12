package com.huawei.hms.framework.network.grs;

import android.content.Context;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class d {
    private static final Map<String, c> a = new ConcurrentHashMap(16);
    private static final Object b = new Object();

    public static c a(GrsBaseInfo grsBaseInfo, Context context) {
        synchronized (b) {
            int uniqueCode = grsBaseInfo.uniqueCode();
            Map<String, c> map = a;
            c cVar = map.get(context.getPackageName() + uniqueCode);
            if (cVar == null) {
                c cVar2 = new c(context, grsBaseInfo);
                map.put(context.getPackageName() + uniqueCode, cVar2);
                return cVar2;
            } else if (cVar.a((Object) new c(grsBaseInfo))) {
                return cVar;
            } else {
                c cVar3 = new c(context, grsBaseInfo);
                map.put(context.getPackageName() + uniqueCode, cVar3);
                return cVar3;
            }
        }
    }
}
