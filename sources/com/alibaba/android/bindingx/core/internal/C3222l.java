package com.alibaba.android.bindingx.core.internal;

import androidx.annotation.Nullable;

/* compiled from: Taobao */
/* renamed from: com.alibaba.android.bindingx.core.internal.l */
/* loaded from: classes5.dex */
class C3222l {
    double a;
    double b;
    double c;
    double d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3222l() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3222l a(C3222l c3222l) {
        return b(this, c3222l);
    }

    C3222l b(C3222l c3222l, C3222l c3222l2) {
        double d = c3222l.a;
        double d2 = c3222l.b;
        double d3 = c3222l.c;
        double d4 = c3222l.d;
        double d5 = c3222l2.a;
        double d6 = c3222l2.b;
        double d7 = c3222l2.c;
        double d8 = c3222l2.d;
        this.a = (((d * d8) + (d4 * d5)) + (d2 * d7)) - (d3 * d6);
        this.b = (((d2 * d8) + (d4 * d6)) + (d3 * d5)) - (d * d7);
        this.c = (((d3 * d8) + (d4 * d7)) + (d * d6)) - (d2 * d5);
        this.d = (((d4 * d8) - (d * d5)) - (d2 * d6)) - (d3 * d7);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3222l c(C3228p c3228p, double d) {
        double d2 = d / 2.0d;
        double sin = Math.sin(d2);
        this.a = c3228p.a * sin;
        this.b = c3228p.b * sin;
        this.c = c3228p.c * sin;
        this.d = Math.cos(d2);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public C3222l d(C3218h c3218h) {
        if (c3218h == null || !c3218h.e) {
            return null;
        }
        double cos = Math.cos(c3218h.b / 2.0d);
        double cos2 = Math.cos(c3218h.c / 2.0d);
        double cos3 = Math.cos(c3218h.d / 2.0d);
        double sin = Math.sin(c3218h.b / 2.0d);
        double sin2 = Math.sin(c3218h.c / 2.0d);
        double sin3 = Math.sin(c3218h.d / 2.0d);
        String str = c3218h.a;
        if ("XYZ".equals(str)) {
            double d = sin * cos2;
            double d2 = cos * sin2;
            this.a = (d * cos3) + (d2 * sin3);
            this.b = (d2 * cos3) - (d * sin3);
            double d3 = cos * cos2;
            double d4 = sin * sin2;
            this.c = (d3 * sin3) + (d4 * cos3);
            this.d = (d3 * cos3) - (d4 * sin3);
        } else if ("YXZ".equals(str)) {
            double d5 = sin * cos2;
            double d6 = cos * sin2;
            this.a = (d5 * cos3) + (d6 * sin3);
            this.b = (d6 * cos3) - (d5 * sin3);
            double d7 = cos * cos2;
            double d8 = sin * sin2;
            this.c = (d7 * sin3) - (d8 * cos3);
            this.d = (d7 * cos3) + (d8 * sin3);
        } else if ("ZXY".equals(str)) {
            double d9 = sin * cos2;
            double d10 = cos * sin2;
            this.a = (d9 * cos3) - (d10 * sin3);
            this.b = (d10 * cos3) + (d9 * sin3);
            double d11 = cos * cos2;
            double d12 = sin * sin2;
            this.c = (d11 * sin3) + (d12 * cos3);
            this.d = (d11 * cos3) - (d12 * sin3);
        } else if ("ZYX".equals(str)) {
            double d13 = sin * cos2;
            double d14 = cos * sin2;
            this.a = (d13 * cos3) - (d14 * sin3);
            this.b = (d14 * cos3) + (d13 * sin3);
            double d15 = cos * cos2;
            double d16 = sin * sin2;
            this.c = (d15 * sin3) - (d16 * cos3);
            this.d = (d15 * cos3) + (d16 * sin3);
        } else if ("YZX".equals(str)) {
            double d17 = sin * cos2;
            double d18 = cos * sin2;
            this.a = (d17 * cos3) + (d18 * sin3);
            this.b = (d18 * cos3) + (d17 * sin3);
            double d19 = cos * cos2;
            double d20 = sin * sin2;
            this.c = (d19 * sin3) - (d20 * cos3);
            this.d = (d19 * cos3) - (d20 * sin3);
        } else if ("XZY".equals(str)) {
            double d21 = sin * cos2;
            double d22 = cos * sin2;
            this.a = (d21 * cos3) - (d22 * sin3);
            this.b = (d22 * cos3) - (d21 * sin3);
            double d23 = cos * cos2;
            double d24 = sin * sin2;
            this.c = (d23 * sin3) + (d24 * cos3);
            this.d = (d23 * cos3) + (d24 * sin3);
        }
        return this;
    }

    public String toString() {
        return "Quaternion{x=" + this.a + ", y=" + this.b + ", z=" + this.c + ", w=" + this.d + '}';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3222l(double d, double d2, double d3, double d4) {
        this.a = d;
        this.b = d2;
        this.c = d3;
        this.d = d4;
    }
}
