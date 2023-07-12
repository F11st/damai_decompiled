package com.alibaba.mobsec.privacydoublelist.e;

import com.alibaba.mobsec.privacydoublelist.c.C3426a;
import com.alibaba.wireless.security.aopsdk.Invocation;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.alibaba.mobsec.privacydoublelist.e.e */
/* loaded from: classes6.dex */
public class C3438e {
    public static C3438e d;
    public final Map<String, C3433a> a = new HashMap();
    public final Map<String, C3436d> b = new HashMap();
    public int c = 5;

    public static synchronized C3438e b() {
        C3438e c3438e;
        synchronized (C3438e.class) {
            if (d == null) {
                d = new C3438e();
            }
            c3438e = d;
        }
        return c3438e;
    }

    public void a(int i) {
    }

    public void a(Invocation invocation, boolean z) {
        C3433a c3433a = this.a.get(invocation.getProxyName());
        if (c3433a == null) {
            synchronized (this) {
                c3433a = this.a.get(invocation.getProxyName());
                if (c3433a == null) {
                    c3433a = new C3433a(invocation.getProxyName());
                    this.a.put(invocation.getProxyName(), c3433a);
                }
            }
        }
        c3433a.a(invocation, z);
    }

    public void a(Invocation invocation, long j, C3426a.C3428b c3428b, boolean z) {
        synchronized (this) {
            C3436d c3436d = this.b.get(invocation.getProxyName());
            if (c3436d == null) {
                c3436d = new C3436d(invocation, j, c3428b);
                this.b.put(invocation.getProxyName(), c3436d);
            }
            c3436d.a(invocation);
            c3436d.a(invocation, z);
        }
    }

    public C3435c a() {
        C3435c c3435c;
        synchronized (this) {
            c3435c = new C3435c(new HashMap(this.b), new HashMap(this.a));
            this.b.clear();
            this.a.clear();
        }
        return c3435c;
    }

    public void a(Invocation invocation, long j, boolean z) {
        C3426a.C3428b c3428b;
        C3426a a = C3426a.a();
        if (a.b.contains(invocation.getProxyName())) {
            c3428b = C3426a.C3428b.b;
        } else {
            c3428b = C3426a.C3428b.c;
        }
        C3426a.C3428b c3428b2 = c3428b;
        a(invocation, z);
        if (c3428b2 == null || !c3428b2.a) {
            return;
        }
        a(invocation, j, c3428b2, z);
    }

    public void a(String str, Object obj) {
        Invocation invocation = new Invocation(str, null, new Object[0]);
        invocation.setResult(obj);
        a(invocation, System.currentTimeMillis() / 1000, true);
    }
}
