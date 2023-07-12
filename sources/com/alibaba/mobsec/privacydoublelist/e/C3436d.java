package com.alibaba.mobsec.privacydoublelist.e;

import com.alibaba.mobsec.privacydoublelist.c.C3426a;
import com.alibaba.mobsec.privacydoublelist.f.C3439a;
import com.alibaba.wireless.security.aopsdk.Invocation;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.alibaba.mobsec.privacydoublelist.e.d */
/* loaded from: classes6.dex */
public class C3436d extends AbstractC3434b {
    public final String h;
    public Map<Object, C3437a> i;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.mobsec.privacydoublelist.e.d$a */
    /* loaded from: classes6.dex */
    public static class C3437a extends AbstractC3434b {
        public final Object h;

        public C3437a(Object obj) {
            this.h = obj;
        }

        public String toString() {
            return this.b.get() + "|" + this.c.get() + "|" + a() + "|0|" + a() + "|" + this.e.get() + "|" + C3439a.a(this.h);
        }
    }

    public C3436d(Invocation invocation, long j, C3426a.C3428b c3428b) {
        this.h = invocation.getProxyName();
        if (c3428b == null || !c3428b.a) {
            return;
        }
        this.i = new HashMap();
        a(invocation);
    }

    public boolean a(Invocation invocation) {
        Object result = invocation.getResult();
        synchronized (this) {
            if (invocation.shouldBlock() || this.i.containsKey(result) || this.i.size() >= C3438e.b().c) {
                return false;
            }
            this.i.put(result, new C3437a(result));
            return true;
        }
    }

    public int hashCode() {
        return this.h.hashCode();
    }

    @Override // com.alibaba.mobsec.privacydoublelist.e.AbstractC3434b
    public void a(Invocation invocation, boolean z) {
        synchronized (this) {
            C3437a c3437a = this.i.get(invocation.getResult());
            if (c3437a != null) {
                c3437a.a(invocation, z);
            }
        }
    }
}
