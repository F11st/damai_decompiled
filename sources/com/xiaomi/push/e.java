package com.xiaomi.push;

import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class e {
    public abstract int a();

    public abstract e a(b bVar);

    public e a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public e a(byte[] bArr, int i, int i2) {
        try {
            b a = b.a(bArr, i, i2);
            a(a);
            a.m678a(0);
            return this;
        } catch (d e) {
            throw e;
        } catch (IOException unused) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public abstract void a(c cVar);

    /* renamed from: a  reason: collision with other method in class */
    public void m851a(byte[] bArr, int i, int i2) {
        try {
            c a = c.a(bArr, i, i2);
            a(a);
            a.b();
        } catch (IOException unused) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(b bVar, int i) {
        return bVar.m680a(i);
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
