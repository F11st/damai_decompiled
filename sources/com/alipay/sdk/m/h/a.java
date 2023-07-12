package com.alipay.sdk.m.h;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class a extends com.alipay.sdk.m.g.a {
    public static final /* synthetic */ boolean d = true;

    public a(byte[] bArr) {
        super(bArr);
    }

    public static a a(String str, long j, b bVar, short s, e eVar) throws Exception {
        byte[] a = com.alipay.sdk.m.g.c.a((byte) 1);
        boolean z = d;
        if (z || a.length == 1) {
            byte[] a2 = com.alipay.sdk.m.g.c.a(str.charAt(0), str.charAt(1));
            if (z || a2.length == 2) {
                byte[] a3 = com.alipay.sdk.m.g.c.a(j);
                if (z || a3.length == 8) {
                    byte[] b = com.alipay.sdk.m.g.c.b();
                    if (z || b.length == 2) {
                        bVar.a();
                        byte[] a4 = com.alipay.sdk.m.g.c.a(bVar.a);
                        if (z || a4.length == 1) {
                            byte[] a5 = com.alipay.sdk.m.g.c.a(bVar.b);
                            if (z || a5.length == 1) {
                                byte[] bArr = (byte[]) bVar.c.clone();
                                if (z || bArr.length == (bVar.b & 255)) {
                                    byte[] a6 = com.alipay.sdk.m.g.c.a(s);
                                    if (z || a6.length == 2) {
                                        byte[] b2 = com.alipay.sdk.m.g.c.b();
                                        if (z || b2.length == 2) {
                                            eVar.a();
                                            byte[] a7 = com.alipay.sdk.m.g.c.a(eVar.a);
                                            if (z || a7.length == 1) {
                                                byte[] bArr2 = (byte[]) eVar.b.clone();
                                                if (z || bArr2.length == (eVar.a & 255)) {
                                                    byte[] c = com.alipay.sdk.m.g.c.c();
                                                    if (z || c.length == 4) {
                                                        return new a(com.alipay.sdk.m.g.c.a(a, a2, a3, b, a4, a5, bArr, a6, b2, a7, bArr2, c));
                                                    }
                                                    throw new AssertionError();
                                                }
                                                throw new AssertionError();
                                            }
                                            throw new AssertionError();
                                        }
                                        throw new AssertionError();
                                    }
                                    throw new AssertionError();
                                }
                                throw new AssertionError();
                            }
                            throw new AssertionError();
                        }
                        throw new AssertionError();
                    }
                    throw new AssertionError();
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static a c() {
        try {
            return a(com.alipay.sdk.m.g.a.c, 0L, new c(""), (short) 0, new f());
        } catch (Exception unused) {
            return null;
        }
    }
}
