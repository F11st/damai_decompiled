package tb;

import com.alibaba.wireless.security.SecExceptionCode;
import com.google.zxing.WriterException;
import com.youku.uplayer.AliMediaPlayer;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class sd1 {
    private static final int[][] a = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};
    private static final int[][] b = {new int[]{0, 0, 0, 0, 0, 0, 0, 0}};
    private static final int[][] c = {new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}};
    private static final int[][] d = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};
    private static final int[][] e = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, SecExceptionCode.SEC_ERROR_INIT_PLUGIN_CLASS_ERROR, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_SD_UP_GEAR_NEED_BUFFER}, new int[]{6, 28, 54, 80, 106, 132, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_DISALBE_ADAPT_SPEED}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, SecExceptionCode.SEC_ERROR_INIT_PLUGIN_CLASS_ERROR, 166}, new int[]{6, 30, 58, 86, 114, 142, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_NEXT_SEGMENT_SPEED_CALC_COUNT}};
    private static final int[][] f = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    public static void a(lc lcVar, df0 df0Var, int i, int i2, ne neVar) throws WriterException {
        c(neVar);
        d(i, neVar);
        l(df0Var, i2, neVar);
        t(i, neVar);
        f(lcVar, i2, neVar);
    }

    public static int b(int i, int i2) {
        int n = n(i2);
        int i3 = i << (n - 1);
        while (n(i3) >= n) {
            i3 ^= i2 << (n(i3) - n);
        }
        return i3;
    }

    public static void c(ne neVar) {
        neVar.a((byte) -1);
    }

    public static void d(int i, ne neVar) throws WriterException {
        j(neVar);
        e(neVar);
        s(i, neVar);
        k(neVar);
    }

    private static void e(ne neVar) throws WriterException {
        if (neVar.b(8, neVar.d() - 8) != 0) {
            neVar.f(8, neVar.d() - 8, 1);
            return;
        }
        throw new WriterException();
    }

    public static void f(lc lcVar, int i, ne neVar) throws WriterException {
        boolean z;
        int e2 = neVar.e() - 1;
        int d2 = neVar.d() - 1;
        int i2 = 0;
        int i3 = -1;
        while (e2 > 0) {
            if (e2 == 6) {
                e2--;
            }
            while (d2 >= 0 && d2 < neVar.d()) {
                for (int i4 = 0; i4 < 2; i4++) {
                    int i5 = e2 - i4;
                    if (o(neVar.b(i5, d2))) {
                        if (i2 < lcVar.f()) {
                            z = lcVar.e(i2);
                            i2++;
                        } else {
                            z = false;
                        }
                        if (i != -1 && jd1.f(i, i5, d2)) {
                            z = !z;
                        }
                        neVar.g(i5, d2, z);
                    }
                }
                d2 += i3;
            }
            i3 = -i3;
            d2 += i3;
            e2 -= 2;
        }
        if (i2 == lcVar.f()) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Not all bits consumed: ");
        stringBuffer.append(i2);
        stringBuffer.append(r10.DIR);
        stringBuffer.append(lcVar.f());
        throw new WriterException(stringBuffer.toString());
    }

    private static void g(int i, int i2, ne neVar) throws WriterException {
        int[][] iArr = b;
        if (iArr[0].length != 8 || iArr.length != 1) {
            throw new WriterException("Bad horizontal separation pattern");
        }
        for (int i3 = 0; i3 < 8; i3++) {
            int i4 = i + i3;
            if (o(neVar.b(i4, i2))) {
                neVar.f(i4, i2, b[0][i3]);
            } else {
                throw new WriterException();
            }
        }
    }

    private static void h(int i, int i2, ne neVar) throws WriterException {
        int[][] iArr = d;
        if (iArr[0].length != 5 || iArr.length != 5) {
            throw new WriterException("Bad position adjustment");
        }
        for (int i3 = 0; i3 < 5; i3++) {
            for (int i4 = 0; i4 < 5; i4++) {
                int i5 = i + i4;
                int i6 = i2 + i3;
                if (o(neVar.b(i5, i6))) {
                    neVar.f(i5, i6, d[i3][i4]);
                } else {
                    throw new WriterException();
                }
            }
        }
    }

    private static void i(int i, int i2, ne neVar) throws WriterException {
        int[][] iArr = a;
        if (iArr[0].length != 7 || iArr.length != 7) {
            throw new WriterException("Bad position detection pattern");
        }
        for (int i3 = 0; i3 < 7; i3++) {
            for (int i4 = 0; i4 < 7; i4++) {
                int i5 = i + i4;
                int i6 = i2 + i3;
                if (o(neVar.b(i5, i6))) {
                    neVar.f(i5, i6, a[i3][i4]);
                } else {
                    throw new WriterException();
                }
            }
        }
    }

    private static void j(ne neVar) throws WriterException {
        int length = a[0].length;
        i(0, 0, neVar);
        i(neVar.e() - length, 0, neVar);
        i(0, neVar.e() - length, neVar);
        int length2 = b[0].length;
        int i = length2 - 1;
        g(0, i, neVar);
        g(neVar.e() - length2, i, neVar);
        g(0, neVar.e() - length2, neVar);
        int length3 = c.length;
        m(length3, 0, neVar);
        m((neVar.d() - length3) - 1, 0, neVar);
        m(length3, neVar.d() - length3, neVar);
    }

    private static void k(ne neVar) throws WriterException {
        int i = 8;
        while (i < neVar.e() - 8) {
            int i2 = i + 1;
            int i3 = i2 % 2;
            if (p(neVar.b(i, 6))) {
                if (o(neVar.b(i, 6))) {
                    neVar.f(i, 6, i3);
                }
                if (p(neVar.b(6, i))) {
                    if (o(neVar.b(6, i))) {
                        neVar.f(6, i, i3);
                    }
                    i = i2;
                } else {
                    throw new WriterException();
                }
            } else {
                throw new WriterException();
            }
        }
    }

    public static void l(df0 df0Var, int i, ne neVar) throws WriterException {
        lc lcVar = new lc();
        q(df0Var, i, lcVar);
        for (int i2 = 0; i2 < lcVar.f(); i2++) {
            boolean e2 = lcVar.e((lcVar.f() - 1) - i2);
            int[][] iArr = f;
            neVar.g(iArr[i2][0], iArr[i2][1], e2);
            if (i2 < 8) {
                neVar.g((neVar.e() - i2) - 1, 8, e2);
            } else {
                neVar.g(8, (neVar.d() - 7) + (i2 - 8), e2);
            }
        }
    }

    private static void m(int i, int i2, ne neVar) throws WriterException {
        int[][] iArr = c;
        if (iArr[0].length != 1 || iArr.length != 7) {
            throw new WriterException("Bad vertical separation pattern");
        }
        for (int i3 = 0; i3 < 7; i3++) {
            int i4 = i2 + i3;
            if (o(neVar.b(i, i4))) {
                neVar.f(i, i4, c[i3][0]);
            } else {
                throw new WriterException();
            }
        }
    }

    public static int n(int i) {
        int i2 = 0;
        while (i != 0) {
            i >>>= 1;
            i2++;
        }
        return i2;
    }

    private static boolean o(int i) {
        return i == -1;
    }

    private static boolean p(int i) {
        return i == -1 || i == 0 || i == 1;
    }

    public static void q(df0 df0Var, int i, lc lcVar) throws WriterException {
        if (dy1.j(i)) {
            int a2 = (df0Var.a() << 3) | i;
            lcVar.c(a2, 5);
            lcVar.c(b(a2, 1335), 10);
            lc lcVar2 = new lc();
            lcVar2.c(21522, 15);
            lcVar.j(lcVar2);
            if (lcVar.f() == 15) {
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("should not happen but we got: ");
            stringBuffer.append(lcVar.f());
            throw new WriterException(stringBuffer.toString());
        }
        throw new WriterException("Invalid mask pattern");
    }

    public static void r(int i, lc lcVar) throws WriterException {
        lcVar.c(i, 6);
        lcVar.c(b(i, 7973), 12);
        if (lcVar.f() == 18) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("should not happen but we got: ");
        stringBuffer.append(lcVar.f());
        throw new WriterException(stringBuffer.toString());
    }

    private static void s(int i, ne neVar) throws WriterException {
        if (i < 2) {
            return;
        }
        int i2 = i - 1;
        int[][] iArr = e;
        int[] iArr2 = iArr[i2];
        int length = iArr[i2].length;
        for (int i3 = 0; i3 < length; i3++) {
            for (int i4 = 0; i4 < length; i4++) {
                int i5 = iArr2[i3];
                int i6 = iArr2[i4];
                if (i6 != -1 && i5 != -1 && o(neVar.b(i6, i5))) {
                    h(i6 - 2, i5 - 2, neVar);
                }
            }
        }
    }

    public static void t(int i, ne neVar) throws WriterException {
        if (i < 7) {
            return;
        }
        lc lcVar = new lc();
        r(i, lcVar);
        int i2 = 17;
        for (int i3 = 0; i3 < 6; i3++) {
            for (int i4 = 0; i4 < 3; i4++) {
                boolean e2 = lcVar.e(i2);
                i2--;
                neVar.g(i3, (neVar.d() - 11) + i4, e2);
                neVar.g((neVar.d() - 11) + i4, i3, e2);
            }
        }
    }
}
