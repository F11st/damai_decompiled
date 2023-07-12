package com.xiaomi.push;

import java.io.IOException;

/* compiled from: Taobao */
/* renamed from: com.xiaomi.push.e */
/* loaded from: classes11.dex */
public abstract class AbstractC7646e {
    public abstract int a();

    public abstract AbstractC7646e a(C7605b c7605b);

    public AbstractC7646e a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public AbstractC7646e a(byte[] bArr, int i, int i2) {
        try {
            C7605b a = C7605b.a(bArr, i, i2);
            a(a);
            a.m678a(0);
            return this;
        } catch (C7626d e) {
            throw e;
        } catch (IOException unused) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public abstract void a(C7614c c7614c);

    /* renamed from: a  reason: collision with other method in class */
    public void m851a(byte[] bArr, int i, int i2) {
        try {
            C7614c a = C7614c.a(bArr, i, i2);
            a(a);
            a.b();
        } catch (IOException unused) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(C7605b c7605b, int i) {
        return c7605b.m680a(i);
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m852a() {
        int b = b();
        byte[] bArr = new byte[b];
        m851a(bArr, 0, b);
        return bArr;
    }

    public abstract int b();
}
