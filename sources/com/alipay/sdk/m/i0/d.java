package com.alipay.sdk.m.i0;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class d {
    public String a;
    public int b;
    public long c = System.currentTimeMillis() + 86400000;

    public d(String str, int i) {
        this.a = str;
        this.b = i;
    }

    public String toString() {
        return "ValueData{value='" + this.a + "', code=" + this.b + ", expired=" + this.c + '}';
    }
}
