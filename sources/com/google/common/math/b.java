package com.google.common.math;

import com.google.common.annotations.GwtIncompatible;
import tb.du1;

/* compiled from: Taobao */
@GwtIncompatible
/* loaded from: classes10.dex */
final class b {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static double a(double d) {
        du1.d(!Double.isNaN(d));
        if (d > 0.0d) {
            return d;
        }
        return 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long b(double d) {
        du1.e(c(d), "not a normal value");
        int exponent = Math.getExponent(d);
        long doubleToRawLongBits = Double.doubleToRawLongBits(d) & 4503599627370495L;
        return exponent == -1023 ? doubleToRawLongBits << 1 : doubleToRawLongBits | 4503599627370496L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(double d) {
        return Math.getExponent(d) <= 1023;
    }
}
