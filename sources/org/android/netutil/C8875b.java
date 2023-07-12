package org.android.netutil;

/* compiled from: Taobao */
/* renamed from: org.android.netutil.b */
/* loaded from: classes2.dex */
public class C8875b {
    private C8874a[] e;
    private String a = null;
    private String b = null;
    private int c = 0;
    private int d = 0;
    private PingTaskWatcher f = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C8875b(int i) {
        this.e = null;
        this.e = new C8874a[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.e[i2] = new C8874a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, int i2, double d) {
        this.e[i].a(i, i2, d);
        if (d >= 0.0d) {
            this.d++;
        }
        PingTaskWatcher pingTaskWatcher = this.f;
        if (pingTaskWatcher != null) {
            pingTaskWatcher.OnEntry(i, i2, d);
        }
    }

    public int b() {
        return this.c;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.a;
    }

    public C8874a[] e() {
        return this.e;
    }

    public int f() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(PingTaskWatcher pingTaskWatcher) {
        this.f = pingTaskWatcher;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(int i) {
        this.c = i;
        PingTaskWatcher pingTaskWatcher = this.f;
        if (pingTaskWatcher != null) {
            if (i == 0) {
                pingTaskWatcher.OnFinished();
            } else {
                pingTaskWatcher.OnFailed(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(String str) {
        this.b = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(String str) {
        this.a = str;
    }
}
