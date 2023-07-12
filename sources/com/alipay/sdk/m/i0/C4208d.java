package com.alipay.sdk.m.i0;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.i0.d */
/* loaded from: classes12.dex */
public class C4208d {
    public String a;
    public int b;
    public long c = System.currentTimeMillis() + 86400000;

    public C4208d(String str, int i) {
        this.a = str;
        this.b = i;
    }

    public String toString() {
        return "ValueData{value='" + this.a + "', code=" + this.b + ", expired=" + this.c + '}';
    }
}
