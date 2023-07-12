package com.alipay.android.phone.mrpc.core;

/* compiled from: Taobao */
/* renamed from: com.alipay.android.phone.mrpc.core.p */
/* loaded from: classes10.dex */
public final class C4084p extends C4089u {
    public int c;
    public String d;
    public long e;
    public long f;
    public String g;
    public HttpUrlHeader h;

    public C4084p(HttpUrlHeader httpUrlHeader, int i, String str, byte[] bArr) {
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
