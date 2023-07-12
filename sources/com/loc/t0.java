package com.loc;

import java.util.List;
import tb.a73;
import tb.b73;
import tb.e63;
import tb.m53;
import tb.p53;
import tb.t63;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class t0 extends q0 {
    private static t0 c = new t0();

    private t0() {
        super(5120);
    }

    private static String b(String str) {
        return str == null ? "" : str;
    }

    public static t0 d() {
        return c;
    }

    public final byte[] c(byte[] bArr, byte[] bArr2, List<? extends m53> list) {
        if (list == null) {
            return null;
        }
        try {
            int size = list.size();
            if (size <= 0 || bArr == null) {
                return null;
            }
            a();
            int c2 = p53.c(this.a, bArr);
            int[] iArr = new int[size];
            for (int i = 0; i < size; i++) {
                m53 m53Var = list.get(i);
                iArr[i] = e63.b(this.a, (byte) m53Var.a(), e63.c(this.a, m53Var.b()));
            }
            this.a.w(p53.b(this.a, c2, bArr2 != null ? p53.f(this.a, bArr2) : 0, p53.d(this.a, iArr)));
            return this.a.z();
        } catch (Throwable th) {
            b73.a(th);
            return null;
        }
    }

    public final byte[] e() {
        super.a();
        try {
            this.a.w(a73.b(this.a, t63.a(), this.a.b(t63.m()), this.a.b(t63.g()), (byte) t63.A(), this.a.b(t63.s()), this.a.b(t63.q()), this.a.b(b(t63.o())), this.a.b(b(t63.u())), y0.a(t63.C()), this.a.b(t63.y()), this.a.b(t63.w()), this.a.b(t63.i()), this.a.b(t63.k())));
            return this.a.z();
        } catch (Exception e) {
            b73.a(e);
            return null;
        }
    }
}
