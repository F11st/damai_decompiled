package com.huawei.hms.framework.network.grs.e;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.g.d;
import com.huawei.hms.framework.network.grs.g.h;
import com.huawei.hms.framework.network.grs.h.e;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class a {
    private static final String f = "a";
    private final Map<String, Map<String, Map<String, String>>> a = new ConcurrentHashMap(16);
    private final Map<String, Long> b = new ConcurrentHashMap(16);
    private final c c;
    private final c d;
    private final h e;

    public a(c cVar, c cVar2, h hVar) {
        this.d = cVar2;
        this.c = cVar;
        this.e = hVar;
        hVar.a(this);
    }

    private void a(GrsBaseInfo grsBaseInfo, b bVar, Context context, String str) {
        Long l = this.b.get(grsBaseInfo.getGrsParasKey(true, true, context));
        if (e.a(l)) {
            bVar.a(2);
            return;
        }
        if (e.a(l, 300000L)) {
            this.e.a(new com.huawei.hms.framework.network.grs.g.k.c(grsBaseInfo, context), null, str, this.d);
        }
        bVar.a(1);
    }

    private void a(GrsBaseInfo grsBaseInfo, String str, Context context) {
        if (e.a(this.b.get(str), 300000L)) {
            this.e.a(new com.huawei.hms.framework.network.grs.g.k.c(grsBaseInfo, context), null, null, this.d);
        }
    }

    public c a() {
        return this.c;
    }

    public Map<String, String> a(GrsBaseInfo grsBaseInfo, String str, b bVar, Context context) {
        Map<String, Map<String, String>> map = this.a.get(grsBaseInfo.getGrsParasKey(true, true, context));
        if (map == null || map.isEmpty()) {
            return new HashMap();
        }
        a(grsBaseInfo, bVar, context, str);
        return map.get(str);
    }

    public void a(GrsBaseInfo grsBaseInfo, Context context) {
        String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
        c cVar = this.c;
        cVar.b(grsParasKey + "time", "0");
        Map<String, Long> map = this.b;
        map.remove(grsParasKey + "time");
        this.a.remove(grsParasKey);
        this.e.a(grsParasKey);
    }

    public void a(GrsBaseInfo grsBaseInfo, d dVar, Context context, com.huawei.hms.framework.network.grs.g.k.c cVar) {
        if (dVar.f() == 2) {
            Logger.w(f, "update cache from server failed");
        } else if (cVar.d().size() != 0) {
            this.c.b("geoipCountryCode", dVar.j());
            this.c.b("geoipCountryCodetime", dVar.a());
        } else {
            String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
            if (dVar.m()) {
                this.a.put(grsParasKey, com.huawei.hms.framework.network.grs.a.a(this.c.a(grsParasKey, "")));
            } else {
                this.c.b(grsParasKey, dVar.j());
                this.a.put(grsParasKey, com.huawei.hms.framework.network.grs.a.a(dVar.j()));
            }
            if (!TextUtils.isEmpty(dVar.e())) {
                c cVar2 = this.c;
                cVar2.b(grsParasKey + "ETag", dVar.e());
            }
            c cVar3 = this.c;
            cVar3.b(grsParasKey + "time", dVar.a());
            this.b.put(grsParasKey, Long.valueOf(Long.parseLong(dVar.a())));
        }
    }

    public h b() {
        return this.e;
    }

    public void b(GrsBaseInfo grsBaseInfo, Context context) {
        String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
        String a = this.c.a(grsParasKey, "");
        c cVar = this.c;
        String a2 = cVar.a(grsParasKey + "time", "0");
        long j = 0;
        if (!TextUtils.isEmpty(a2) && a2.matches("\\d+")) {
            try {
                j = Long.parseLong(a2);
            } catch (NumberFormatException e) {
                Logger.w(f, "convert urlParamKey from String to Long catch NumberFormatException.", e);
            }
        }
        this.a.put(grsParasKey, com.huawei.hms.framework.network.grs.a.a(a));
        this.b.put(grsParasKey, Long.valueOf(j));
        a(grsBaseInfo, grsParasKey, context);
    }

    public c c() {
        return this.d;
    }
}
