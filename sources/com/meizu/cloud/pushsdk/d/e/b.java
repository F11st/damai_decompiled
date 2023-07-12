package com.meizu.cloud.pushsdk.d.e;

import android.content.Context;
import com.meizu.cloud.pushsdk.d.f.e;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class b {
    private static final String a = "b";
    private String b;
    private String c;
    private String d;
    private int e;
    private final String f = "SQLITE";
    private final AtomicBoolean g = new AtomicBoolean(false);
    private long h;
    private final long i;
    private final long j;
    private final Context k;

    public b(long j, long j2, TimeUnit timeUnit, Context context) {
        this.c = null;
        this.e = 0;
        this.i = timeUnit.toMillis(j);
        this.j = timeUnit.toMillis(j2);
        this.k = context;
        Map f = f();
        if (f != null) {
            try {
                String obj = f.get("userId").toString();
                String obj2 = f.get("sessionId").toString();
                int intValue = ((Integer) f.get("sessionIndex")).intValue();
                this.b = obj;
                this.e = intValue;
                this.c = obj2;
            } catch (Exception e) {
                com.meizu.cloud.pushsdk.d.f.c.a(a, "Exception occurred retrieving session info from file: %s", e.getMessage());
            }
            d();
            g();
            com.meizu.cloud.pushsdk.d.f.c.c(a, "Tracker Session Object created.", new Object[0]);
        }
        this.b = e.b();
        d();
        g();
        com.meizu.cloud.pushsdk.d.f.c.c(a, "Tracker Session Object created.", new Object[0]);
    }

    private void d() {
        this.d = this.c;
        this.c = e.b();
        this.e++;
        String str = a;
        com.meizu.cloud.pushsdk.d.f.c.b(str, "Session information is updated:", new Object[0]);
        com.meizu.cloud.pushsdk.d.f.c.b(str, " + Session ID: %s", this.c);
        com.meizu.cloud.pushsdk.d.f.c.b(str, " + Previous Session ID: %s", this.d);
        com.meizu.cloud.pushsdk.d.f.c.b(str, " + Session Index: %s", Integer.valueOf(this.e));
        e();
    }

    private boolean e() {
        return com.meizu.cloud.pushsdk.d.f.a.a("snowplow_session_vars", c(), this.k);
    }

    private Map f() {
        return com.meizu.cloud.pushsdk.d.f.a.a("snowplow_session_vars", this.k);
    }

    private void g() {
        this.h = System.currentTimeMillis();
    }

    public com.meizu.cloud.pushsdk.d.a.b a() {
        com.meizu.cloud.pushsdk.d.f.c.c(a, "Getting session context...", new Object[0]);
        g();
        return new com.meizu.cloud.pushsdk.d.a.b("client_session", c());
    }

    public void b() {
        com.meizu.cloud.pushsdk.d.f.c.b(a, "Checking and updating session information.", new Object[0]);
        if (e.a(this.h, System.currentTimeMillis(), this.g.get() ? this.j : this.i)) {
            return;
        }
        d();
        g();
    }

    public Map c() {
        HashMap hashMap = new HashMap(8);
        hashMap.put("userId", this.b);
        hashMap.put("sessionId", this.c);
        hashMap.put("previousSessionId", this.d);
        hashMap.put("sessionIndex", Integer.valueOf(this.e));
        hashMap.put("storageMechanism", "SQLITE");
        return hashMap;
    }
}
