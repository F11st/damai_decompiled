package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.primitives.Doubles;
import java.util.Iterator;

/* compiled from: Taobao */
@Beta
@GwtIncompatible
/* renamed from: com.google.common.math.f */
/* loaded from: classes10.dex */
public final class C5247f {
    private long a = 0;
    private double b = 0.0d;
    private double c = 0.0d;
    private double d = Double.NaN;
    private double e = Double.NaN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double g(double d, double d2) {
        if (Doubles.f(d)) {
            return d2;
        }
        if (Doubles.f(d2) || d == d2) {
            return d;
        }
        return Double.NaN;
    }

    public void a(double d) {
        long j = this.a;
        if (j == 0) {
            this.a = 1L;
            this.b = d;
            this.d = d;
            this.e = d;
            if (Doubles.f(d)) {
                return;
            }
            this.c = Double.NaN;
            return;
        }
        this.a = j + 1;
        if (Doubles.f(d) && Doubles.f(this.b)) {
            double d2 = this.b;
            double d3 = d - d2;
            double d4 = d2 + (d3 / this.a);
            this.b = d4;
            this.c += d3 * (d - d4);
        } else {
            this.b = g(this.b, d);
            this.c = Double.NaN;
        }
        this.d = Math.min(this.d, d);
        this.e = Math.max(this.e, d);
    }

    public void b(Iterable<? extends Number> iterable) {
        for (Number number : iterable) {
            a(number.doubleValue());
        }
    }

    public void c(Iterator<? extends Number> it) {
        while (it.hasNext()) {
            a(it.next().doubleValue());
        }
    }

    public void d(double... dArr) {
        for (double d : dArr) {
            a(d);
        }
    }

    public void e(int... iArr) {
        for (int i : iArr) {
            a(i);
        }
    }

    public void f(long... jArr) {
        for (long j : jArr) {
            a(j);
        }
    }

    public Stats h() {
        return new Stats(this.a, this.b, this.c, this.d, this.e);
    }
}
