package com.huawei.hms.framework.network.grs.e;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.C5557a;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.g.C5578d;
import com.huawei.hms.framework.network.grs.g.C5583h;
import com.huawei.hms.framework.network.grs.g.k.C5590c;
import com.huawei.hms.framework.network.grs.h.C5597e;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* renamed from: com.huawei.hms.framework.network.grs.e.a */
/* loaded from: classes10.dex */
public class C5564a {
    private static final String f = "a";
    private final Map<String, Map<String, Map<String, String>>> a = new ConcurrentHashMap(16);
    private final Map<String, Long> b = new ConcurrentHashMap(16);
    private final C5566c c;
    private final C5566c d;
    private final C5583h e;

    public C5564a(C5566c c5566c, C5566c c5566c2, C5583h c5583h) {
        this.d = c5566c2;
        this.c = c5566c;
        this.e = c5583h;
        c5583h.a(this);
    }

    private void a(GrsBaseInfo grsBaseInfo, C5565b c5565b, Context context, String str) {
        Long l = this.b.get(grsBaseInfo.getGrsParasKey(true, true, context));
        if (C5597e.a(l)) {
            c5565b.a(2);
            return;
        }
        if (C5597e.a(l, 300000L)) {
            this.e.a(new C5590c(grsBaseInfo, context), null, str, this.d);
        }
        c5565b.a(1);
    }

    private void a(GrsBaseInfo grsBaseInfo, String str, Context context) {
        if (C5597e.a(this.b.get(str), 300000L)) {
            this.e.a(new C5590c(grsBaseInfo, context), null, null, this.d);
        }
    }

    public C5566c a() {
        return this.c;
    }

    public Map<String, String> a(GrsBaseInfo grsBaseInfo, String str, C5565b c5565b, Context context) {
        Map<String, Map<String, String>> map = this.a.get(grsBaseInfo.getGrsParasKey(true, true, context));
        if (map == null || map.isEmpty()) {
            return new HashMap();
        }
        a(grsBaseInfo, c5565b, context, str);
        return map.get(str);
    }

    public void a(GrsBaseInfo grsBaseInfo, Context context) {
        String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
        C5566c c5566c = this.c;
        c5566c.b(grsParasKey + "time", "0");
        Map<String, Long> map = this.b;
        map.remove(grsParasKey + "time");
        this.a.remove(grsParasKey);
        this.e.a(grsParasKey);
    }

    public void a(GrsBaseInfo grsBaseInfo, C5578d c5578d, Context context, C5590c c5590c) {
        if (c5578d.f() == 2) {
            Logger.w(f, "update cache from server failed");
        } else if (c5590c.d().size() != 0) {
            this.c.b("geoipCountryCode", c5578d.j());
            this.c.b("geoipCountryCodetime", c5578d.a());
        } else {
            String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
            if (c5578d.m()) {
                this.a.put(grsParasKey, C5557a.a(this.c.a(grsParasKey, "")));
            } else {
                this.c.b(grsParasKey, c5578d.j());
                this.a.put(grsParasKey, C5557a.a(c5578d.j()));
            }
            if (!TextUtils.isEmpty(c5578d.e())) {
                C5566c c5566c = this.c;
                c5566c.b(grsParasKey + "ETag", c5578d.e());
            }
            C5566c c5566c2 = this.c;
            c5566c2.b(grsParasKey + "time", c5578d.a());
            this.b.put(grsParasKey, Long.valueOf(Long.parseLong(c5578d.a())));
        }
    }

    public C5583h b() {
        return this.e;
    }

    public void b(GrsBaseInfo grsBaseInfo, Context context) {
        String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
        String a = this.c.a(grsParasKey, "");
        C5566c c5566c = this.c;
        String a2 = c5566c.a(grsParasKey + "time", "0");
        long j = 0;
        if (!TextUtils.isEmpty(a2) && a2.matches("\\d+")) {
            try {
                j = Long.parseLong(a2);
            } catch (NumberFormatException e) {
                Logger.w(f, "convert urlParamKey from String to Long catch NumberFormatException.", e);
            }
        }
        this.a.put(grsParasKey, C5557a.a(a));
        this.b.put(grsParasKey, Long.valueOf(j));
        a(grsBaseInfo, grsParasKey, context);
    }

    public C5566c c() {
        return this.d;
    }
}
