package com.amap.api.mapcore.util;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class hm {
    private gm a;
    private volatile int b = -1;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class a {
        public static Map<String, hm> a = new HashMap();
    }

    private hm(gm gmVar) {
        this.a = gmVar;
    }

    public static hm a(gm gmVar) {
        if (a.a.get(gmVar.a()) == null) {
            a.a.put(gmVar.a(), new hm(gmVar));
        }
        return a.a.get(gmVar.a());
    }

    public boolean b(Context context) {
        try {
            return Boolean.parseBoolean(hq.a(context, this.a, "scisf"));
        } catch (Throwable unused) {
            return true;
        }
    }

    public void a(Context context, boolean z, boolean z2) {
        gm gmVar = this.a;
        StringBuilder sb = new StringBuilder();
        sb.append(z);
        hq.a(context, gmVar, "sckey", sb.toString());
        if (z) {
            gm gmVar2 = this.a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(z2);
            hq.a(context, gmVar2, "scisf", sb2.toString());
        }
    }

    public boolean a(Context context) {
        try {
            return Boolean.parseBoolean(hq.a(context, this.a, "sckey"));
        } catch (Throwable unused) {
            return false;
        }
    }
}
