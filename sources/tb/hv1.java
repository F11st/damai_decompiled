package tb;

import kotlin.PublishedApi;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class hv1 {
    private static final int a(int i, int i2, int i3) {
        return e(e(i, i3) - e(i2, i3), i3);
    }

    private static final long b(long j, long j2, long j3) {
        return f(f(j, j3) - f(j2, j3), j3);
    }

    @PublishedApi
    public static final int c(int i, int i2, int i3) {
        if (i3 > 0) {
            return i >= i2 ? i2 : i2 - a(i2, i, i3);
        } else if (i3 < 0) {
            return i <= i2 ? i2 : i2 + a(i, i2, -i3);
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
    }

    @PublishedApi
    public static final long d(long j, long j2, long j3) {
        int i = (j3 > 0L ? 1 : (j3 == 0L ? 0 : -1));
        if (i > 0) {
            return j >= j2 ? j2 : j2 - b(j2, j, j3);
        } else if (i < 0) {
            return j <= j2 ? j2 : j2 + b(j, j2, -j3);
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
    }

    private static final int e(int i, int i2) {
        int i3 = i % i2;
        return i3 >= 0 ? i3 : i3 + i2;
    }

    private static final long f(long j, long j2) {
        long j3 = j % j2;
        return j3 >= 0 ? j3 : j3 + j2;
    }
}
