package com.alipay.sdk.m.h;

import com.alipay.sdk.m.g.C4192a;
import com.alipay.sdk.m.g.C4194c;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.h.a */
/* loaded from: classes10.dex */
public class C4197a extends C4192a {
    public static final /* synthetic */ boolean d = true;

    public C4197a(byte[] bArr) {
        super(bArr);
    }

    public static C4197a a(String str, long j, AbstractC4198b abstractC4198b, short s, AbstractC4201e abstractC4201e) throws Exception {
        byte[] a = C4194c.a((byte) 1);
        boolean z = d;
        if (z || a.length == 1) {
            byte[] a2 = C4194c.a(str.charAt(0), str.charAt(1));
            if (z || a2.length == 2) {
                byte[] a3 = C4194c.a(j);
                if (z || a3.length == 8) {
                    byte[] b = C4194c.b();
                    if (z || b.length == 2) {
                        abstractC4198b.a();
                        byte[] a4 = C4194c.a(abstractC4198b.a);
                        if (z || a4.length == 1) {
                            byte[] a5 = C4194c.a(abstractC4198b.b);
                            if (z || a5.length == 1) {
                                byte[] bArr = (byte[]) abstractC4198b.c.clone();
                                if (z || bArr.length == (abstractC4198b.b & 255)) {
                                    byte[] a6 = C4194c.a(s);
                                    if (z || a6.length == 2) {
                                        byte[] b2 = C4194c.b();
                                        if (z || b2.length == 2) {
                                            abstractC4201e.a();
                                            byte[] a7 = C4194c.a(abstractC4201e.a);
                                            if (z || a7.length == 1) {
                                                byte[] bArr2 = (byte[]) abstractC4201e.b.clone();
                                                if (z || bArr2.length == (abstractC4201e.a & 255)) {
                                                    byte[] c = C4194c.c();
                                                    if (z || c.length == 4) {
                                                        return new C4197a(C4194c.a(a, a2, a3, b, a4, a5, bArr, a6, b2, a7, bArr2, c));
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

    public static C4197a c() {
        try {
            return a(C4192a.c, 0L, new C4199c(""), (short) 0, new C4202f());
        } catch (Exception unused) {
            return null;
        }
    }
}
