package com.alibaba.mobsec.privacydoublelist.e;

import com.alibaba.mobsec.privacydoublelist.c.a;
import com.alibaba.wireless.security.aopsdk.Invocation;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class e {
    public static e d;
    public final Map<String, a> a = new HashMap();
    public final Map<String, d> b = new HashMap();
    public int c = 5;

    public static synchronized e b() {
        e eVar;
        synchronized (e.class) {
            if (d == null) {
                d = new e();
            }
            eVar = d;
        }
        return eVar;
    }

    public void a(int i) {
    }

    public void a(Invocation invocation, boolean z) {
        a aVar = this.a.get(invocation.getProxyName());
        if (aVar == null) {
            synchronized (this) {
                aVar = this.a.get(invocation.getProxyName());
                if (aVar == null) {
                    aVar = new a(invocation.getProxyName());
                    this.a.put(invocation.getProxyName(), aVar);
                }
            }
        }
        aVar.a(invocation, z);
    }

    public void a(Invocation invocation, long j, a.b bVar, boolean z) {
        synchronized (this) {
            d dVar = this.b.get(invocation.getProxyName());
            if (dVar == null) {
                dVar = new d(invocation, j, bVar);
                this.b.put(invocation.getProxyName(), dVar);
            }
            dVar.a(invocation);
            dVar.a(invocation, z);
        }
    }

    public c a() {
        c cVar;
        synchronized (this) {
            cVar = new c(new HashMap(this.b), new HashMap(this.a));
            this.b.clear();
            this.a.clear();
        }
        return cVar;
    }

    public void a(Invocation invocation, long j, boolean z) {
        a.b bVar;
        com.alibaba.mobsec.privacydoublelist.c.a a = com.alibaba.mobsec.privacydoublelist.c.a.a();
        if (a.b.contains(invocation.getProxyName())) {
            bVar = a.b.b;
        } else {
            bVar = a.b.c;
        }
        a.b bVar2 = bVar;
        a(invocation, z);
        if (bVar2 == null || !bVar2.a) {
            return;
        }
        a(invocation, j, bVar2, z);
    }

    public void a(String str, Object obj) {
        Invocation invocation = new Invocation(str, null, new Object[0]);
        invocation.setResult(obj);
        a(invocation, System.currentTimeMillis() / 1000, true);
    }
}
