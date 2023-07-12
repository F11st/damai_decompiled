package tb;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class ty1 extends sy1 {
    public static int a(int i, int i2) {
        return i < i2 ? i2 : i;
    }

    public static long b(long j, long j2) {
        return j < j2 ? j2 : j;
    }

    public static float c(float f, float f2) {
        return f > f2 ? f2 : f;
    }

    public static int d(int i, int i2) {
        return i > i2 ? i2 : i;
    }

    public static long e(long j, long j2) {
        return j > j2 ? j2 : j;
    }

    public static int f(int i, int i2, int i3) {
        if (i2 <= i3) {
            return i < i2 ? i2 : i > i3 ? i3 : i;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i3 + " is less than minimum " + i2 + '.');
    }

    @NotNull
    public static l31 g(int i, int i2) {
        return l31.Companion.a(i, i2, -1);
    }

    @NotNull
    public static n31 h(int i, int i2) {
        if (i2 <= Integer.MIN_VALUE) {
            return n31.Companion.a();
        }
        return new n31(i, i2 - 1);
    }
}
