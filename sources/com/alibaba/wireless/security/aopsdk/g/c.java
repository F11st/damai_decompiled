package com.alibaba.wireless.security.aopsdk.g;

import com.alibaba.wireless.security.aopsdk.Invocation;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: WithArgsCachePolicy.java */
/* loaded from: classes.dex */
public class c implements com.alibaba.wireless.security.aopsdk.g.a {
    private static final String e = "AOP-CACHE";
    private double b;
    private long a = -1;
    private final Map<com.alibaba.wireless.security.aopsdk.e.b, a> c = new ConcurrentHashMap();
    private int d = 5;

    /* compiled from: WithArgsCachePolicy.java */
    /* loaded from: classes.dex */
    public static class a {
        public Object a;
        public Throwable b;
        public boolean c = false;
    }

    public c(double d) {
        this.b = -1.0d;
        this.b = d;
    }

    private void h(Invocation invocation) {
        com.alibaba.wireless.security.aopsdk.e.b hashableArgs = invocation.getHashableArgs();
        if (this.c.get(hashableArgs) != null || i(invocation)) {
            return;
        }
        this.c.put(hashableArgs, new a());
    }

    private boolean i(Invocation invocation) {
        return this.c.size() >= a() && !this.c.containsKey(invocation.getHashableArgs());
    }

    @Override // com.alibaba.wireless.security.aopsdk.g.a
    public boolean a(Invocation invocation) {
        Object[] objArr = invocation.args;
        if (objArr != null && objArr.length != 0) {
            return i(invocation) || !f(invocation);
        }
        com.alibaba.wireless.security.aopsdk.i.a.a(e, "Invocation args is unexpected empty");
        return true;
    }

    @Override // com.alibaba.wireless.security.aopsdk.g.a
    public Object b(Invocation invocation) {
        a aVar = this.c.get(invocation.getHashableArgs());
        if (aVar != null) {
            return aVar.a;
        }
        return null;
    }

    @Override // com.alibaba.wireless.security.aopsdk.g.a
    public Throwable c(Invocation invocation) {
        a aVar = this.c.get(invocation.getHashableArgs());
        if (aVar != null) {
            return aVar.b;
        }
        return null;
    }

    @Override // com.alibaba.wireless.security.aopsdk.g.a
    public void d(Invocation invocation) {
        com.alibaba.wireless.security.aopsdk.e.b hashableArgs = invocation.getHashableArgs();
        a aVar = this.c.get(hashableArgs);
        if (aVar == null && !i(invocation)) {
            aVar = new a();
            this.c.put(hashableArgs, aVar);
        }
        if (aVar != null) {
            aVar.b = invocation.getThrowable();
            aVar.c = true;
        }
    }

    @Override // com.alibaba.wireless.security.aopsdk.g.a
    public void e(Invocation invocation) {
        Object[] objArr = invocation.args;
        if (objArr != null && objArr.length != 0) {
            h(invocation);
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.a;
            double d = (currentTimeMillis - j) / 1000.0d;
            double d2 = 60.0d / this.b;
            if (j == -1 || d > d2) {
                this.c.clear();
                this.a = currentTimeMillis;
                return;
            }
            return;
        }
        com.alibaba.wireless.security.aopsdk.i.a.a(e, "Invocation args is unexpected empty");
    }

    @Override // com.alibaba.wireless.security.aopsdk.g.a
    public boolean f(Invocation invocation) {
        a aVar = this.c.get(invocation.getHashableArgs());
        if (aVar != null) {
            return aVar.c;
        }
        return false;
    }

    @Override // com.alibaba.wireless.security.aopsdk.g.a
    public void g(Invocation invocation) {
        com.alibaba.wireless.security.aopsdk.e.b hashableArgs = invocation.getHashableArgs();
        a aVar = this.c.get(hashableArgs);
        if (aVar == null && !i(invocation)) {
            aVar = new a();
            this.c.put(hashableArgs, aVar);
        }
        if (aVar != null) {
            aVar.a = invocation.getResult();
            aVar.c = true;
        }
    }

    public int a() {
        return this.d;
    }

    public void a(int i) {
        this.d = i;
    }
}
