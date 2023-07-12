package tb;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

/* compiled from: Taobao */
@GwtIncompatible
/* loaded from: classes10.dex */
public final class cu2 {
    public static final byte MAX_POWER_OF_TWO = Byte.MIN_VALUE;
    public static final byte MAX_VALUE = -1;

    @CanIgnoreReturnValue
    public static byte a(long j) {
        du1.h((j >> 8) == 0, "out of range: %s", j);
        return (byte) j;
    }

    public static int b(byte b, byte b2) {
        return c(b) - c(b2);
    }

    public static int c(byte b) {
        return b & 255;
    }
}
