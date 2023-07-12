package com.alibaba.wireless.security.aopsdk;

import java.lang.reflect.Member;

/* renamed from: com.alibaba.wireless.security.aopsdk.b */
/* loaded from: classes.dex */
public class AopParam {
    public Member a;
    public Object b;
    private Object[] c;
    private Object d = null;
    private Throwable e = null;

    public void a(Object obj) {
        this.d = obj;
        this.e = null;
    }

    public Object b() {
        return this.d;
    }

    public Throwable c() {
        return this.e;
    }

    public boolean d() {
        return this.e != null;
    }

    public void a(Throwable th) {
        this.e = th;
        this.d = null;
    }

    public void a(Object[] objArr) {
        this.c = objArr;
    }

    public Object[] a() {
        return this.c;
    }
}
