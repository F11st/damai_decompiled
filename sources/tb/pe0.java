package tb;

import com.google.zxing.WriterException;
import java.io.UnsupportedEncodingException;
import java.util.Hashtable;
import java.util.Vector;
import tb.ex2;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class pe0 {
    private static final int[] a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    static void a(String str, lc lcVar, String str2) throws WriterException {
        try {
            byte[] bytes = str.getBytes(str2);
            for (byte b : bytes) {
                lcVar.c(b, 8);
            }
        } catch (UnsupportedEncodingException e) {
            throw new WriterException(e.toString());
        }
    }

    static void b(String str, lc lcVar) throws WriterException {
        int length = str.length();
        int i = 0;
        while (i < length) {
            int n = n(str.charAt(i));
            if (n == -1) {
                throw new WriterException();
            }
            int i2 = i + 1;
            if (i2 < length) {
                int n2 = n(str.charAt(i2));
                if (n2 != -1) {
                    lcVar.c((n * 45) + n2, 11);
                    i += 2;
                } else {
                    throw new WriterException();
                }
            } else {
                lcVar.c(n, 6);
                i = i2;
            }
        }
    }

    static void c(String str, ug1 ug1Var, lc lcVar, String str2) throws WriterException {
        if (ug1Var.equals(ug1.NUMERIC)) {
            h(str, lcVar);
        } else if (ug1Var.equals(ug1.ALPHANUMERIC)) {
            b(str, lcVar);
        } else if (ug1Var.equals(ug1.BYTE)) {
            a(str, lcVar, str2);
        } else if (ug1Var.equals(ug1.KANJI)) {
            e(str, lcVar);
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Invalid mode: ");
            stringBuffer.append(ug1Var);
            throw new WriterException(stringBuffer.toString());
        }
    }

    private static void d(pd0 pd0Var, lc lcVar) {
        lcVar.c(ug1.ECI.a(), 4);
        lcVar.c(pd0Var.a(), 8);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0035 A[LOOP:0: B:4:0x0008->B:17:0x0035, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0044 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void e(java.lang.String r6, tb.lc r7) throws com.google.zxing.WriterException {
        /*
            java.lang.String r0 = "Shift_JIS"
            byte[] r6 = r6.getBytes(r0)     // Catch: java.io.UnsupportedEncodingException -> L4d
            int r0 = r6.length
            r1 = 0
        L8:
            if (r1 >= r0) goto L4c
            r2 = r6[r1]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r3 = r1 + 1
            r3 = r6[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r2 = r2 << 8
            r2 = r2 | r3
            r3 = 33088(0x8140, float:4.6366E-41)
            r4 = -1
            if (r2 < r3) goto L24
            r5 = 40956(0x9ffc, float:5.7392E-41)
            if (r2 > r5) goto L24
        L22:
            int r2 = r2 - r3
            goto L33
        L24:
            r3 = 57408(0xe040, float:8.0446E-41)
            if (r2 < r3) goto L32
            r3 = 60351(0xebbf, float:8.457E-41)
            if (r2 > r3) goto L32
            r3 = 49472(0xc140, float:6.9325E-41)
            goto L22
        L32:
            r2 = -1
        L33:
            if (r2 == r4) goto L44
            int r3 = r2 >> 8
            int r3 = r3 * 192
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r3 = r3 + r2
            r2 = 13
            r7.c(r3, r2)
            int r1 = r1 + 2
            goto L8
        L44:
            com.google.zxing.WriterException r6 = new com.google.zxing.WriterException
            java.lang.String r7 = "Invalid byte sequence"
            r6.<init>(r7)
            throw r6
        L4c:
            return
        L4d:
            r6 = move-exception
            com.google.zxing.WriterException r7 = new com.google.zxing.WriterException
            java.lang.String r6 = r6.toString()
            r7.<init>(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.pe0.e(java.lang.String, tb.lc):void");
    }

    static void f(int i, int i2, ug1 ug1Var, lc lcVar) throws WriterException {
        int b = ug1Var.b(ex2.e(i2));
        int i3 = (1 << b) - 1;
        if (i <= i3) {
            lcVar.c(i, b);
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i);
        stringBuffer.append("is bigger than");
        stringBuffer.append(i3);
        throw new WriterException(stringBuffer.toString());
    }

    static void g(ug1 ug1Var, lc lcVar) {
        lcVar.c(ug1Var.a(), 4);
    }

    static void h(String str, lc lcVar) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            int charAt = str.charAt(i) - '0';
            int i2 = i + 2;
            if (i2 < length) {
                lcVar.c((charAt * 100) + ((str.charAt(i + 1) - '0') * 10) + (str.charAt(i2) - '0'), 10);
                i += 3;
            } else {
                i++;
                if (i < length) {
                    lcVar.c((charAt * 10) + (str.charAt(i) - '0'), 7);
                    i = i2;
                } else {
                    lcVar.c(charAt, 4);
                }
            }
        }
    }

    private static int i(ne neVar) {
        return jd1.a(neVar) + 0 + jd1.c(neVar) + jd1.d(neVar) + jd1.e(neVar);
    }

    private static int j(lc lcVar, df0 df0Var, int i, ne neVar) throws WriterException {
        int i2 = Integer.MAX_VALUE;
        int i3 = -1;
        for (int i4 = 0; i4 < 8; i4++) {
            sd1.a(lcVar, df0Var, i, i4, neVar);
            int i5 = i(neVar);
            if (i5 < i2) {
                i3 = i4;
                i2 = i5;
            }
        }
        return i3;
    }

    public static ug1 k(String str, String str2) {
        if ("Shift_JIS".equals(str2)) {
            return r(str) ? ug1.KANJI : ug1.BYTE;
        }
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt >= '0' && charAt <= '9') {
                z2 = true;
            } else if (n(charAt) == -1) {
                return ug1.BYTE;
            } else {
                z = true;
            }
        }
        if (z) {
            return ug1.ALPHANUMERIC;
        }
        if (z2) {
            return ug1.NUMERIC;
        }
        return ug1.BYTE;
    }

    public static void l(String str, df0 df0Var, Hashtable hashtable, dy1 dy1Var) throws WriterException {
        gi d;
        String str2 = hashtable == null ? null : (String) hashtable.get(me0.CHARACTER_SET);
        if (str2 == null) {
            str2 = "UTF-8";
        }
        ug1 k = k(str, str2);
        lc lcVar = new lc();
        c(str, k, lcVar, str2);
        p(lcVar.g(), df0Var, k, dy1Var);
        lc lcVar2 = new lc();
        ug1 ug1Var = ug1.BYTE;
        if (k == ug1Var && !"UTF-8".equals(str2) && (d = gi.d(str2)) != null) {
            d(d, lcVar2);
        }
        g(k, lcVar2);
        f(k.equals(ug1Var) ? lcVar.g() : str.length(), dy1Var.h(), k, lcVar2);
        lcVar2.b(lcVar);
        s(dy1Var.e(), lcVar2);
        lc lcVar3 = new lc();
        q(lcVar2, dy1Var.g(), dy1Var.e(), dy1Var.f(), lcVar3);
        ne neVar = new ne(dy1Var.d(), dy1Var.d());
        dy1Var.l(j(lcVar3, dy1Var.a(), dy1Var.h(), neVar));
        sd1.a(lcVar3, dy1Var.a(), dy1Var.h(), dy1Var.b(), neVar);
        dy1Var.m(neVar);
        if (dy1Var.i()) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Invalid QR code: ");
        stringBuffer.append(dy1Var.toString());
        throw new WriterException(stringBuffer.toString());
    }

    static byte[] m(byte[] bArr, int i) {
        int length = bArr.length;
        int[] iArr = new int[length + i];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & 255;
        }
        new rz1(wp0.QR_CODE_FIELD).b(iArr, i);
        byte[] bArr2 = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr2[i3] = (byte) iArr[length + i3];
        }
        return bArr2;
    }

    static int n(int i) {
        int[] iArr = a;
        if (i < iArr.length) {
            return iArr[i];
        }
        return -1;
    }

    static void o(int i, int i2, int i3, int i4, int[] iArr, int[] iArr2) throws WriterException {
        if (i4 < i3) {
            int i5 = i % i3;
            int i6 = i3 - i5;
            int i7 = i / i3;
            int i8 = i7 + 1;
            int i9 = i2 / i3;
            int i10 = i9 + 1;
            int i11 = i7 - i9;
            int i12 = i8 - i10;
            if (i11 != i12) {
                throw new WriterException("EC bytes mismatch");
            }
            if (i3 != i6 + i5) {
                throw new WriterException("RS blocks mismatch");
            }
            if (i != ((i9 + i11) * i6) + ((i10 + i12) * i5)) {
                throw new WriterException("Total bytes mismatch");
            }
            if (i4 < i6) {
                iArr[0] = i9;
                iArr2[0] = i11;
                return;
            }
            iArr[0] = i10;
            iArr2[0] = i12;
            return;
        }
        throw new WriterException("Block ID too large");
    }

    private static void p(int i, df0 df0Var, ug1 ug1Var, dy1 dy1Var) throws WriterException {
        dy1Var.k(df0Var);
        dy1Var.o(ug1Var);
        for (int i2 = 1; i2 <= 40; i2++) {
            ex2 e = ex2.e(i2);
            int d = e.d();
            ex2.b c = e.c(df0Var);
            int d2 = c.d();
            int c2 = c.c();
            int i3 = d - d2;
            if (i3 >= i + 3) {
                dy1Var.t(i2);
                dy1Var.s(d);
                dy1Var.p(i3);
                dy1Var.r(c2);
                dy1Var.q(d2);
                dy1Var.n(e.b());
                return;
            }
        }
        throw new WriterException("Cannot find proper rs block info (input data too big?)");
    }

    static void q(lc lcVar, int i, int i2, int i3, lc lcVar2) throws WriterException {
        if (lcVar.g() == i2) {
            Vector vector = new Vector(i3);
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < i3; i7++) {
                int[] iArr = new int[1];
                int[] iArr2 = new int[1];
                o(i, i2, i3, i7, iArr, iArr2);
                int i8 = iArr[0];
                byte[] bArr = new byte[i8];
                lcVar.i(i4 * 8, bArr, 0, i8);
                byte[] m = m(bArr, iArr2[0]);
                vector.addElement(new xc(bArr, m));
                i5 = Math.max(i5, i8);
                i6 = Math.max(i6, m.length);
                i4 += iArr[0];
            }
            if (i2 == i4) {
                for (int i9 = 0; i9 < i5; i9++) {
                    for (int i10 = 0; i10 < vector.size(); i10++) {
                        byte[] a2 = ((xc) vector.elementAt(i10)).a();
                        if (i9 < a2.length) {
                            lcVar2.c(a2[i9], 8);
                        }
                    }
                }
                for (int i11 = 0; i11 < i6; i11++) {
                    for (int i12 = 0; i12 < vector.size(); i12++) {
                        byte[] b = ((xc) vector.elementAt(i12)).b();
                        if (i11 < b.length) {
                            lcVar2.c(b[i11], 8);
                        }
                    }
                }
                if (i == lcVar2.g()) {
                    return;
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Interleaving error: ");
                stringBuffer.append(i);
                stringBuffer.append(" and ");
                stringBuffer.append(lcVar2.g());
                stringBuffer.append(" differ.");
                throw new WriterException(stringBuffer.toString());
            }
            throw new WriterException("Data bytes does not match offset");
        }
        throw new WriterException("Number of bits and data bytes does not match");
    }

    private static boolean r(String str) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i = 0; i < length; i += 2) {
                int i2 = bytes[i] & 255;
                if ((i2 < 129 || i2 > 159) && (i2 < 224 || i2 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    static void s(int i, lc lcVar) throws WriterException {
        int i2 = i << 3;
        if (lcVar.f() <= i2) {
            for (int i3 = 0; i3 < 4 && lcVar.f() < i2; i3++) {
                lcVar.a(false);
            }
            int f = lcVar.f() & 7;
            if (f > 0) {
                while (f < 8) {
                    lcVar.a(false);
                    f++;
                }
            }
            int g = i - lcVar.g();
            for (int i4 = 0; i4 < g; i4++) {
                lcVar.c((i4 & 1) == 0 ? 236 : 17, 8);
            }
            if (lcVar.f() != i2) {
                throw new WriterException("Bits size does not equal capacity");
            }
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("data bits cannot fit in the QR Code");
        stringBuffer.append(lcVar.f());
        stringBuffer.append(" > ");
        stringBuffer.append(i2);
        throw new WriterException(stringBuffer.toString());
    }
}
