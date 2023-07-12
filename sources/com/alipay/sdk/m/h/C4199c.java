package com.alipay.sdk.m.h;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.h.c */
/* loaded from: classes10.dex */
public final class C4199c extends AbstractC4198b {
    public final String f;

    public C4199c(String str) {
        this.f = str;
    }

    @Override // com.alipay.sdk.m.h.AbstractC4198b
    public void a() throws Exception {
        this.a = (byte) 1;
        byte[] bytes = this.f.getBytes("UTF-8");
        this.c = bytes;
        this.b = (byte) bytes.length;
    }
}
