package com.tencent.open.log;

import com.tencent.open.log.C7102d;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class Tracer {
    private volatile int a;
    private volatile boolean b;
    private C7109g c;

    public Tracer() {
        this(C7101c.a, true, C7109g.a);
    }

    public void a(int i, Thread thread, long j, String str, String str2, Throwable th) {
        if (d() && C7102d.C7103a.a(this.a, i)) {
            doTrace(i, thread, j, str, str2, th);
        }
    }

    public boolean d() {
        return this.b;
    }

    protected abstract void doTrace(int i, Thread thread, long j, String str, String str2, Throwable th);

    public C7109g e() {
        return this.c;
    }

    public Tracer(int i, boolean z, C7109g c7109g) {
        this.a = C7101c.a;
        this.b = true;
        this.c = C7109g.a;
        a(i);
        a(z);
        a(c7109g);
    }

    public void a(int i) {
        this.a = i;
    }

    public void a(boolean z) {
        this.b = z;
    }

    public void a(C7109g c7109g) {
        this.c = c7109g;
    }
}
