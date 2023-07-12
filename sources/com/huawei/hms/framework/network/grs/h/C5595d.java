package com.huawei.hms.framework.network.grs.h;

import android.os.SystemClock;
import com.huawei.hms.framework.common.Logger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* renamed from: com.huawei.hms.framework.network.grs.h.d */
/* loaded from: classes10.dex */
public class C5595d {
    private static final Map<String, C5596a> a = new ConcurrentHashMap(16);

    /* compiled from: Taobao */
    /* renamed from: com.huawei.hms.framework.network.grs.h.d$a */
    /* loaded from: classes10.dex */
    public static class C5596a {
        private final long a;
        private final long b;

        public C5596a(long j, long j2) {
            this.a = j;
            this.b = j2;
        }

        public boolean a() {
            return SystemClock.elapsedRealtime() - this.b <= this.a;
        }
    }

    public static C5596a a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("map size of get is before:");
        Map<String, C5596a> map = a;
        sb.append(map.size());
        Logger.v("RequestUtil", sb.toString());
        C5596a c5596a = map.get(str);
        Logger.v("RequestUtil", "map size of get is after:" + map.size());
        return c5596a;
    }

    public static void a(String str, C5596a c5596a) {
        StringBuilder sb = new StringBuilder();
        sb.append("map size of put is before:");
        Map<String, C5596a> map = a;
        sb.append(map.size());
        Logger.v("RequestUtil", sb.toString());
        map.put(str, c5596a);
        Logger.v("RequestUtil", "map size of put is after:" + map.size());
    }
}
