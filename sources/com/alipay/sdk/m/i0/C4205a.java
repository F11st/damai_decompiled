package com.alipay.sdk.m.i0;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.i0.a */
/* loaded from: classes12.dex */
public class C4205a {
    public long a;
    public String b;
    public String c;
    public int d;

    public C4205a(String str) {
        this.c = str;
    }

    public void a(int i) {
        this.d = i;
    }

    public void a(long j) {
        this.a = j;
    }

    public void a(String str) {
        this.b = str;
    }

    public boolean a() {
        return this.a > System.currentTimeMillis();
    }

    public void b() {
        this.a = 0L;
    }
}
