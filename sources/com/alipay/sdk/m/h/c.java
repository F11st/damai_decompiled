package com.alipay.sdk.m.h;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class c extends b {
    public final String f;

    public c(String str) {
        this.f = str;
    }

    @Override // com.alipay.sdk.m.h.b
    public void a() throws Exception {
        this.a = (byte) 1;
        byte[] bytes = this.f.getBytes("UTF-8");
        this.c = bytes;
        this.b = (byte) bytes.length;
    }
}
