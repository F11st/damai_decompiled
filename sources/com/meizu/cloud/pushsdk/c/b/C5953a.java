package com.meizu.cloud.pushsdk.c.b;

import com.meizu.cloud.pushsdk.c.c.C5971k;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.c.b.a */
/* loaded from: classes10.dex */
public class C5953a extends Exception {
    private String a;
    private int b;
    private String c;
    private C5971k d;

    public C5953a() {
        this.b = 0;
    }

    public C5953a(C5971k c5971k) {
        this.b = 0;
        this.d = c5971k;
    }

    public C5953a(Throwable th) {
        super(th);
        this.b = 0;
    }

    public C5971k a() {
        return this.d;
    }

    public void a(int i) {
        this.b = i;
    }

    public void a(String str) {
        this.c = str;
    }

    public int b() {
        return this.b;
    }

    public void b(String str) {
        this.a = str;
    }

    public String c() {
        return this.a;
    }
}
