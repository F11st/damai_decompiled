package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.math.BigInteger;
import java.util.Comparator;
import tb.du1;

/* compiled from: Taobao */
@Beta
@GwtCompatible
/* loaded from: classes10.dex */
public final class UnsignedLongs {
    public static final long MAX_VALUE = -1;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    enum LexicographicalComparator implements Comparator<long[]> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "UnsignedLongs.lexicographicalComparator()";
        }

        @Override // java.util.Comparator
        public int compare(long[] jArr, long[] jArr2) {
            int min = Math.min(jArr.length, jArr2.length);
            for (int i = 0; i < min; i++) {
                if (jArr[i] != jArr2[i]) {
                    return UnsignedLongs.a(jArr[i], jArr2[i]);
                }
            }
            return jArr.length - jArr2.length;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.common.primitives.UnsignedLongs$a */
    /* loaded from: classes10.dex */
    private static final class C5255a {
        static final long[] a = new long[37];
        static final int[] b = new int[37];
        static final int[] c = new int[37];

        static {
            BigInteger bigInteger = new BigInteger("10000000000000000", 16);
            for (int i = 2; i <= 36; i++) {
                long j = i;
                a[i] = UnsignedLongs.b(-1L, j);
                b[i] = (int) UnsignedLongs.e(-1L, j);
                c[i] = bigInteger.toString(i).length() - 1;
            }
        }

        static boolean a(long j, int i, int i2) {
            if (j >= 0) {
                long[] jArr = a;
                if (j < jArr[i2]) {
                    return false;
                }
                return j > jArr[i2] || i > b[i2];
            }
            return true;
        }
    }

    public static int a(long j, long j2) {
        return Longs.c(c(j), c(j2));
    }

    public static long b(long j, long j2) {
        if (j2 < 0) {
            return a(j, j2) < 0 ? 0L : 1L;
        } else if (j >= 0) {
            return j / j2;
        } else {
            long j3 = ((j >>> 1) / j2) << 1;
            return j3 + (a(j - (j3 * j2), j2) < 0 ? 0 : 1);
        }
    }

    private static long c(long j) {
        return j ^ Long.MIN_VALUE;
    }

    @CanIgnoreReturnValue
    public static long d(String str, int i) {
        du1.p(str);
        if (str.length() != 0) {
            if (i >= 2 && i <= 36) {
                int i2 = C5255a.c[i] - 1;
                long j = 0;
                for (int i3 = 0; i3 < str.length(); i3++) {
                    int digit = Character.digit(str.charAt(i3), i);
                    if (digit != -1) {
                        if (i3 > i2 && C5255a.a(j, digit, i)) {
                            throw new NumberFormatException("Too large for unsigned long: " + str);
                        }
                        j = (j * i) + digit;
                    } else {
                        throw new NumberFormatException(str);
                    }
                }
                return j;
            }
            throw new NumberFormatException("illegal radix: " + i);
        }
        throw new NumberFormatException("empty string");
    }

    public static long e(long j, long j2) {
        if (j2 < 0) {
            return a(j, j2) < 0 ? j : j - j2;
        } else if (j >= 0) {
            return j % j2;
        } else {
            long j3 = j - ((((j >>> 1) / j2) << 1) * j2);
            if (a(j3, j2) < 0) {
                j2 = 0;
            }
            return j3 - j2;
        }
    }

    public static String f(long j) {
        return g(j, 10);
    }

    public static String g(long j, int i) {
        long b;
        du1.f(i >= 2 && i <= 36, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", i);
        int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i2 == 0) {
            return "0";
        }
        if (i2 > 0) {
            return Long.toString(j, i);
        }
        int i3 = 64;
        char[] cArr = new char[64];
        int i4 = i - 1;
        if ((i & i4) == 0) {
            int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i);
            do {
                i3--;
                cArr[i3] = Character.forDigit(((int) j) & i4, i);
                j >>>= numberOfTrailingZeros;
            } while (j != 0);
        } else {
            if ((i & 1) == 0) {
                b = (j >>> 1) / (i >>> 1);
            } else {
                b = b(j, i);
            }
            long j2 = i;
            cArr[63] = Character.forDigit((int) (j - (b * j2)), i);
            i3 = 63;
            while (b > 0) {
                i3--;
                cArr[i3] = Character.forDigit((int) (b % j2), i);
                b /= j2;
            }
        }
        return new String(cArr, i3, 64 - i3);
    }
}
