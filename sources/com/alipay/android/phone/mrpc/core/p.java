package com.alipay.android.phone.mrpc.core;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class p extends u {
    public int c;
    public String d;
    public long e;
    public long f;
    public String g;
    public HttpUrlHeader h;

    public p(HttpUrlHeader httpUrlHeader, int i, String str, byte[] bArr) {
        this.h = httpUrlHeader;
        this.c = i;
        this.d = str;
        this.a = bArr;
    }

    public final HttpUrlHeader a() {
        return this.h;
    }

    public final void a(long j) {
        this.e = j;
    }

    public final void a(String str) {
        this.g = str;
    }

    public final void b(long j) {
        this.f = j;
    }
}
