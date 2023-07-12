package com.google.common.math;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.math.RoundingMode;

/* compiled from: Taobao */
@GwtCompatible(emulated = true)
/* renamed from: com.google.common.math.a */
/* loaded from: classes10.dex */
public final class C5235a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.math.a$a */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class C5236a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[RoundingMode.FLOOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[RoundingMode.CEILING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[RoundingMode.DOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[RoundingMode.UP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[RoundingMode.HALF_EVEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[RoundingMode.HALF_DOWN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    static {
        Math.log(2.0d);
    }

    @GwtIncompatible
    public static boolean a(double d) {
        return C5237b.c(d) && (d == 0.0d || 52 - Long.numberOfTrailingZeros(C5237b.b(d)) <= Math.getExponent(d));
    }

    @GwtIncompatible
    static double b(double d, RoundingMode roundingMode) {
        if (C5237b.c(d)) {
            switch (C5236a.a[roundingMode.ordinal()]) {
                case 1:
                    C5246e.d(a(d));
                    return d;
                case 2:
                    return (d >= 0.0d || a(d)) ? d : ((long) d) - 1;
                case 3:
                    return (d <= 0.0d || a(d)) ? d : ((long) d) + 1;
                case 4:
                    return d;
                case 5:
                    if (a(d)) {
                        return d;
                    }
                    return ((long) d) + (d > 0.0d ? 1 : -1);
                case 6:
                    return Math.rint(d);
                case 7:
                    double rint = Math.rint(d);
                    return Math.abs(d - rint) == 0.5d ? d + Math.copySign(0.5d, d) : rint;
                case 8:
                    double rint2 = Math.rint(d);
                    return Math.abs(d - rint2) == 0.5d ? d : rint2;
                default:
                    throw new AssertionError();
            }
        }
        throw new ArithmeticException("input is infinite or NaN");
    }

    @GwtIncompatible
    public static long c(double d, RoundingMode roundingMode) {
        double b = b(d, roundingMode);
        C5246e.a(((-9.223372036854776E18d) - b < 1.0d) & (b < 9.223372036854776E18d), d, roundingMode);
        return (long) b;
    }
}
