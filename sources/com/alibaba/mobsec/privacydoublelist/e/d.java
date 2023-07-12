package com.alibaba.mobsec.privacydoublelist.e;

import com.alibaba.mobsec.privacydoublelist.c.a;
import com.alibaba.wireless.security.aopsdk.Invocation;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class d extends b {
    public final String h;
    public Map<Object, a> i;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static class a extends b {
        public final Object h;

        public a(Object obj) {
            this.h = obj;
        }

        public String toString() {
            return this.b.get() + "|" + this.c.get() + "|" + a() + "|0|" + a() + "|" + this.e.get() + "|" + com.alibaba.mobsec.privacydoublelist.f.a.a(this.h);
        }
    }

    public d(Invocation invocation, long j, a.b bVar) {
        this.h = invocation.getProxyName();
        if (bVar == null || !bVar.a) {
            return;
        }
        this.i = new HashMap();
        a(invocation);
    }

    public boolean a(Invocation invocation) {
        Object result = invocation.getResult();
        synchronized (this) {
            if (invocation.shouldBlock() || this.i.containsKey(result) || this.i.size() >= e.b().c) {
                return false;
            }
            this.i.put(result, new a(result));
            return true;
        }
    }

    public int hashCode() {
        return this.h.hashCode();
    }

    @Override // com.alibaba.mobsec.privacydoublelist.e.b
    public void a(Invocation invocation, boolean z) {
        synchronized (this) {
            a aVar = this.i.get(invocation.getResult());
            if (aVar != null) {
                aVar.a(invocation, z);
            }
        }
    }
}
