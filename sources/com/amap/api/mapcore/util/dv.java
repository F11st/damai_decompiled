package com.amap.api.mapcore.util;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class dv {
    private short[] b;
    private double[] c;
    private int d;
    private final em a = new em();
    private final eb e = new eb();
    private final em f = new em();

    private int b() {
        int i = this.d;
        for (int i2 = 0; i2 < i; i2++) {
            if (b(i2)) {
                return i2;
            }
        }
        int[] iArr = this.e.a;
        for (int i3 = 0; i3 < i; i3++) {
            if (iArr[i3] != -1) {
                return i3;
            }
        }
        return 0;
    }

    private void c(int i) {
        short[] sArr = this.b;
        em emVar = this.f;
        emVar.a(sArr[d(i)]);
        emVar.a(sArr[i]);
        emVar.a(sArr[e(i)]);
        this.a.b(i);
        this.e.b(i);
        this.d--;
    }

    private int d(int i) {
        if (i == 0) {
            i = this.d;
        }
        return i - 1;
    }

    private int e(int i) {
        return (i + 1) % this.d;
    }

    public em a(double[] dArr) {
        return a(dArr, 0, dArr.length);
    }

    public em a(double[] dArr, int i, int i2) {
        this.c = dArr;
        int i3 = i2 / 2;
        this.d = i3;
        int i4 = i / 2;
        em emVar = this.a;
        emVar.a();
        emVar.c(i3);
        emVar.b = i3;
        short[] sArr = emVar.a;
        this.b = sArr;
        int i5 = i3 - 1;
        for (int i6 = 0; i6 < i3; i6++) {
            sArr[i6] = (short) ((i4 + i5) - i6);
        }
        eb ebVar = this.e;
        ebVar.a();
        ebVar.c(i3);
        for (int i7 = 0; i7 < i3; i7++) {
            ebVar.a(a(i7));
        }
        em emVar2 = this.f;
        emVar2.a();
        emVar2.c(Math.max(0, i3 - 2) * 3);
        a();
        return emVar2;
    }

    private boolean b(int i) {
        int[] iArr = this.e.a;
        if (iArr[i] == -1) {
            return false;
        }
        int d = d(i);
        int e = e(i);
        short[] sArr = this.b;
        int i2 = sArr[d] * 2;
        int i3 = sArr[i] * 2;
        int i4 = sArr[e] * 2;
        double[] dArr = this.c;
        double d2 = dArr[i2];
        int i5 = 1;
        double d3 = dArr[i2 + 1];
        double d4 = dArr[i3];
        double d5 = dArr[i3 + 1];
        double d6 = dArr[i4];
        double d7 = dArr[i4 + 1];
        int e2 = e(e);
        while (e2 != d) {
            if (iArr[e2] != i5) {
                int i6 = sArr[e2] * 2;
                double d8 = dArr[i6];
                double d9 = dArr[i6 + i5];
                if (a(d6, d7, d2, d3, d8, d9) >= 0 && a(d2, d3, d4, d5, d8, d9) >= 0 && a(d4, d5, d6, d7, d8, d9) >= 0) {
                    return false;
                }
            }
            e2 = e(e2);
            i5 = 1;
        }
        return true;
    }

    private void a() {
        int i;
        int[] iArr = this.e.a;
        while (true) {
            i = this.d;
            int i2 = 0;
            if (i <= 3) {
                break;
            }
            int b = b();
            c(b);
            int d = d(b);
            if (b != this.d) {
                i2 = b;
            }
            iArr[d] = a(d);
            iArr[i2] = a(i2);
        }
        if (i == 3) {
            em emVar = this.f;
            short[] sArr = this.b;
            emVar.a(sArr[0]);
            emVar.a(sArr[1]);
            emVar.a(sArr[2]);
        }
    }

    private int a(int i) {
        short[] sArr = this.b;
        int i2 = sArr[d(i)] * 2;
        int i3 = sArr[i] * 2;
        int i4 = sArr[e(i)] * 2;
        double[] dArr = this.c;
        return a(dArr[i2], dArr[i2 + 1], dArr[i3], dArr[i3 + 1], dArr[i4], dArr[i4 + 1]);
    }

    private static int a(double d, double d2, double d3, double d4, double d5, double d6) {
        return (int) Math.signum((d * (d6 - d4)) + (d3 * (d2 - d6)) + (d5 * (d4 - d2)));
    }
}
