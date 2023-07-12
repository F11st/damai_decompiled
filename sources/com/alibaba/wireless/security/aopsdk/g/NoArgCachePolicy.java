package com.alibaba.wireless.security.aopsdk.g;

import com.alibaba.wireless.security.aopsdk.Invocation;

/* renamed from: com.alibaba.wireless.security.aopsdk.g.b */
/* loaded from: classes.dex */
public class NoArgCachePolicy implements ICachePolicy {
    private double c;
    private long a = -1;
    private int b = 0;
    private Object d = null;
    private Throwable e = null;
    private boolean f = false;

    public NoArgCachePolicy(double d) {
        this.c = -1.0d;
        this.c = d;
    }

    @Override // com.alibaba.wireless.security.aopsdk.g.ICachePolicy
    public boolean a(Invocation invocation) {
        return this.b == 0;
    }

    @Override // com.alibaba.wireless.security.aopsdk.g.ICachePolicy
    public Object b(Invocation invocation) {
        return this.d;
    }

    @Override // com.alibaba.wireless.security.aopsdk.g.ICachePolicy
    public Throwable c(Invocation invocation) {
        return this.e;
    }

    @Override // com.alibaba.wireless.security.aopsdk.g.ICachePolicy
    public void d(Invocation invocation) {
        this.e = invocation.getThrowable();
        this.f = true;
    }

    @Override // com.alibaba.wireless.security.aopsdk.g.ICachePolicy
    public void e(Invocation invocation) {
        this.b++;
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.a;
        double d = (currentTimeMillis - j) / 1000.0d;
        double d2 = 60.0d / this.c;
        if (j == -1 || d > d2 || Integer.MAX_VALUE == this.b) {
            this.b = 0;
            this.a = currentTimeMillis;
            this.f = false;
        }
    }

    @Override // com.alibaba.wireless.security.aopsdk.g.ICachePolicy
    public boolean f(Invocation invocation) {
        return this.f;
    }

    @Override // com.alibaba.wireless.security.aopsdk.g.ICachePolicy
    public void g(Invocation invocation) {
        this.d = invocation.getResult();
        this.f = true;
    }
}
