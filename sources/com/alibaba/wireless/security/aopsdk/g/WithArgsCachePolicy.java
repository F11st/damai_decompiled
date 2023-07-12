package com.alibaba.wireless.security.aopsdk.g;

import com.alibaba.wireless.security.aopsdk.Invocation;
import com.alibaba.wireless.security.aopsdk.e.HashableArgs;
import com.alibaba.wireless.security.aopsdk.i.LogUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.alibaba.wireless.security.aopsdk.g.c */
/* loaded from: classes.dex */
public class WithArgsCachePolicy implements ICachePolicy {
    private static final String e = "AOP-CACHE";
    private double b;
    private long a = -1;
    private final Map<HashableArgs, C3981a> c = new ConcurrentHashMap();
    private int d = 5;

    /* compiled from: WithArgsCachePolicy.java */
    /* renamed from: com.alibaba.wireless.security.aopsdk.g.c$a */
    /* loaded from: classes.dex */
    public static class C3981a {
        public Object a;
        public Throwable b;
        public boolean c = false;
    }

    public WithArgsCachePolicy(double d) {
        this.b = -1.0d;
        this.b = d;
    }

    private void h(Invocation invocation) {
        HashableArgs hashableArgs = invocation.getHashableArgs();
        if (this.c.get(hashableArgs) != null || i(invocation)) {
            return;
        }
        this.c.put(hashableArgs, new C3981a());
    }

    private boolean i(Invocation invocation) {
        return this.c.size() >= a() && !this.c.containsKey(invocation.getHashableArgs());
    }

    @Override // com.alibaba.wireless.security.aopsdk.g.ICachePolicy
    public boolean a(Invocation invocation) {
        Object[] objArr = invocation.args;
        if (objArr != null && objArr.length != 0) {
            return i(invocation) || !f(invocation);
        }
        LogUtils.a(e, "Invocation args is unexpected empty");
        return true;
    }

    @Override // com.alibaba.wireless.security.aopsdk.g.ICachePolicy
    public Object b(Invocation invocation) {
        C3981a c3981a = this.c.get(invocation.getHashableArgs());
        if (c3981a != null) {
            return c3981a.a;
        }
        return null;
    }

    @Override // com.alibaba.wireless.security.aopsdk.g.ICachePolicy
    public Throwable c(Invocation invocation) {
        C3981a c3981a = this.c.get(invocation.getHashableArgs());
        if (c3981a != null) {
            return c3981a.b;
        }
        return null;
    }

    @Override // com.alibaba.wireless.security.aopsdk.g.ICachePolicy
    public void d(Invocation invocation) {
        HashableArgs hashableArgs = invocation.getHashableArgs();
        C3981a c3981a = this.c.get(hashableArgs);
        if (c3981a == null && !i(invocation)) {
            c3981a = new C3981a();
            this.c.put(hashableArgs, c3981a);
        }
        if (c3981a != null) {
            c3981a.b = invocation.getThrowable();
            c3981a.c = true;
        }
    }

    @Override // com.alibaba.wireless.security.aopsdk.g.ICachePolicy
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
        LogUtils.a(e, "Invocation args is unexpected empty");
    }

    @Override // com.alibaba.wireless.security.aopsdk.g.ICachePolicy
    public boolean f(Invocation invocation) {
        C3981a c3981a = this.c.get(invocation.getHashableArgs());
        if (c3981a != null) {
            return c3981a.c;
        }
        return false;
    }

    @Override // com.alibaba.wireless.security.aopsdk.g.ICachePolicy
    public void g(Invocation invocation) {
        HashableArgs hashableArgs = invocation.getHashableArgs();
        C3981a c3981a = this.c.get(hashableArgs);
        if (c3981a == null && !i(invocation)) {
            c3981a = new C3981a();
            this.c.put(hashableArgs, c3981a);
        }
        if (c3981a != null) {
            c3981a.a = invocation.getResult();
            c3981a.c = true;
        }
    }

    public int a() {
        return this.d;
    }

    public void a(int i) {
        this.d = i;
    }
}
